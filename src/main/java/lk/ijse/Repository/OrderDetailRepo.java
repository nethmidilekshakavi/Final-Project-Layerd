package lk.ijse.Repository;

import lk.ijse.DB.DbConnection;
import lk.ijse.Model.OrderDetailsModel;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class OrderDetailRepo {

    public static boolean saveOrderDetail(OrderDetailsModel orderDetailsModel) {
        try {
            Connection connection = DbConnection.getInstance().getConnection();
            PreparedStatement ptsm = connection.prepareStatement("INSERT INTO Reservation_Detail VALUES(?, ?, ?, ?)");

            ptsm.setString(1, orderDetailsModel.getRid());
            ptsm.setString(2, orderDetailsModel.getMealid());
            ptsm.setString(3, orderDetailsModel.getQty());
            ptsm.setString(4, orderDetailsModel.getUnitPrice());

            int i;
            i=ptsm.executeUpdate();
            return i > 0;
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
        return false;

    }

}

