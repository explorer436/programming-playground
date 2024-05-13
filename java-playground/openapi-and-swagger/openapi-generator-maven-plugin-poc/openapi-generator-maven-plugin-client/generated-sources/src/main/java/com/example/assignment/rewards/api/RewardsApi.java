package com.example.assignment.rewards.api;

import com.example.assignment.rewards.model.ApiClient;

import com.example.assignment.rewards.model.ErrorResponse;
import com.example.assignment.rewards.model.Rewards;

import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.web.reactive.function.client.WebClient.ResponseSpec;
import org.springframework.web.reactive.function.client.WebClientResponseException;
import org.springframework.core.io.FileSystemResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import reactor.core.publisher.Mono;
import reactor.core.publisher.Flux;

@jakarta.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen")
public class RewardsApi {
    private ApiClient apiClient;

    public RewardsApi() {
        this(new ApiClient());
    }

    @Autowired
    public RewardsApi(ApiClient apiClient) {
        this.apiClient = apiClient;
    }

    public ApiClient getApiClient() {
        return apiClient;
    }

    public void setApiClient(ApiClient apiClient) {
        this.apiClient = apiClient;
    }

    /**
     * Returns rewards by customer Id
     * Returns rewards by customer Id
     * <p><b>200</b> - successful operation
     * <p><b>400</b> - Bad request
     * <p><b>401</b> - Unauthorized
     * <p><b>403</b> - Forbidden
     * <p><b>404</b> - Not found
     * <p><b>500</b> - Internal server error occurred
     * @param customerId customer id
     * @return Rewards
     * @throws WebClientResponseException if an error occurs while attempting to invoke the API
     */
    private ResponseSpec getRewardsByCustomerIdRequestCreation(String customerId) throws WebClientResponseException {
        Object postBody = null;
        // verify the required parameter 'customerId' is set
        if (customerId == null) {
            throw new WebClientResponseException("Missing the required parameter 'customerId' when calling getRewardsByCustomerId", HttpStatus.BAD_REQUEST.value(), HttpStatus.BAD_REQUEST.getReasonPhrase(), null, null, null);
        }
        // create path and map variables
        final Map<String, Object> pathParams = new HashMap<String, Object>();

        pathParams.put("customerId", customerId);

        final MultiValueMap<String, String> queryParams = new LinkedMultiValueMap<String, String>();
        final HttpHeaders headerParams = new HttpHeaders();
        final MultiValueMap<String, String> cookieParams = new LinkedMultiValueMap<String, String>();
        final MultiValueMap<String, Object> formParams = new LinkedMultiValueMap<String, Object>();

        final String[] localVarAccepts = { 
            "application/json"
        };
        final List<MediaType> localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);
        final String[] localVarContentTypes = { };
        final MediaType localVarContentType = apiClient.selectHeaderContentType(localVarContentTypes);

        String[] localVarAuthNames = new String[] {  };

