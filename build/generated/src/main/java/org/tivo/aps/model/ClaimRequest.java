package org.tivo.aps.model;

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
 * ClaimRequest
 */

@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2024-10-16T14:22:08.113301+05:30[Asia/Kolkata]")
public class ClaimRequest implements Serializable {

  private static final long serialVersionUID = 1L;

  @JsonProperty("deviceId")
  private String deviceId;

  public ClaimRequest deviceId(String deviceId) {
    this.deviceId = deviceId;
    return this;
  }

  /**
   * ID of the device claiming the coupon
   * @return deviceId
  */
  @NotNull 
  @Schema(name = "deviceId", description = "ID of the device claiming the coupon", required = true)
  public String getDeviceId() {
    return deviceId;
  }

  public void setDeviceId(String deviceId) {
    this.deviceId = deviceId;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ClaimRequest claimRequest = (ClaimRequest) o;
    return Objects.equals(this.deviceId, claimRequest.deviceId);
  }

  @Override
  public int hashCode() {
    return Objects.hash(deviceId);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ClaimRequest {\n");
    sb.append("    deviceId: ").append(toIndentedString(deviceId)).append("\n");
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

