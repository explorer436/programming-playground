package handling.backend.lookups.examples.lookup_data_only_once.model;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Details {
    private String id;
    private String name;
    private String accountNumber;
}
