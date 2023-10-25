package com.example.assignment.rewards.client;

import com.example.assignment.rewards.client.ApiClient;

import com.example.assignment.rewards.model.Orders;

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

@javax.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen")
public class OrdersApi {
    private ApiClient apiClient;

    public OrdersApi() {
        this(new ApiClient());
    }

    @Autowired
    public OrdersApi(ApiClient apiClient) {
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
     * <p><b>400</b>
     * <p><b>401</b>
     * <p><b>403</b>
     * <p><b>404</b>
     * <p><b>500</b>
     * @param customerId customer id
     * @return Orders
     * @throws WebClientResponseException if an error occurs while attempting to invoke the API
     */
    private ResponseSpec getOrdersByCustomerIdRequestCreation(String customerId) throws WebClientResponseException {
        Object postBody = null;
        // verify the required parameter 'customerId' is set
        if (customerId == null) {
            throw new WebClientResponseException("Missing the required parameter 'customerId' when calling getOrdersByCustomerId", HttpStatus.BAD_REQUEST.value(), HttpStatus.BAD_REQUEST.getReasonPhrase(), null, null, null);
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

        ParameterizedTypeReference<Orders> localVarReturnType = new ParameterizedTypeReference<Orders>() {};
        return apiClient.invokeAPI("/orders/{customerId}", HttpMethod.GET, pathParams, queryParams, postBody, headerParams, cookieParams, formParams, localVarAccept, localVarContentType, localVarAuthNames, localVarReturnType);
    }

    /**
     * Returns rewards by customer Id
     * Returns rewards by customer Id
     * <p><b>200</b> - successful operation
     * <p><b>400</b>
     * <p><b>401</b>
     * <p><b>403</b>
     * <p><b>404</b>
     * <p><b>500</b>
     * @param customerId customer id
     * @return Orders
     * @throws WebClientResponseException if an error occurs while attempting to invoke the API
     */
    public Mono<Orders> getOrdersByCustomerId(String customerId) throws WebClientResponseException {
        ParameterizedTypeReference<Orders> localVarReturnType = new ParameterizedTypeReference<Orders>() {};
        return getOrdersByCustomerIdRequestCreation(customerId).bodyToMono(localVarReturnType);
    }

    public Mono<ResponseEntity<Orders>> getOrdersByCustomerIdWithHttpInfo(String customerId) throws WebClientResponseException {
        ParameterizedTypeReference<Orders> localVarReturnType = new ParameterizedTypeReference<Orders>() {};
        return getOrdersByCustomerIdRequestCreation(customerId).toEntity(localVarReturnType);
    }
    /**
     * Returns rewards by customer Id
     * Returns rewards by customer Id
     * <p><b>200</b> - successful operation
     * <p><b>400</b>
     * <p><b>401</b>
     * <p><b>403</b>
     * <p><b>404</b>
     * <p><b>500</b>
     * @param customerId customer id
     * @return Orders
     * @throws WebClientResponseException if an error occurs while attempting to invoke the API
     */
    private ResponseSpec postOrdersByCustomerIdRequestCreation(String customerId) throws WebClientResponseException {
        Object postBody = null;
        // verify the required parameter 'customerId' is set
        if (customerId == null) {
            throw new WebClientResponseException("Missing the required parameter 'customerId' when calling postOrdersByCustomerId", HttpStatus.BAD_REQUEST.value(), HttpStatus.BAD_REQUEST.getReasonPhrase(), null, null, null);
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

        ParameterizedTypeReference<Orders> localVarReturnType = new ParameterizedTypeReference<Orders>() {};
        return apiClient.invokeAPI("/orders/{customerId}", HttpMethod.POST, pathParams, queryParams, postBody, headerParams, cookieParams, formParams, localVarAccept, localVarContentType, localVarAuthNames, localVarReturnType);
    }

    /**
     * Returns rewards by customer Id
     * Returns rewards by customer Id
     * <p><b>200</b> - successful operation
     * <p><b>400</b>
     * <p><b>401</b>
     * <p><b>403</b>
     * <p><b>404</b>
     * <p><b>500</b>
     * @param customerId customer id
     * @return Orders
     * @throws WebClientResponseException if an error occurs while attempting to invoke the API
     */
    public Mono<Orders> postOrdersByCustomerId(String customerId) throws WebClientResponseException {
        ParameterizedTypeReference<Orders> localVarReturnType = new ParameterizedTypeReference<Orders>() {};
        return postOrdersByCustomerIdRequestCreation(customerId).bodyToMono(localVarReturnType);
    }

    public Mono<ResponseEntity<Orders>> postOrdersByCustomerIdWithHttpInfo(String customerId) throws WebClientResponseException {
        ParameterizedTypeReference<Orders> localVarReturnType = new ParameterizedTypeReference<Orders>() {};
        return postOrdersByCustomerIdRequestCreation(customerId).toEntity(localVarReturnType);
    }
}
