package lk.ijse.Model.TM;

import com.jfoenix.controls.JFXButton;
import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Data

public class customerTM {
    private String C_ID;
    private String NIC;
    private String First_Name;
    private String Last_Name;
    private String Address;
    private String Phone_Number;
    private String Email;
    private JFXButton delete;
    private JFXButton update;

}
