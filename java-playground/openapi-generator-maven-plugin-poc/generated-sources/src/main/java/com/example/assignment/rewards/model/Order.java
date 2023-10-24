package com.example.assignment.rewards.model;

import java.net.URI;
import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import org.openapitools.jackson.nullable.JsonNullable;
import java.io.Serializable;
import java.time.OffsetDateTime;
import javax.validation.Valid;
import javax.validation.constraints.*;
import io.swagger.v3.oas.annotations.media.Schema;


import java.util.*;
import javax.annotation.Generated;

/**
 * Order
 */
@lombok.Builder
@lombok.Getter
@lombok.extern.jackson.Jacksonized

@Generated(value = "org.openapitools.codegen.languages.SpringCodegen")
public class Order implements Serializable {

  private static final long serialVersionUID = 1L;

  @JsonProperty("purchaseAmount")
  private Double purchaseAmount;

  @JsonProperty("itemName")
  private String itemName;

  @JsonProperty("itemDescription")
  private String itemDescription;

  public Order purchaseAmount(Double purchaseAmount) {
    this.purchaseAmount = purchaseAmount;
    return this;
  }

  /**
   * Get purchaseAmount
   * @return purchaseAmount
  */
  
  @Schema(name = "purchaseAmount", required = false)
  public Double getPurchaseAmount() {
    return purchaseAmount;
  }

  public void setPurchaseAmount(Double purchaseAmount) {
    this.purchaseAmount = purchaseAmount;
  }

  public Order itemName(String itemName) {
    this.itemName = itemName;
    return this;
  }

  /**
   * Get itemName
   * @return itemName
  */
  
  @Schema(name = "itemName", required = false)
  public String getItemName() {
    return itemName;
  }

  public void setItemName(String itemName) {
    this.itemName = itemName;
  }

  public Order itemDescription(String itemDescription) {
    this.itemDescription = itemDescription;
    return this;
  }

  /**
   * Get itemDescription
   * @return itemDescription
  */
  
  @Schema(name = "itemDescription", required = false)
  public String getItemDescription() {
    return itemDescription;
  }

  public void setItemDescription(String itemDescription) {
    this.itemDescription = itemDescription;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Order order = (Order) o;
    return Objects.equals(this.purchaseAmount, order.purchaseAmount) &&
        Objects.equals(this.itemName, order.itemName) &&
        Objects.equals(this.itemDescription, order.itemDescription);
  }

  @Override
  public int hashCode() {
    return Objects.hash(purchaseAmount, itemName, itemDescription);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Order {\n");
    sb.append("    purchaseAmount: ").append(toIndentedString(purchaseAmount)).append("\n");
    sb.append("    itemName: ").append(toIndentedString(itemName)).append("\n");
    sb.append("    itemDescription: ").append(toIndentedString(itemDescription)).append("\n");
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

