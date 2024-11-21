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
 * Details about the coupon.
 */

@Schema(name = "Coupon", description = "Details about the coupon.")
@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2024-11-21T10:10:09.144410+05:30[Asia/Kolkata]")
public class Coupon implements Serializable {

  private static final long serialVersionUID = 1L;

  @JsonProperty("couponCode")
  private String couponCode;

  @JsonProperty("expiryDate")
  @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
  private OffsetDateTime expiryDate;

  public Coupon couponCode(String couponCode) {
    this.couponCode = couponCode;
    return this;
  }

  /**
   * Unique code of the coupon.
   * @return couponCode
  */
  @NotNull 
  @Schema(name = "couponCode", description = "Unique code of the coupon.", required = true)
  public String getCouponCode() {
    return couponCode;
  }

  public void setCouponCode(String couponCode) {
    this.couponCode = couponCode;
  }

  public Coupon expiryDate(OffsetDateTime expiryDate) {
    this.expiryDate = expiryDate;
    return this;
  }

  /**
   * Expiry date and time of the coupon.
   * @return expiryDate
  */
  @Valid 
  @Schema(name = "expiryDate", description = "Expiry date and time of the coupon.", required = false)
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
    Coupon coupon = (Coupon) o;
    return Objects.equals(this.couponCode, coupon.couponCode) &&
        Objects.equals(this.expiryDate, coupon.expiryDate);
  }

  @Override
  public int hashCode() {
    return Objects.hash(couponCode, expiryDate);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Coupon {\n");
    sb.append("    couponCode: ").append(toIndentedString(couponCode)).append("\n");
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

