package kafka.examples.product.service.util;

import kafka.examples.product.service.dto.ProductDto;
import kafka.examples.product.service.entity.Product;
import org.springframework.beans.BeanUtils;

public class EntityDtoUtil {
    public static ProductDto toDto(Product product) {
        var dto = new ProductDto();
        BeanUtils.copyProperties(product, dto);
        return dto;
    }
}
