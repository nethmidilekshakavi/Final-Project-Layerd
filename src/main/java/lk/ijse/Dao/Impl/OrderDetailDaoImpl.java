package lk.ijse.Dao.Impl;

import lk.ijse.Dao.Custom.OrderDetailDao;
import lk.ijse.Dao.SQLUtil;
import lk.ijse.Entity.OrderDetails;
import lk.ijse.Entity.ReservationDetail;

import java.sql.SQLException;
import java.util.ArrayList;

public class OrderDetailDaoImpl implements OrderDetailDao {
    @Override
    public boolean add(OrderDetails entity) throws SQLException, ClassNotFoundException {
        return SQLUtil.execute("INSERT INTO Reservation_Detail VALUES(?, ?, ?, ?)",entity.getRid(),entity.getQty(),entity.getUnitPrice());

    }

    @Override
    public ArrayList<ReservationDetail> getAll() throws SQLException, ClassNotFoundException {
        return null;
    }

    @Override
    public boolean save(ReservationDetail entity) throws SQLException, ClassNotFoundException {
        return false;
    }

    @Override
    public boolean update(ReservationDetail entity) throws SQLException, ClassNotFoundException {
        return false;
    }

    @Override
    public boolean delete(String id) throws SQLException, ClassNotFoundException {
        return false;
    }

    @Override
    public ReservationDetail search(String id) throws SQLException, ClassNotFoundException {
        return null;
    }
}
