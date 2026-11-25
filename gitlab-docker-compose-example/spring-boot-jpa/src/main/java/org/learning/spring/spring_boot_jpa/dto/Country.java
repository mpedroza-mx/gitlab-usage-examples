package org.learning.spring.spring_boot_jpa.dto;

import java.io.Serializable;

public class Country implements Serializable {

  private Long id;
  private String country;

  public Long getId() {
    return id;
  }

  public Country setId(Long id) {
    this.id = id;
    return this;
  }

  public String getCountry() {
    return country;
  }

  public Country setCountry(String country) {
    this.country = country;
    return this;
  }
}
