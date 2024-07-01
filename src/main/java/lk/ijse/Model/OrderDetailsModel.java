package lk.ijse.Model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data@AllArgsConstructor@NoArgsConstructor
public class OrderDetailsModel {
    private String rid;
    private String mealid;
    private String qty;
    private String unitPrice;
}
