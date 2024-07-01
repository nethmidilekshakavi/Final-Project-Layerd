package lk.ijse.Entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class Reservation {
    private String RID;
    private String CID;
    private String Date;
    private String description;
    private String time;
    private String total;


}
