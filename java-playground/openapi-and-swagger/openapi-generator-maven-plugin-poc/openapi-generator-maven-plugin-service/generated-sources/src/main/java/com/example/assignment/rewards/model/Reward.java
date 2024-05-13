package com.example.assignment.rewards.model;

import java.net.URI;
import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import org.openapitools.jackson.nullable.JsonNullable;
import java.io.Serializable;
import java.time.OffsetDateTime;
import jakarta.validation.Valid;
import jakarta.validation.constraints.*;
import io.swagger.v3.oas.annotations.media.Schema;


import java.util.*;
import jakarta.annotation.Generated;

/**
 * Reward
 */
@lombok.Builder
@lombok.Getter
@lombok.extern.jackson.Jacksonized

@Generated(value = "org.openapitools.codegen.languages.SpringCodegen")
public class Reward implements Serializable {

  private static final long serialVersionUID = 1L;

  private Integer rewardPoints;

  private Double purchaseAmount;

  private String month;

  public Reward rewardPoints(Integer rewardPoints) {
    this.rewardPoints = rewardPoints;
    return this;
  }

  /**
   * Get rewardPoints
   * @return rewardPoints
  */
  
  @Schema(name = "rewardPoints", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("rewardPoints")
  public Integer getRewardPoints() {
    return rewardPoints;
  }

  public void setRewardPoints(Integer rewardPoints) {
    this.rewardPoints = rewardPoints;
  }

  public Reward purchaseAmount(Double purchaseAmount) {
    this.purchaseAmount = purchaseAmount;
    return this;
  }

  /**
   * Get purchaseAmount
   * @return purchaseAmount
  */
  
  @Schema(name = "purchaseAmount", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("purchaseAmount")
  public Double getPurchaseAmount() {
    return purchaseAmount;
  }

  public void setPurchaseAmount(Double purchaseAmount) {
    this.purchaseAmount = purchaseAmount;
  }

  public Reward month(String month) {
    this.month = month;
    return this;
  }

  /**
   * Get month
   * @return month
  */
  
  @Schema(name = "month", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("month")
  public String getMonth() {
    return month;
  }

  public void setMonth(String month) {
    this.month = month;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Reward reward = (Reward) o;
    return Objects.equals(this.rewardPoints, reward.rewardPoints) &&
        Objects.equals(this.purchaseAmount, reward.purchaseAmount) &&
        Objects.equals(this.month, reward.month);
  }

  @Override
  public int hashCode() {
    return Objects.hash(rewardPoints, purchaseAmount, month);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Reward {\n");
    sb.append("    rewardPoints: ").append(toIndentedString(rewardPoints)).append("\n");
    sb.append("    purchaseAmount: ").append(toIndentedString(purchaseAmount)).append("\n");
    sb.append("    month: ").append(toIndentedString(month)).append("\n");
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

