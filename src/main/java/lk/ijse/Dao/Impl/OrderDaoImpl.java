package lk.ijse.Dao.Impl;

import lk.ijse.DB.DbConnection;
import lk.ijse.Dao.Custom.OrderDao;
import lk.ijse.Dao.SQLUtil;
import lk.ijse.Entity.Reservation;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class OrderDaoImpl implements OrderDao {
    @Override
        public  String getCurrentId() throws SQLException, ClassNotFoundException {
           String sql = "SELECT R_ID FROM Reservation ORDER BY R_ID DESC LIMIT 1";
            PreparedStatement pstm = DbConnection.getInstance().getConnection()
                    .prepareStatement(sql);

            ResultSet resultSet = pstm.executeQuery();
            if (resultSet.next()) {
                String orderId = resultSet.getString(1);
                return orderId;
            }
            return null;

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
    
    @Override
    public boolean add(Reservation entity) throws SQLException, ClassNotFoundException {
        return SQLUtil.execute("INSERT INTO Reservation VALUES(?,?,?,?,?,?)",entity.getRID(),entity.getCID(),entity.getDate(),entity.getDescription(),entity.getTime(),entity.getTotal());
    }

}


