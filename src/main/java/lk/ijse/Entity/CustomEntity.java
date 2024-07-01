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

    //Employee
    private String E_ID;
    private String Salary;
    private String Position;
    private int Year;
    private int Month;
    private int Day;

    //Meal
    private String MID;
    private String Name;
    private String Price;

    //Ingredient
    private String I_ID;
    private String Description;
    private String Qty_On_Hand;
    private String Supplier;

    //Order
    private String orderId;
    private String customerId;
    private String date;

    //orderDetails
    private String rid;
    private String mealid;
    private String qty;
    private String unitPrice;

    //reservation
    private String RID;
    private String CID;
    private String Date;
    private String description;
    private String time;
    private String total;

    //reservationDEtails

    private String mid;
    private String desc;

    //supplier
    private String S_ID;
    private String Ingredient;
    private String Date_Of_Purchase;
    private String Amount_due;
    private String Date_of_Payment;
    private String Payment_Type;
    private String Amount_Paid;

}
