package enterprise.search.examples.opensearch_java_demo.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class MyDocument {
    private Long id;
    private String docName;
    private String userName;
    private String status;
    private String createdOn;
    private String reqJson;
}

