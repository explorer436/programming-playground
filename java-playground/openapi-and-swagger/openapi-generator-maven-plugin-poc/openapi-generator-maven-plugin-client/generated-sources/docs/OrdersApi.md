# OrdersApi

All URIs are relative to *http://localhost:8080*

| Method | HTTP request | Description |
|------------- | ------------- | -------------|
| [**getOrdersByCustomerId**](OrdersApi.md#getOrdersByCustomerId) | **GET** /orders/{customerId} | Returns rewards by customer Id |
| [**postOrdersByCustomerId**](OrdersApi.md#postOrdersByCustomerId) | **POST** /orders/{customerId} | Returns rewards by customer Id |



## getOrdersByCustomerId

> Orders getOrdersByCustomerId(customerId)

Returns rewards by customer Id

Returns rewards by customer Id

### Example

```java
// Import classes:
import com.example.assignment.rewards.model.ApiClient;
import com.example.assignment.rewards.model.ApiException;
import com.example.assignment.rewards.model.Configuration;
import com.example.assignment.rewards.model.models.*;
import com.example.assignment.rewards.api.OrdersApi;

public class Example {
    public static void main(String[] args) {
        ApiClient defaultClient = Configuration.getDefaultApiClient();
        defaultClient.setBasePath("http://localhost:8080");

        OrdersApi apiInstance = new OrdersApi(defaultClient);
        String customerId = "customerId_example"; // String | customer id
        try {
            Orders result = apiInstance.getOrdersByCustomerId(customerId);
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling OrdersApi#getOrdersByCustomerId");
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

[**Orders**](Orders.md)

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


## postOrdersByCustomerId

> Orders postOrdersByCustomerId(customerId)

Returns rewards by customer Id

Returns rewards by customer Id

### Example

```java
// Import classes:
import com.example.assignment.rewards.model.ApiClient;
import com.example.assignment.rewards.model.ApiException;
import com.example.assignment.rewards.model.Configuration;
import com.example.assignment.rewards.model.models.*;
import com.example.assignment.rewards.api.OrdersApi;

public class Example {
    public static void main(String[] args) {
        ApiClient defaultClient = Configuration.getDefaultApiClient();
        defaultClient.setBasePath("http://localhost:8080");

        OrdersApi apiInstance = new OrdersApi(defaultClient);
        String customerId = "customerId_example"; // String | customer id
        try {
            Orders result = apiInstance.postOrdersByCustomerId(customerId);
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling OrdersApi#postOrdersByCustomerId");
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

[**Orders**](Orders.md)

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

