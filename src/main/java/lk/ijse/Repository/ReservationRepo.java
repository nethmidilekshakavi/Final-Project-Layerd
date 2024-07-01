package lk.ijse.Repository;

import com.sun.source.tree.BreakTree;
import lk.ijse.DB.DbConnection;
import lk.ijse.Model.CustomerModel;
import lk.ijse.Model.MealModel;
import lk.ijse.Model.ReservationModel;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class ReservationRepo {
    //orderid
   public static String getCurrentId() throws SQLException {
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

    //saveOrder
    public static boolean saveReservation(ReservationModel reservationModel) throws SQLException {
        try {
            Connection connection = DbConnection.getInstance().getConnection();
            PreparedStatement ptsm = connection.prepareStatement("INSERT INTO Reservation VALUES(?,?,?,?,?,?)");

            ptsm.setString(1, String.valueOf(reservationModel.getRID()));
            ptsm.setString(2, String.valueOf(reservationModel.getCID()));
            ptsm.setString(3, reservationModel.getDate());
            ptsm.setString(4, reservationModel.getDescription());
            ptsm.setString(5, reservationModel.getTime());
            ptsm.setString(6, reservationModel.getTotal());


            int i;
            i = ptsm.executeUpdate();
            return i > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }


}
