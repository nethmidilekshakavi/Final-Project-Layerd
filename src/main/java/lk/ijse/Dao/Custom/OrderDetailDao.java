package lk.ijse.Dao.Custom;

import lk.ijse.Dao.CrudDao;
import lk.ijse.Entity.ReservationDetail;

import java.sql.SQLException;

public interface OrderDetailDao extends CrudDao<ReservationDetail> {
    boolean add(ReservationDetail entity) throws SQLException, ClassNotFoundException;
}
