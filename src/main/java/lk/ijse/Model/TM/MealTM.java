package lk.ijse.Model.TM;

import com.jfoenix.controls.JFXButton;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.swing.text.html.ImageView;

@NoArgsConstructor
@AllArgsConstructor
@Data

public class MealTM {
    private String MID;
    private String name;
    private String Price;
    private JFXButton Update;
    private JFXButton Delete;
    //private ImageView meal;



}
