package lk.ijse.Entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data@AllArgsConstructor@NoArgsConstructor
public class OrderDetails {
    private String rid;
    private String mealid;
    private String qty;
    private String unitPrice;
}
