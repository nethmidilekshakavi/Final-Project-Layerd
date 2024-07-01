package lk.ijse.Dao.Custom;

import lk.ijse.Dao.SuperDao;
import lk.ijse.Entity.Supplier;

import java.sql.SQLException;
import java.util.ArrayList;

public interface SupplierDao extends SuperDao {
    ArrayList<Supplier> getAll() throws SQLException, ClassNotFoundException;

    boolean Save(Supplier Entity) throws SQLException, ClassNotFoundException;

    boolean Update(Supplier Entity) throws SQLException, ClassNotFoundException;

    boolean Delete(String id) throws SQLException, ClassNotFoundException;
}
