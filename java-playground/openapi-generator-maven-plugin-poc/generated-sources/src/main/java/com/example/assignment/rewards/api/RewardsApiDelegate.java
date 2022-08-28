package com.example.assignment.rewards.api;

import com.example.assignment.rewards.model.Rewards;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import javax.annotation.Generated;

/**
 * A delegate to be called by the {@link RewardsApiController}}.
 * Implement this interface with a {@link org.springframework.stereotype.Service} annotated class.
 */
@Generated(value = "org.openapitools.codegen.languages.SpringCodegen")
public interface RewardsApiDelegate {

    default Optional<NativeWebRequest> getRequest() {
        return Optional.empty();
    }

    /**
     * GET /rewards/{customerId} : Returns rewards by customer Id
     * Returns rewards by customer Id
     *
     * @param customerId customer id (required)
     * @return successful operation (status code 200)
     *         or  (status code 400)
     *         or  (status code 401)
     *         or  (status code 403)
     *         or  (status code 404)
     *         or  (status code 500)
     * @see RewardsApi#getRewardsByCustomerId
     */
    default ResponseEntity<Rewards> getRewardsByCustomerId(String customerId) {
        getRequest().ifPresent(request -> {
            for (MediaType mediaType: MediaType.parseMediaTypes(request.getHeader("Accept"))) {
                if (mediaType.isCompatibleWith(MediaType.valueOf("application/json"))) {
                    String exampleString = "{ \"totalPurchaseAmountForPastThreeMonths\" : 6.027456183070403, \"customerId\" : \"customerId\", \"totalRewardPointsForPastThreeMonths\" : 0, \"rewards\" : [ { \"month\" : \"month\", \"rewardPoints\" : 1, \"purchaseAmount\" : 5.962133916683182 }, { \"month\" : \"month\", \"rewardPoints\" : 1, \"purchaseAmount\" : 5.962133916683182 } ] }";
                    ApiUtil.setExampleResponse(request, "application/json", exampleString);
                    break;
                }
            }
        });
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);

    }

}
