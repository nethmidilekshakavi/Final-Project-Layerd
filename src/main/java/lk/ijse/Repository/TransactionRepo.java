package lk.ijse.Repository;

import lk.ijse.DB.DbConnection;
import lk.ijse.Model.ReservationDetailModel;
import lk.ijse.Model.ReservationModel;
import lombok.SneakyThrows;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.ArrayList;

public class TransactionRepo {
    @SneakyThrows
    public static boolean setTransaction(ReservationModel reservationModel, ArrayList<ReservationDetailModel> arrayList) {
        Connection connection = DbConnection.getInstance().getConnection();
        connection.setAutoCommit(false);

        PreparedStatement ptsm = connection.prepareStatement("INSERT INTO Reservation VALUES(?,?,?,?,?,?)");

        ptsm.setString(1 ,reservationModel.getRID());
        ptsm.setString(2, reservationModel.getCID());
        ptsm.setString(3, reservationModel.getDate());
        ptsm.setString(4, reservationModel.getDescription());
        ptsm.setString(5, reservationModel.getTime());
        ptsm.setString(6, reservationModel.getTotal());

        int i = ptsm.executeUpdate();
        PreparedStatement ptsm2;

        for (int j = 0; j < arrayList.size(); j++) {
            ptsm2= connection.prepareStatement("INSERT INTO Reservation_Details VALUES(?, ?, ?, ?)");
            ptsm2.setObject(1,arrayList.get(j).getQty());
            ptsm2.setObject(2,arrayList.get(j).getUnitPrice());
            ptsm2.setObject(3,arrayList.get(j).getRid());
            ptsm2.setObject(4,arrayList.get(j).getMid());

            int i1 = ptsm2.executeUpdate();
        }

        connection.commit();
        if (i > 0){
            return true;
        }else {
            return false;
        }
    }
}
