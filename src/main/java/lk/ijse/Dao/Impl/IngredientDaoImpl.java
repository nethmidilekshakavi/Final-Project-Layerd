package lk.ijse.Dao.Impl;

import lk.ijse.Dao.Custom.IngredientsDao;
import lk.ijse.Dao.SQLUtil;
import lk.ijse.Entity.Ingredient;
import lk.ijse.Entity.Meal;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class IngredientDaoImpl implements IngredientsDao {
    @Override
    public boolean Save(Ingredient Entity) throws SQLException, ClassNotFoundException {

        return SQLUtil.execute("INSERT INTO Ingredient VALUES(?, ?, ?,?)", Entity.getI_ID(),Entity.getDescription(),Entity.getQty_On_Hand(),Entity.getSupplier());

    }

    @Override
    public boolean Update(Ingredient Entity) throws SQLException, ClassNotFoundException {
        return SQLUtil.execute("UPDATE Ingredient SET I_ID = ?,Descrption = ?,Qty_On_Hand = ?,S_ID = ?",Entity.getDescription(),Entity.getQty_On_Hand(),Entity.getSupplier(),Entity.getI_ID());
    }
    @Override
    public boolean Delete(String id) throws SQLException, ClassNotFoundException {
        return SQLUtil.execute("delete from Ingredient where I_ID=?",id);

    }

    @Override
    public ArrayList<Ingredient> getAll() throws SQLException, ClassNotFoundException {
        ArrayList<Ingredient> allIngredient = new ArrayList<>();
        ResultSet resultSet = SQLUtil.execute("select * from Ingredient");
        while (resultSet.next()) {
            Ingredient ingredient = new Ingredient(resultSet.getString(1),resultSet.getString(2),resultSet.getString(3),resultSet.getString(4));
            allIngredient.add(ingredient);
        }
        return allIngredient;
    }

    @Override
    public boolean save(Ingredient entity) throws SQLException, ClassNotFoundException {
        return false;
    }

    @Override
    public boolean update(Ingredient entity) throws SQLException, ClassNotFoundException {
        return false;
    }

    @Override
    public boolean delete(String id) throws SQLException, ClassNotFoundException {
        return false;
    }

    @Override
    public Ingredient search(String id) throws SQLException, ClassNotFoundException {
        return null;
    }


}
