package lk.ijse.Entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data

public class Meal {
    private String MID;
    private String Name;
    private String Price;


    public Meal(String string, String rstString) {

    }
}
