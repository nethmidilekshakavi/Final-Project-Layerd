package lk.ijse.Dao.Custom;

import lk.ijse.Dao.CrudDao;
import lk.ijse.Entity.Ingredient;

import java.sql.SQLException;

public interface IngredientsDao extends CrudDao<Ingredient> {
    boolean Save(Ingredient Entity) throws SQLException, ClassNotFoundException;

    boolean Update(Ingredient Entity) throws SQLException, ClassNotFoundException;

    boolean Delete(String id) throws SQLException, ClassNotFoundException;
}
