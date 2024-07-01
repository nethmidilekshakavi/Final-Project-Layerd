package lk.ijse.Dao.Custom;

import lk.ijse.Dao.CrudDao;
import lk.ijse.Dao.SuperDao;
import lk.ijse.Entity.Supplier;
import lk.ijse.Model.SupplierModel;

import java.sql.SQLException;
import java.util.ArrayList;

public interface SupplierDao extends CrudDao<Supplier> {
    ArrayList<Supplier> getAll() throws SQLException, ClassNotFoundException;

    boolean Save(Supplier Entity) throws SQLException, ClassNotFoundException;

    boolean Update(Supplier Entity) throws SQLException, ClassNotFoundException;

    boolean Delete(String id) throws SQLException, ClassNotFoundException;

    ArrayList<SupplierModel> searchSID(String sid);
}
