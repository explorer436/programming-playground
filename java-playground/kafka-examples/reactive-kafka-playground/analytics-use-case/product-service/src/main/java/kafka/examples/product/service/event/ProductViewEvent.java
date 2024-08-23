package kafka.examples.product.service.event;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductViewEvent {

    private Integer productId;

    // In addition to the productId,
    // the event can include other metadata like,
    // browser, user's location, etc.

}
