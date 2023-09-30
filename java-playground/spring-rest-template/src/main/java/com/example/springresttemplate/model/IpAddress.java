package com.example.springresttemplate.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;

/**
 *
 * It is annotated with @JsonIgnoreProperties from the Jackson JSON processing library
 * to indicate that any properties not bound in this type should be ignored.
 *
 * To directly bind your data to your custom types, you need to specify the variable name
 * to be exactly the same as the key in the JSON document returned from the API.
 * In case your variable name and key in JSON doc do not match,
 * you can use @JsonProperty annotation to specify the exact key of the JSON document.
 *
 */
@Getter
@JsonIgnoreProperties(ignoreUnknown = true)
public class IpAddress {
    private String ip;
}
