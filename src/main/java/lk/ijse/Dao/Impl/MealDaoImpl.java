package lk.ijse.Dao.Impl;

import lk.ijse.Dao.Custom.MealDao;
import lk.ijse.Dao.SQLUtil;
import lk.ijse.Entity.Meal;

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
        return SQLUtil.execute("UPDATE Meal SET Name = ?, Meal_Price = ? WHERE M_ID = ?",Entity.getMID(),Entity.getName(),Entity.getPrice());
    }
    @Override
    public boolean Delete(String id) throws SQLException, ClassNotFoundException {
        return SQLUtil.execute("delete from Meal where M_ID=?",id);

    }

    @Override
    public Meal searchById(String code) throws SQLException, ClassNotFoundException {
        ResultSet rst  = SQLUtil.execute("SELECT * FROM Meal WHERE M_ID = ?",code+"");
        rst.next();
        return new Meal(code + "", rst.getString(2));
    }
@Override
    public ArrayList<Meal> getIds() throws SQLException, ClassNotFoundException {
        ArrayList<Meal> allMeal = new ArrayList<>();
        ResultSet resultSet = SQLUtil.execute("SELECT M_ID FROM Meal");
        while (resultSet.next()) {
            Meal meal = new Meal(resultSet.getString(1),resultSet.getString(2));
            allMeal.add(meal);
        }
        return allMeal;
    }

}
