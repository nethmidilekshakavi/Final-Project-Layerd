package lk.ijse.Dao.Custom;

import lk.ijse.Dao.CrudDao;
import lk.ijse.Entity.OrderDetails;
import lk.ijse.Entity.ReservationDetail;

import java.sql.SQLException;

public interface OrderDetailDao extends CrudDao<ReservationDetail> {
    boolean add(OrderDetails entity) throws SQLException, ClassNotFoundException;
}
