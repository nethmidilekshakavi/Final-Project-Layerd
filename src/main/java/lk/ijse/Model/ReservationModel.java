package lk.ijse.Model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class ReservationModel {
    private String RID;
    private String CID;
    private String Date;
    private String description;
    private String time;
    private String total;

}
