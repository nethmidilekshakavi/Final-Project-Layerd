package lk.ijse.Model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ReservationDetailModel {
    private String rid;
    private String mid;
    private String desc;
    private String unitPrice;
    private String qty;
}
