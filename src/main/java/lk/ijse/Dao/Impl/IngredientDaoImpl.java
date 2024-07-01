package lk.ijse.Dao.Impl;

import lk.ijse.DB.DbConnection;
import lk.ijse.Dao.Custom.IngredientsDao;
import lk.ijse.Dao.SQLUtil;
import lk.ijse.Entity.Ingredient;
import lk.ijse.Model.IngredientModel;

import java.sql.Connection;
import java.sql.PreparedStatement;
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
        return SQLUtil.execute("UPDATE Ingredient SET Description = ?,Qty_On_Hand = ?,S_ID = ? WHERE I_ID = ?",Entity.getDescription(),Entity.getQty_On_Hand(),Entity.getSupplier(),Entity.getI_ID());
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
@Override
    public  ArrayList<IngredientModel> searchIID(String iid){
        ArrayList<IngredientModel> ingredientModels = new ArrayList<>();
        try {
            Connection connection = DbConnection.getInstance().getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM Ingredient WHERE I_ID = ?");
            preparedStatement.setString(1,iid);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                IngredientModel ingredientModel = new IngredientModel(resultSet.getString(1),resultSet.getString(2),resultSet.getString(3),resultSet.getString(4));
                ingredientModels.add(ingredientModel);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return ingredientModels;
    }

}
