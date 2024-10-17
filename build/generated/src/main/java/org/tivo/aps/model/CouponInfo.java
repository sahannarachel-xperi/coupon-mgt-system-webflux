package org.tivo.aps.model;

import java.net.URI;
import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import java.time.OffsetDateTime;
import org.springframework.format.annotation.DateTimeFormat;
import org.openapitools.jackson.nullable.JsonNullable;
import java.io.Serializable;
import java.time.OffsetDateTime;
import jakarta.validation.Valid;
import jakarta.validation.constraints.*;
import io.swagger.v3.oas.annotations.media.Schema;


import java.util.*;
import jakarta.annotation.Generated;

/**
 * CouponInfo
 */

@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2024-10-17T14:50:24.007967+05:30[Asia/Kolkata]")
public class CouponInfo implements Serializable {

  private static final long serialVersionUID = 1L;

  @JsonProperty("couponCode")
  private String couponCode;

  @JsonProperty("deviceId")
  private String deviceId;

  @JsonProperty("claimed")
  private Boolean claimed;

  @JsonProperty("expired")
  private Boolean expired;

  @JsonProperty("expiryDate")
  @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
  private OffsetDateTime expiryDate;

  public CouponInfo couponCode(String couponCode) {
    this.couponCode = couponCode;
    return this;
  }

  /**
   * Unique code for the coupon
   * @return couponCode
  */
  
  @Schema(name = "couponCode", description = "Unique code for the coupon", required = false)
  public String getCouponCode() {
    return couponCode;
  }

  public void setCouponCode(String couponCode) {
    this.couponCode = couponCode;
  }

  public CouponInfo deviceId(String deviceId) {
    this.deviceId = deviceId;
    return this;
  }

  /**
   * ID of the device that claimed the coupon
   * @return deviceId
  */
  
  @Schema(name = "deviceId", description = "ID of the device that claimed the coupon", required = false)
  public String getDeviceId() {
    return deviceId;
  }

  public void setDeviceId(String deviceId) {
    this.deviceId = deviceId;
  }

  public CouponInfo claimed(Boolean claimed) {
    this.claimed = claimed;
    return this;
  }

  /**
   * Whether the coupon has been claimed
   * @return claimed
  */
  
  @Schema(name = "claimed", description = "Whether the coupon has been claimed", required = false)
  public Boolean isClaimed() {
    return claimed;
  }

  public void setClaimed(Boolean claimed) {
    this.claimed = claimed;
  }

  public CouponInfo expired(Boolean expired) {
    this.expired = expired;
    return this;
  }

  /**
   * Whether the coupon has expired
   * @return expired
  */
  
  @Schema(name = "expired", description = "Whether the coupon has expired", required = false)
  public Boolean isExpired() {
    return expired;
  }

  public void setExpired(Boolean expired) {
    this.expired = expired;
  }

  public CouponInfo expiryDate(OffsetDateTime expiryDate) {
    this.expiryDate = expiryDate;
    return this;
  }

  /**
   * Expiration date of the coupon
   * @return expiryDate
  */
  @Valid 
  @Schema(name = "expiryDate", description = "Expiration date of the coupon", required = false)
  public OffsetDateTime getExpiryDate() {
    return expiryDate;
  }

  public void setExpiryDate(OffsetDateTime expiryDate) {
    this.expiryDate = expiryDate;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    CouponInfo couponInfo = (CouponInfo) o;
    return Objects.equals(this.couponCode, couponInfo.couponCode) &&
        Objects.equals(this.deviceId, couponInfo.deviceId) &&
        Objects.equals(this.claimed, couponInfo.claimed) &&
        Objects.equals(this.expired, couponInfo.expired) &&
        Objects.equals(this.expiryDate, couponInfo.expiryDate);
  }

  @Override
  public int hashCode() {
    return Objects.hash(couponCode, deviceId, claimed, expired, expiryDate);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class CouponInfo {\n");
    sb.append("    couponCode: ").append(toIndentedString(couponCode)).append("\n");
    sb.append("    deviceId: ").append(toIndentedString(deviceId)).append("\n");
    sb.append("    claimed: ").append(toIndentedString(claimed)).append("\n");
    sb.append("    expired: ").append(toIndentedString(expired)).append("\n");
    sb.append("    expiryDate: ").append(toIndentedString(expiryDate)).append("\n");
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

