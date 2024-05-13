package com.example.assignment.rewards.model;

import java.net.URI;
import java.util.Objects;
import com.example.assignment.rewards.model.Order;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import java.util.ArrayList;
import java.util.List;
import org.openapitools.jackson.nullable.JsonNullable;
import java.io.Serializable;
import java.time.OffsetDateTime;
import jakarta.validation.Valid;
import jakarta.validation.constraints.*;
import io.swagger.v3.oas.annotations.media.Schema;


import java.util.*;
import jakarta.annotation.Generated;

/**
 * Orders
 */
@lombok.Builder
@lombok.Getter
@lombok.extern.jackson.Jacksonized

@Generated(value = "org.openapitools.codegen.languages.SpringCodegen")
public class Orders implements Serializable {

  private static final long serialVersionUID = 1L;

  private String customerId;

  @Valid
  private List<@Valid Order> orders;

  public Orders customerId(String customerId) {
    this.customerId = customerId;
    return this;
  }

  /**
   * Get customerId
   * @return customerId
  */
  
  @Schema(name = "customerId", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("customerId")
  public String getCustomerId() {
    return customerId;
  }

  public void setCustomerId(String customerId) {
    this.customerId = customerId;
  }

  public Orders orders(List<@Valid Order> orders) {
    this.orders = orders;
    return this;
  }

  public Orders addOrdersItem(Order ordersItem) {
    if (this.orders == null) {
      this.orders = new ArrayList<>();
    }
    this.orders.add(ordersItem);
    return this;
  }

  /**
   * Get orders
   * @return orders
  */
  @Valid 
  @Schema(name = "orders", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("orders")
  public List<@Valid Order> getOrders() {
    return orders;
  }

  public void setOrders(List<@Valid Order> orders) {
    this.orders = orders;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Orders orders = (Orders) o;
    return Objects.equals(this.customerId, orders.customerId) &&
        Objects.equals(this.orders, orders.orders);
  }

  @Override
  public int hashCode() {
    return Objects.hash(customerId, orders);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Orders {\n");
    sb.append("    customerId: ").append(toIndentedString(customerId)).append("\n");
    sb.append("    orders: ").append(toIndentedString(orders)).append("\n");
    sb.append("}");
    return sb.toString();
  }

  /**
   * Convert the given object to string with each line indented by 4 spaces
   * (except the first line).
   */
  private String toIndentedString(Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }
}

