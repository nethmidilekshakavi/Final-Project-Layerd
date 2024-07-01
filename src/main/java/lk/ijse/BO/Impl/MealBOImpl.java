package lk.ijse.BO.Impl;

import lk.ijse.BO.Custom.MealBO;
import lk.ijse.Dao.Custom.MealDao;
import lk.ijse.Dao.DaoFactory;
import lk.ijse.Entity.Meal;
import lk.ijse.Model.MealModel;

import java.sql.SQLException;
import java.util.ArrayList;

public class MealBOImpl implements MealBO {
    MealDao mealDao = (MealDao) DaoFactory.getDaoFactory().getDAO(DaoFactory.DAOTypes.MEAL);
    @Override
    public ArrayList<MealModel> getAllMeal() throws SQLException, ClassNotFoundException {
        ArrayList<MealModel> allmeal= new ArrayList<>();
        ArrayList<Meal> all = mealDao.getAll();
        for (Meal c : all) {
            allmeal.add(new MealModel(c.getMID(),c.getName(),c.getPrice()));
        }
        return allmeal;
    }
    @Override
    public boolean saveMeal(MealModel mealModel) throws SQLException, ClassNotFoundException {
        return mealDao.Save(new Meal(mealModel.getMID(),mealModel.getName(),mealModel.getPrice()));
    }

    @Override
    public boolean updateCustomer(MealModel mealModel) throws SQLException, ClassNotFoundException {
        return mealDao.update(new Meal(mealModel.getMID(),mealModel.getName(),mealModel.getPrice()));
    }

    @Override
    public boolean deleteCustomer(String id) throws SQLException, ClassNotFoundException {
        return mealDao.delete(id);
    }
    @Override
    public Meal serchbyIDS(String code) throws SQLException, ClassNotFoundException {
        return mealDao.searchById(code);
    }


}
