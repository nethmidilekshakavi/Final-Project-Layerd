package lk.ijse.BO.Custom;

import lk.ijse.BO.SuperBo;
import lk.ijse.Model.SupplierModel;

import java.sql.SQLException;
import java.util.ArrayList;

public interface SupplierBO extends SuperBo {
    ArrayList<SupplierModel> getAllSupplier() throws SQLException, ClassNotFoundException;


    boolean saveSupplier(SupplierModel entity) throws SQLException, ClassNotFoundException;

    boolean updateSupplier(SupplierModel entity) throws SQLException, ClassNotFoundException;

    boolean deleteSuippler(String id) throws SQLException, ClassNotFoundException;
}
