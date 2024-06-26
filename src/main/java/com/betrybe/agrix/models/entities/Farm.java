package com.betrybe.agrix.models.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import java.util.List;

/**
 * Farm entity.
 */
@Entity
@Table(name = "farms")
public class Farm {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  private String name;

  private Double size;

  @JsonIgnore
  @OneToMany(mappedBy = "farm")
  private List<Crop> crops;

  /**
   * Farm constructor.
   */
  public Farm(Long id, String name, Double size, List<Crop> crops) {
    this.name = name;
    this.crops = crops;
    this.id = id;
    this.size = size;
  }

  public Farm() {
  }

  public Long getId() {
    return id;
  }

  public String getName() {
    return name;
  }

  public List<Crop> getCrops() {
    return crops;
  }

  public void getCrops(List<Crop> crops) {
    this.crops = crops;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public void setName(String name) {
    this.name = name;
  }

  public void setCrops(List<Crop> crops) {
    this.crops = crops;
  }

  public Double getSize() {
    return size;
  }

  public void setSize(Double size) {
    this.size = size;
  }
}
