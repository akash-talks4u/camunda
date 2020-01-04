package com.acme.fnol.process.api.fnol_process_api.model;



import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.util.UUID;
import org.threeten.bp.OffsetDateTime;
import org.springframework.validation.annotation.Validated;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * Claim
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2020-01-03T23:47:43.320Z")

public class Claim   {
  @JsonProperty("claimId")
  private String claimId = null;

  @JsonProperty("location")
  private String location = null;
  
  @JsonProperty("policyNumber")
  private Long policyNumber = null;



@JsonProperty("fault")
  private String fault = null;

  @JsonProperty("date")
  private OffsetDateTime date = null;

  @JsonProperty("car")
  private Car car = null;

  public Claim id(String id) {
    this.claimId = id;
    return this;
  }

  /**
   * Get claimId
   * @return claimId
  **/
  @ApiModelProperty(example = "d290f1ee-6c54-4b01-90e6-d701748f0851", required = true, value = "")
  @NotNull

  @Valid

  public String getId() {
    return claimId;
  }

  public void setId(String id) {
    this.claimId = id;
  }

  public Claim location(String location) {
    this.location = location;
    return this;
  }

  /**
   * Get location
   * @return location
  **/
  @ApiModelProperty(example = "VA", value = "")


  public String getLocation() {
    return location;
  }

  public void setLocation(String location) {
    this.location = location;
  }

  public Claim fault(String fault) {
    this.fault = fault;
    return this;
  }

  /**
   * Get fault
   * @return fault
  **/
  @ApiModelProperty(example = "Other Car", value = "")


  public String getFault() {
    return fault;
  }

  public void setFault(String fault) {
    this.fault = fault;
  }

  public Claim date(OffsetDateTime date) {
    this.date = date;
    return this;
  }

  /**
   * Get date
   * @return date
  **/
  @ApiModelProperty(example = "2016-08-29T09:12:33.001Z", required = true, value = "")
  @NotNull

  @Valid

  public OffsetDateTime getDate() {
    return date;
  }

  public void setDate(OffsetDateTime date) {
    this.date = date;
  }

  public Claim car(Car car) {
    this.car = car;
    return this;
  }

  /**
   * Get car
   * @return car
  **/
  @ApiModelProperty(value = "")

  @Valid

  public Car getCar() {
    return car;
  }

  public void setCar(Car car) {
    this.car = car;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Claim claim = (Claim) o;
    return Objects.equals(this.claimId, claim.claimId) &&
        Objects.equals(this.location, claim.location) &&
        Objects.equals(this.fault, claim.fault) &&
        Objects.equals(this.date, claim.date) &&
        Objects.equals(this.car, claim.car);
  }

  @Override
  public int hashCode() {
    return Objects.hash(claimId, location, fault, date, car);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Claim {\n");
    
    sb.append("    claimId: ").append(toIndentedString(claimId)).append("\n");
    sb.append("    location: ").append(toIndentedString(location)).append("\n");
    sb.append("    fault: ").append(toIndentedString(fault)).append("\n");
    sb.append("    date: ").append(toIndentedString(date)).append("\n");
    sb.append("    car: ").append(toIndentedString(car)).append("\n");
    sb.append("}");
    return sb.toString();
  }

  /**
   * Convert the given object to string with each line indented by 4 spaces
   * (except the first line).
   */
  private String toIndentedString(java.lang.Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }
  
  
  public Long getPolicyNumber() {
	return policyNumber;
}

public void setPolicyNumber(Long policyNumber) {
	this.policyNumber = policyNumber;
}
}

