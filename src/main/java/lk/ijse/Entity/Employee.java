package lk.ijse.Entity;

import lk.ijse.controller.EmployeeController;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data

public class Employee extends EmployeeController {
    private String E_ID;
    private String NIC;
    private String First_Name;
    private String Last_Name;
    private String Address;
    private int Phone_Number;
    private String Email;
    private String Salary;
    private String Position;
    private int Year;
    private int Month;
    private int Day;



}
