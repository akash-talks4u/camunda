package com.acme.fnol.process.api.fnol_process_api.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.springframework.validation.annotation.Validated;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * Car
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2020-01-03T23:47:43.320Z")

public class Car   {
  @JsonProperty("year")
  private String year = null;

  @JsonProperty("model")
  private String model = null;

  @JsonProperty("make")
  private String make = null;

  public Car year(String year) {
    this.year = year;
    return this;
  }

  /**
   * Get year
   * @return year
  **/
  @ApiModelProperty(example = "2009", value = "")


  public String getYear() {
    return year;
  }

  public void setYear(String year) {
    this.year = year;
  }

  public Car model(String model) {
    this.model = model;
    return this;
  }

  /**
   * Get model
   * @return model
  **/
  @ApiModelProperty(example = "Corolla", value = "")


  public String getModel() {
    return model;
  }

  public void setModel(String model) {
    this.model = model;
  }

  public Car make(String make) {
    this.make = make;
    return this;
  }

  /**
   * Get make
   * @return make
  **/
  @ApiModelProperty(example = "Toyota", value = "")


  public String getMake() {
    return make;
  }

  public void setMake(String make) {
    this.make = make;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Car car = (Car) o;
    return Objects.equals(this.year, car.year) &&
        Objects.equals(this.model, car.model) &&
        Objects.equals(this.make, car.make);
  }

  @Override
  public int hashCode() {
    return Objects.hash(year, model, make);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Car {\n");
    
    sb.append("    year: ").append(toIndentedString(year)).append("\n");
    sb.append("    model: ").append(toIndentedString(model)).append("\n");
    sb.append("    make: ").append(toIndentedString(make)).append("\n");
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
}

