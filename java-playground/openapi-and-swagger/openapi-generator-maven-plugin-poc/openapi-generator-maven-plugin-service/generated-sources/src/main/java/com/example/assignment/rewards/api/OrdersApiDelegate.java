package com.example.assignment.rewards.api;

import com.example.assignment.rewards.model.ErrorResponse;
import com.example.assignment.rewards.model.Orders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import jakarta.annotation.Generated;

/**
 * A delegate to be called by the {@link OrdersApiController}}.
 * Implement this interface with a {@link org.springframework.stereotype.Service} annotated class.
 */
@Generated(value = "org.openapitools.codegen.languages.SpringCodegen")
public interface OrdersApiDelegate {

    default Optional<NativeWebRequest> getRequest() {
        return Optional.empty();
    }

    /**
     * GET /orders/{customerId} : Returns rewards by customer Id
     * Returns rewards by customer Id
     *
     * @param customerId customer id (required)
     * @return successful operation (status code 200)
     *         or Bad request (status code 400)
     *         or Unauthorized (status code 401)
     *         or Forbidden (status code 403)
     *         or Not found (status code 404)
     *         or Internal server error occurred (status code 500)
     * @see OrdersApi#getOrdersByCustomerId
     */
    default ResponseEntity<Orders> getOrdersByCustomerId(String customerId) {
        getRequest().ifPresent(request -> {
            for (MediaType mediaType: MediaType.parseMediaTypes(request.getHeader("Accept"))) {
                if (mediaType.isCompatibleWith(MediaType.valueOf("application/json"))) {
                    String exampleString = "{ \"customerId\" : \"customerId\", \"orders\" : [ { \"itemName\" : \"itemName\", \"itemDescription\" : \"itemDescription\", \"purchaseAmount\" : 0.8008281904610115 }, { \"itemName\" : \"itemName\", \"itemDescription\" : \"itemDescription\", \"purchaseAmount\" : 0.8008281904610115 } ] }";
                    ApiUtil.setExampleResponse(request, "application/json", exampleString);
                    break;
                }
            }
        });
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);

    }

    /**
     * POST /orders/{customerId} : Returns rewards by customer Id
     * Returns rewards by customer Id
     *
     * @param customerId customer id (required)
     * @return successful operation (status code 200)
     *         or Bad request (status code 400)
     *         or Unauthorized (status code 401)
     *         or Forbidden (status code 403)
     *         or Not found (status code 404)
     *         or Internal server error occurred (status code 500)
     * @see OrdersApi#postOrdersByCustomerId
     */
    default ResponseEntity<Orders> postOrdersByCustomerId(String customerId) {
        getRequest().ifPresent(request -> {
            for (MediaType mediaType: MediaType.parseMediaTypes(request.getHeader("Accept"))) {
                if (mediaType.isCompatibleWith(MediaType.valueOf("application/json"))) {
                    String exampleString = "{ \"customerId\" : \"customerId\", \"orders\" : [ { \"itemName\" : \"itemName\", \"itemDescription\" : \"itemDescription\", \"purchaseAmount\" : 0.8008281904610115 }, { \"itemName\" : \"itemName\", \"itemDescription\" : \"itemDescription\", \"purchaseAmount\" : 0.8008281904610115 } ] }";
                    ApiUtil.setExampleResponse(request, "application/json", exampleString);
                    break;
                }
            }
        });
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);

    }

}
