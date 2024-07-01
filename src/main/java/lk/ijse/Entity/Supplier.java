package lk.ijse.Entity;

import lk.ijse.controller.SupplierController;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data

public class Supplier extends SupplierController {
    private String S_ID;
    private String Name;
    private String Address;
    private int Phone_Number;
    private String Ingredient;
    private String Date_Of_Purchase;
    private String Amount_due;
    private String Date_of_Payment;
    private String Payment_Type;
    private String Amount_Paid;

}
