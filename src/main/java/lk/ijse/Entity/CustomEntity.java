package lk.ijse.Entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class CustomEntity {
    //CustomerController
    private String C_ID;
    private  String NIC;
    private  String First_Name;
    private  String Last_Name;
    private  String Address;
    private  int Phone_Number;
    private  String Email;

}
