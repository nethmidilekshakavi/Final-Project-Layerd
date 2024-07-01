package lk.ijse.Dao.Impl;

import lk.ijse.DB.DbConnection;
import lk.ijse.Dao.Custom.MealDao;
import lk.ijse.Dao.SQLUtil;
import lk.ijse.Entity.Meal;
import lk.ijse.Model.MealModel;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class MealDaoImpl implements MealDao {
    @Override
    public ArrayList<Meal> getAll() throws SQLException, ClassNotFoundException {
        ArrayList<Meal> allMeal = new ArrayList<>();
        ResultSet resultSet = SQLUtil.execute("select * from Meal");
        while (resultSet.next()) {
            Meal meal = new Meal(resultSet.getString(1),resultSet.getString(2),resultSet.getString(3));
            allMeal.add(meal);
        }
        return allMeal;
    }

    @Override
    public boolean save(Meal entity) throws SQLException, ClassNotFoundException {
        return false;
    }

    @Override
    public boolean update(Meal entity) throws SQLException, ClassNotFoundException {
        return false;
    }

    @Override
    public boolean delete(String id) throws SQLException, ClassNotFoundException {
        return false;
    }

    @Override
    public Meal search(String id) throws SQLException, ClassNotFoundException {
        return null;
    }

    @Override
    public boolean Save(Meal Entity) throws SQLException, ClassNotFoundException {

        return SQLUtil.execute("INSERT INTO Meal VALUES(?, ?, ?)", Entity.getMID(),Entity.getName(),Entity.getPrice());

    }

    @Override
    public boolean Update(Meal Entity) throws SQLException, ClassNotFoundException {
        return SQLUtil.execute("UPDATE Meal SET Name = ?, Meal_Price = ? WHERE M_ID = ?",Entity.getName(),Entity.getPrice(),Entity.getMID());
    }
    @Override
    public boolean Delete(String id) throws SQLException, ClassNotFoundException {
        return SQLUtil.execute("delete from Meal where M_ID=?",id);

    }
@Override
    public  ArrayList<MealModel> searchMID (String mid){
        ArrayList<MealModel> mealModels = new ArrayList<>();
        try {
            Connection connection = DbConnection.getInstance().getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM Meal WHERE M_ID = ?");
            preparedStatement.setString(1,mid);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                MealModel mealModel = new MealModel(resultSet.getString(1),resultSet.getString(2),resultSet.getString(3));
                mealModels.add(mealModel);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return mealModels;
    }
@Override
    public  MealModel searchById(String id) throws SQLException {
        String sql = "SELECT * FROM Meal WHERE M_ID = ?";

        Connection connection = DbConnection.getInstance().getConnection();
        PreparedStatement pstm = connection.prepareStatement(sql);
        pstm.setString(1, id);

        ResultSet resultSet = pstm.executeQuery();
        if (resultSet.next()) {
            String M_ID = resultSet.getString(1);
            String Name = resultSet.getString(2);
            String Price = resultSet.getString(3);
            MealModel mealModel = new MealModel(M_ID, Name, Price);

            return mealModel;
        }

        return null;
    }

}
