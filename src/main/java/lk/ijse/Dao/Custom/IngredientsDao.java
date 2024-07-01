package lk.ijse.Dao.Custom;

import lk.ijse.Dao.CrudDao;
import lk.ijse.Entity.Ingredient;
import lk.ijse.Model.IngredientModel;

import java.sql.SQLException;
import java.util.ArrayList;

public interface IngredientsDao extends CrudDao<Ingredient> {
    boolean Save(Ingredient Entity) throws SQLException, ClassNotFoundException;

    boolean Update(Ingredient Entity) throws SQLException, ClassNotFoundException;

    boolean Delete(String id) throws SQLException, ClassNotFoundException;

    ArrayList<IngredientModel> searchIID(String iid);
}
