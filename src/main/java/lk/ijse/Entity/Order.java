package lk.ijse.Entity;

import lk.ijse.Model.ReservationDetailModel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Data

public class Order {

    private String orderId;
    private String customerId;
    private String date;


}
