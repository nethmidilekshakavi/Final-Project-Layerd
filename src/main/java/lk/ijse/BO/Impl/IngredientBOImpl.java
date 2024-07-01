package lk.ijse.BO.Impl;

import lk.ijse.BO.Custom.IngredientBO;
import lk.ijse.Dao.Custom.IngredientsDao;
import lk.ijse.Dao.DaoFactory;
import lk.ijse.Entity.Ingredient;
import lk.ijse.Model.IngredientModel;

import java.sql.SQLException;
import java.util.ArrayList;

public class IngredientBOImpl implements IngredientBO {
    IngredientsDao ingredientsDao = (IngredientsDao) DaoFactory.getDaoFactory().getDAO(DaoFactory.DAOTypes.INGREDIENTS);
    @Override
    public ArrayList<IngredientModel> getAllIngredients() throws SQLException, ClassNotFoundException {
        ArrayList<IngredientModel> allIngredient= new ArrayList<>();
        ArrayList<Ingredient> all = ingredientsDao.getAll();
        for (Ingredient i : all) {
            allIngredient.add(new IngredientModel(i.getI_ID(),i.getDescription(),i.getQty_On_Hand(),i.getSupplier()));
        }
        return allIngredient;
    }
    @Override
    public boolean saveIngredients(IngredientModel entity) throws SQLException, ClassNotFoundException {
        return ingredientsDao.Save(new Ingredient(entity.getI_ID(),entity.getDescription(),entity.getQty_On_Hand(),entity.getSupplier()));
    }

    @Override
    public boolean updateIngredients(IngredientModel entity) throws SQLException, ClassNotFoundException {
        return ingredientsDao.update(new Ingredient(entity.getDescription(),entity.getQty_On_Hand(),entity.getSupplier(),entity.getI_ID()));
    }

    @Override
    public boolean deleteIngredients(String id) throws SQLException, ClassNotFoundException {
        return ingredientsDao.delete(id);
    }

}
