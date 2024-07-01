package lk.ijse.Model.TM;

import com.jfoenix.controls.JFXButton;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class SupplierTM {
    private String S_ID;
    private String Name;
    private String Address;
    private String Phone_Number;
    private String Ingredient;
    private String Date_Of_Purchase;
    private String Amount_due;
    private String Date_of_Payment;
    private String Payment_Type;
    private String Amount_Paid;
    private JFXButton Update;
    private JFXButton Delete;

}
