# RewardsApi

All URIs are relative to *http://localhost:8080*

| Method | HTTP request | Description |
|------------- | ------------- | -------------|
| [**getRewardsByCustomerId**](RewardsApi.md#getRewardsByCustomerId) | **GET** /rewards/{customerId} | Returns rewards by customer Id |
| [**postRewardsByCustomerId**](RewardsApi.md#postRewardsByCustomerId) | **POST** /rewards/{customerId} | Returns rewards by customer Id |



## getRewardsByCustomerId

> Rewards getRewardsByCustomerId(customerId)

Returns rewards by customer Id

Returns rewards by customer Id

### Example

```java
// Import classes:
import com.example.assignment.rewards.model.ApiClient;
import com.example.assignment.rewards.model.ApiException;
import com.example.assignment.rewards.model.Configuration;
import com.example.assignment.rewards.model.models.*;
import com.example.assignment.rewards.api.RewardsApi;

public class Example {
    public static void main(String[] args) {
        ApiClient defaultClient = Configuration.getDefaultApiClient();
        defaultClient.setBasePath("http://localhost:8080");

        RewardsApi apiInstance = new RewardsApi(defaultClient);
        String customerId = "customerId_example"; // String | customer id
        try {
            Rewards result = apiInstance.getRewardsByCustomerId(customerId);
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling RewardsApi#getRewardsByCustomerId");
            System.err.println("Status code: " + e.getCode());
            System.err.println("Reason: " + e.getResponseBody());
            System.err.println("Response headers: " + e.getResponseHeaders());
            e.printStackTrace();
        }
    }
}
```

### Parameters


| Name | Type | Description  | Notes |
|------------- | ------------- | ------------- | -------------|
| **customerId** | **String**| customer id | |

### Return type

[**Rewards**](Rewards.md)

### Authorization

No authorization required

### HTTP request headers

- **Content-Type**: Not defined
- **Accept**: application/json


### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | successful operation |  -  |
| **400** | Bad request |  -  |
| **401** | Unauthorized |  -  |
| **403** | Forbidden |  -  |
| **404** | Not found |  -  |
| **500** | Internal server error occurred |  -  |


## postRewardsByCustomerId

> Rewards postRewardsByCustomerId(customerId)

Returns rewards by customer Id

Returns rewards by customer Id

### Example

```java
// Import classes:
import com.example.assignment.rewards.model.ApiClient;
import com.example.assignment.rewards.model.ApiException;
import com.example.assignment.rewards.model.Configuration;
import com.example.assignment.rewards.model.models.*;
import com.example.assignment.rewards.api.RewardsApi;

public class Example {
    public static void main(String[] args) {
        ApiClient defaultClient = Configuration.getDefaultApiClient();
        defaultClient.setBasePath("http://localhost:8080");

        RewardsApi apiInstance = new RewardsApi(defaultClient);
        String customerId = "customerId_example"; // String | customer id
        try {
            Rewards result = apiInstance.postRewardsByCustomerId(customerId);
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling RewardsApi#postRewardsByCustomerId");
            System.err.println("Status code: " + e.getCode());
            System.err.println("Reason: " + e.getResponseBody());
            System.err.println("Response headers: " + e.getResponseHeaders());
            e.printStackTrace();
        }
    }
}
```

### Parameters


| Name | Type | Description  | Notes |
|------------- | ------------- | ------------- | -------------|
| **customerId** | **String**| customer id | |

### Return type

[**Rewards**](Rewards.md)

### Authorization

No authorization required

### HTTP request headers

- **Content-Type**: Not defined
- **Accept**: application/json


### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | successful operation |  -  |
| **400** | Bad request |  -  |
| **401** | Unauthorized |  -  |
| **403** | Forbidden |  -  |
| **404** | Not found |  -  |
| **500** | Internal server error occurred |  -  |

