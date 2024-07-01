package lk.ijse.BO.Custom;

import lk.ijse.BO.SuperBo;

import java.sql.SQLException;

public interface PurchaseOrderBO extends SuperBo {
    String generateOrderID() throws SQLException, ClassNotFoundException;
}
