package lk.ijse.Entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data

public class Ingredient {
    private String I_ID;
    private String Description;
    private String Qty_On_Hand;
    private String Supplier;
}
