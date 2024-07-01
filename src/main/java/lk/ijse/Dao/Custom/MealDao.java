package lk.ijse.Dao.Custom;

import lk.ijse.Dao.CrudDao;
import lk.ijse.Entity.Meal;
import lk.ijse.Model.MealModel;

import java.sql.SQLException;
import java.util.ArrayList;

public interface MealDao extends CrudDao<Meal> {
    ArrayList<Meal> getAll() throws SQLException, ClassNotFoundException;

    boolean Save(Meal Entity) throws SQLException, ClassNotFoundException;

    boolean Update(Meal Entity) throws SQLException, ClassNotFoundException;

    boolean Delete(String id) throws SQLException, ClassNotFoundException;


    ArrayList<MealModel> searchMID(String mid);

    MealModel searchById(String id) throws SQLException;
}
