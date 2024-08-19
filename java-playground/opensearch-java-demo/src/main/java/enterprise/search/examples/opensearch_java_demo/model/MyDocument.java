package enterprise.search.examples.opensearch_java_demo.model;

import lombok.Data;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

@Data
public class MyDocument {
    private String docId;
    private String docName, userName, status, s3Objectkey;
    @JsonFormat(pattern = "yyyy-MM-dd hh:mm:ss a")
    private Date createdOn;
    private byte[] fileBytes;
    private String reqJson;
}

