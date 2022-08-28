package com.example.assignment.rewards.model;

import java.net.URI;
import java.util.Objects;
import com.example.assignment.rewards.model.Reward;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import java.util.ArrayList;
import java.util.List;
import org.openapitools.jackson.nullable.JsonNullable;
import java.io.Serializable;
import java.time.OffsetDateTime;
import javax.validation.Valid;
import javax.validation.constraints.*;
import io.swagger.v3.oas.annotations.media.Schema;


import java.util.*;
import javax.annotation.Generated;

/**
 * Rewards
 */

@Generated(value = "org.openapitools.codegen.languages.SpringCodegen")
public class Rewards  implements Serializable {

  private static final long serialVersionUID = 1L;

  @JsonProperty("customerId")
  private String customerId;

  @JsonProperty("totalRewardPointsForPastThreeMonths")
  private Integer totalRewardPointsForPastThreeMonths;

  @JsonProperty("totalPurchaseAmountForPastThreeMonths")
  private Double totalPurchaseAmountForPastThreeMonths;

  @JsonProperty("rewards")
  @Valid
  private List<Reward> rewards = null;

  public Rewards customerId(String customerId) {
    this.customerId = customerId;
    return this;
  }

  /**
   * Get customerId
   * @return customerId
  */
  
  @Schema(name = "customerId", required = false)
  public String getCustomerId() {
    return customerId;
  }

  public void setCustomerId(String customerId) {
    this.customerId = customerId;
  }

  public Rewards totalRewardPointsForPastThreeMonths(Integer totalRewardPointsForPastThreeMonths) {
    this.totalRewardPointsForPastThreeMonths = totalRewardPointsForPastThreeMonths;
    return this;
  }

  /**
   * Get totalRewardPointsForPastThreeMonths
   * @return totalRewardPointsForPastThreeMonths
  */
  
  @Schema(name = "totalRewardPointsForPastThreeMonths", required = false)
  public Integer getTotalRewardPointsForPastThreeMonths() {
    return totalRewardPointsForPastThreeMonths;
  }

  public void setTotalRewardPointsForPastThreeMonths(Integer totalRewardPointsForPastThreeMonths) {
    this.totalRewardPointsForPastThreeMonths = totalRewardPointsForPastThreeMonths;
  }

  public Rewards totalPurchaseAmountForPastThreeMonths(Double totalPurchaseAmountForPastThreeMonths) {
    this.totalPurchaseAmountForPastThreeMonths = totalPurchaseAmountForPastThreeMonths;
    return this;
  }

  /**
   * Get totalPurchaseAmountForPastThreeMonths
   * @return totalPurchaseAmountForPastThreeMonths
  */
  
  @Schema(name = "totalPurchaseAmountForPastThreeMonths", required = false)
  public Double getTotalPurchaseAmountForPastThreeMonths() {
    return totalPurchaseAmountForPastThreeMonths;
  }

  public void setTotalPurchaseAmountForPastThreeMonths(Double totalPurchaseAmountForPastThreeMonths) {
    this.totalPurchaseAmountForPastThreeMonths = totalPurchaseAmountForPastThreeMonths;
  }

  public Rewards rewards(List<Reward> rewards) {
    this.rewards = rewards;
    return this;
  }

  public Rewards addRewardsItem(Reward rewardsItem) {
    if (this.rewards == null) {
      this.rewards = new ArrayList<>();
    }
    this.rewards.add(rewardsItem);
    return this;
  }

  /**
   * Get rewards
   * @return rewards
  */
  @Valid 
  @Schema(name = "rewards", required = false)
  public List<Reward> getRewards() {
    return rewards;
  }

  public void setRewards(List<Reward> rewards) {
    this.rewards = rewards;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Rewards rewards = (Rewards) o;
    return Objects.equals(this.customerId, rewards.customerId) &&
        Objects.equals(this.totalRewardPointsForPastThreeMonths, rewards.totalRewardPointsForPastThreeMonths) &&
        Objects.equals(this.totalPurchaseAmountForPastThreeMonths, rewards.totalPurchaseAmountForPastThreeMonths) &&
        Objects.equals(this.rewards, rewards.rewards);
  }

  @Override
  public int hashCode() {
    return Objects.hash(customerId, totalRewardPointsForPastThreeMonths, totalPurchaseAmountForPastThreeMonths, rewards);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Rewards {\n");
    sb.append("    customerId: ").append(toIndentedString(customerId)).append("\n");
    sb.append("    totalRewardPointsForPastThreeMonths: ").append(toIndentedString(totalRewardPointsForPastThreeMonths)).append("\n");
    sb.append("    totalPurchaseAmountForPastThreeMonths: ").append(toIndentedString(totalPurchaseAmountForPastThreeMonths)).append("\n");
    sb.append("    rewards: ").append(toIndentedString(rewards)).append("\n");
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

