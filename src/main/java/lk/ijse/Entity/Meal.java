package lk.ijse.Entity;

import lk.ijse.controller.MealController;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data

public class Meal extends MealController {
    private String MID;
    private String Name;
    private String Price;

}