        ParameterizedTypeReference<Rewards> localVarReturnType = new ParameterizedTypeReference<Rewards>() {};
        return apiClient.invokeAPI("/rewards/{customerId}", HttpMethod.GET, pathParams, queryParams, postBody, headerParams, cookieParams, formParams, localVarAccept, localVarContentType, localVarAuthNames, localVarReturnType);
    }

    /**
     * Returns rewards by customer Id
     * Returns rewards by customer Id
     * <p><b>200</b> - successful operation
     * <p><b>400</b> - Bad request
     * <p><b>401</b> - Unauthorized
     * <p><b>403</b> - Forbidden
     * <p><b>404</b> - Not found
     * <p><b>500</b> - Internal server error occurred
     * @param customerId customer id
     * @return Rewards
     * @throws WebClientResponseException if an error occurs while attempting to invoke the API
     */
    public Mono<Rewards> getRewardsByCustomerId(String customerId) throws WebClientResponseException {
        ParameterizedTypeReference<Rewards> localVarReturnType = new ParameterizedTypeReference<Rewards>() {};
        return getRewardsByCustomerIdRequestCreation(customerId).bodyToMono(localVarReturnType);
    }

    /**
     * Returns rewards by customer Id
     * Returns rewards by customer Id
     * <p><b>200</b> - successful operation
     * <p><b>400</b> - Bad request
     * <p><b>401</b> - Unauthorized
     * <p><b>403</b> - Forbidden
     * <p><b>404</b> - Not found
     * <p><b>500</b> - Internal server error occurred
     * @param customerId customer id
     * @return ResponseEntity&lt;Rewards&gt;
     * @throws WebClientResponseException if an error occurs while attempting to invoke the API
     */
    public Mono<ResponseEntity<Rewards>> getRewardsByCustomerIdWithHttpInfo(String customerId) throws WebClientResponseException {
        ParameterizedTypeReference<Rewards> localVarReturnType = new ParameterizedTypeReference<Rewards>() {};
        return getRewardsByCustomerIdRequestCreation(customerId).toEntity(localVarReturnType);
    }

    /**
     * Returns rewards by customer Id
     * Returns rewards by customer Id
     * <p><b>200</b> - successful operation
     * <p><b>400</b> - Bad request
     * <p><b>401</b> - Unauthorized
     * <p><b>403</b> - Forbidden
     * <p><b>404</b> - Not found
     * <p><b>500</b> - Internal server error occurred
     * @param customerId customer id
     * @return ResponseSpec
     * @throws WebClientResponseException if an error occurs while attempting to invoke the API
     */
    public ResponseSpec getRewardsByCustomerIdWithResponseSpec(String customerId) throws WebClientResponseException {
        return getRewardsByCustomerIdRequestCreation(customerId);
    }
    /**
     * Returns rewards by customer Id
     * Returns rewards by customer Id
     * <p><b>200</b> - successful operation
     * <p><b>400</b> - Bad request
     * <p><b>401</b> - Unauthorized
     * <p><b>403</b> - Forbidden
     * <p><b>404</b> - Not found
     * <p><b>500</b> - Internal server error occurred
     * @param customerId customer id
     * @return Rewards
     * @throws WebClientResponseException if an error occurs while attempting to invoke the API
     */
    private ResponseSpec postRewardsByCustomerIdRequestCreation(String customerId) throws WebClientResponseException {
        Object postBody = null;
        // verify the required parameter 'customerId' is set
        if (customerId == null) {
            throw new WebClientResponseException("Missing the required parameter 'customerId' when calling postRewardsByCustomerId", HttpStatus.BAD_REQUEST.value(), HttpStatus.BAD_REQUEST.getReasonPhrase(), null, null, null);
        }
        // create path and map variables
        final Map<String, Object> pathParams = new HashMap<String, Object>();

        pathParams.put("customerId", customerId);

        final MultiValueMap<String, String> queryParams = new LinkedMultiValueMap<String, String>();
        final HttpHeaders headerParams = new HttpHeaders();
        final MultiValueMap<String, String> cookieParams = new LinkedMultiValueMap<String, String>();
        final MultiValueMap<String, Object> formParams = new LinkedMultiValueMap<String, Object>();

        final String[] localVarAccepts = { 
            "application/json"
        };
        final List<MediaType> localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);
        final String[] localVarContentTypes = { };
        final MediaType localVarContentType = apiClient.selectHeaderContentType(localVarContentTypes);

        String[] localVarAuthNames = new String[] {  };

        ParameterizedTypeReference<Rewards> localVarReturnType = new ParameterizedTypeReference<Rewards>() {};
        return apiClient.invokeAPI("/rewards/{customerId}", HttpMethod.POST, pathParams, queryParams, postBody, headerParams, cookieParams, formParams, localVarAccept, localVarContentType, localVarAuthNames, localVarReturnType);
    }

    /**
     * Returns rewards by customer Id
     * Returns rewards by customer Id
     * <p><b>200</b> - successful operation
     * <p><b>400</b> - Bad request
     * <p><b>401</b> - Unauthorized
     * <p><b>403</b> - Forbidden
     * <p><b>404</b> - Not found
     * <p><b>500</b> - Internal server error occurred
     * @param customerId customer id
     * @return Rewards
     * @throws WebClientResponseException if an error occurs while attempting to invoke the API
     */
    public Mono<Rewards> postRewardsByCustomerId(String customerId) throws WebClientResponseException {
        ParameterizedTypeReference<Rewards> localVarReturnType = new ParameterizedTypeReference<Rewards>() {};
        return postRewardsByCustomerIdRequestCreation(customerId).bodyToMono(localVarReturnType);
    }

    /**
     * Returns rewards by customer Id
     * Returns rewards by customer Id
     * <p><b>200</b> - successful operation
     * <p><b>400</b> - Bad request
     * <p><b>401</b> - Unauthorized
     * <p><b>403</b> - Forbidden
     * <p><b>404</b> - Not found
     * <p><b>500</b> - Internal server error occurred
     * @param customerId customer id
     * @return ResponseEntity&lt;Rewards&gt;
     * @throws WebClientResponseException if an error occurs while attempting to invoke the API
     */
    public Mono<ResponseEntity<Rewards>> postRewardsByCustomerIdWithHttpInfo(String customerId) throws WebClientResponseException {
        ParameterizedTypeReference<Rewards> localVarReturnType = new ParameterizedTypeReference<Rewards>() {};
        return postRewardsByCustomerIdRequestCreation(customerId).toEntity(localVarReturnType);
    }

    /**
     * Returns rewards by customer Id
     * Returns rewards by customer Id
     * <p><b>200</b> - successful operation
     * <p><b>400</b> - Bad request
     * <p><b>401</b> - Unauthorized
     * <p><b>403</b> - Forbidden
     * <p><b>404</b> - Not found
     * <p><b>500</b> - Internal server error occurred
     * @param customerId customer id
     * @return ResponseSpec
     * @throws WebClientResponseException if an error occurs while attempting to invoke the API
     */
    public ResponseSpec postRewardsByCustomerIdWithResponseSpec(String customerId) throws WebClientResponseException {
        return postRewardsByCustomerIdRequestCreation(customerId);
    }
}
