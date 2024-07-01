package lk.ijse.Dao.Impl;

import lk.ijse.Dao.Custom.OrderDao;
import lk.ijse.Dao.SQLUtil;
import lk.ijse.Entity.Reservation;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class OrderDaoImpl implements OrderDao {
    @Override
    public String generateNewID() throws SQLException, ClassNotFoundException {
        ResultSet rst = SQLUtil.execute("SELECT R_ID FROM Reservation ORDER BY R_ID DESC LIMIT 1");
        if (rst.next()) {
            int newIdNumber = Integer.parseInt(rst.getString(1).replace("R_ID-", "")) + 1;
            return String.format("R_ID-%03d", newIdNumber);
        } else {
            return "R_ID-001";
        }
    }

    @Override
    public ArrayList<Reservation> getAll() throws SQLException, ClassNotFoundException {
        return null;
    }

    @Override
    public boolean save(Reservation entity) throws SQLException, ClassNotFoundException {
        return false;
    }

    @Override
    public boolean update(Reservation entity) throws SQLException, ClassNotFoundException {
        return false;
    }

    @Override
    public boolean delete(String id) throws SQLException, ClassNotFoundException {
        return false;
    }

    @Override
    public Reservation search(String id) throws SQLException, ClassNotFoundException {
        return null;
    }

 //   INSERT INTO Reservation VALUES(?,?,?,?,?,?)

    @Override
    public boolean add(Reservation entity) throws SQLException, ClassNotFoundException {
        return SQLUtil.execute("INSERT INTO Reservation VALUES(?,?,?,?,?,?)",entity.getRID(),entity.getCID(),entity.getDate(),entity.getDescription(),entity.getTime(),entity.getTotal());
    }

}


