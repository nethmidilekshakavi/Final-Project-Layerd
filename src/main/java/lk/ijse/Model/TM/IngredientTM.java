package lk.ijse.Model.TM;

import com.jfoenix.controls.JFXButton;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data

public class IngredientTM {
    private String I_ID;
    private String Description;
    private String Qty_On_Hand;
    private String Supplier;
    private JFXButton Update;
    private JFXButton Delete;
}
