package enterprise.search.examples.opensearch_java_demo.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.Date;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class MyDocument<T> {
    private Long id;
    private String docName;
    private String userName;
    private String status;
    private Date createdOn;
    private String reqJson;
}

