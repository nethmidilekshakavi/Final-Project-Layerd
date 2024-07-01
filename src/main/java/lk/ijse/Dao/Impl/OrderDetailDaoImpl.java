package lk.ijse.Dao.Impl;

import lk.ijse.Dao.Custom.OrderDetailDao;
import lk.ijse.Dao.SQLUtil;
import lk.ijse.Entity.ReservationDetail;

import java.sql.SQLException;

public class OrderDetailDaoImpl implements OrderDetailDao {
    @Override
    public boolean add(ReservationDetail entity) throws SQLException, ClassNotFoundException {
        return SQLUtil.execute("INSERT INTO Reservation_Detail VALUES(?, ?, ?, ?)",entity.getRid(),entity.getMid(),entity.getQty(),entity.getUnitPrice());

    }

}
