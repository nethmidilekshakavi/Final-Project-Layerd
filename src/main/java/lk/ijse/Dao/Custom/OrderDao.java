package lk.ijse.Dao.Custom;

import lk.ijse.Dao.CrudDao;
import lk.ijse.Entity.Reservation;
import lk.ijse.Model.ReservationModel;

import java.sql.SQLException;

public interface OrderDao extends CrudDao<Reservation> {


    String getCurrentId() throws SQLException, ClassNotFoundException;


    boolean add(ReservationModel entity) throws SQLException, ClassNotFoundException;
}
