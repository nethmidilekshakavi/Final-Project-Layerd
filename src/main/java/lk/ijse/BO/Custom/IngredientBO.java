package lk.ijse.BO.Custom;

import lk.ijse.BO.SuperBo;
import lk.ijse.Model.IngredientModel;

import java.sql.SQLException;
import java.util.ArrayList;

public interface IngredientBO extends SuperBo {
    ArrayList<IngredientModel> getAllIngredients() throws SQLException, ClassNotFoundException;

    boolean saveIngredients(IngredientModel entity) throws SQLException, ClassNotFoundException;

    boolean updateIngredients(IngredientModel entity) throws SQLException, ClassNotFoundException;

    boolean deleteIngredients(String id) throws SQLException, ClassNotFoundException;
}
