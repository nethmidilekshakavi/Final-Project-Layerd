package lk.ijse.Dao.Custom;

import lk.ijse.Entity.ReservationDetail;

import java.sql.SQLException;

public interface OrderDetailDao {
    boolean add(ReservationDetail entity) throws SQLException, ClassNotFoundException;
}
