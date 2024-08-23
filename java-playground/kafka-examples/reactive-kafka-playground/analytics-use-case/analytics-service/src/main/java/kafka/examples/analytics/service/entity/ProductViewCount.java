package kafka.examples.analytics.service.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductViewCount {

    @Id
    private Integer id;
    private Long count;
}
