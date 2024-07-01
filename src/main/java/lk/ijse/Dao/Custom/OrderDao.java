package lk.ijse.Dao.Custom;

import lk.ijse.Dao.CrudDao;
import lk.ijse.Entity.Reservation;

import java.sql.SQLException;

public interface OrderDao extends CrudDao<Reservation> {


    String getCurrentId() throws SQLException, ClassNotFoundException;

    boolean add(Reservation entity) throws SQLException, ClassNotFoundException;
}
