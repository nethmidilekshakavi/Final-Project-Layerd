package lk.ijse.Model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data

public class IngredientModel {
    private String I_ID;
    private String Description;
    private String Qty_On_Hand;
    private String Supplier;
}
