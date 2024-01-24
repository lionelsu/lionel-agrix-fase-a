package com.betrybe.agrix.models.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

/**
 * Crop entity.
 */
@Entity
@Table(name = "crops")
public class Crop {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  private String name;

  @Column(name = "planting_date")
  private Double plantedArea;

  @ManyToOne
  @JoinColumn(name = "farm_id")
  private Farm farm;

  public Crop() {
  }


  /**
   * Crop constructor.
   */
  public Crop(Long id, String name, Double plantedArea, Farm farm) {
    this.name = name;
    this.plantedArea = plantedArea;
    this.farm = farm;
    this.id = id;
  }

  public Long getId() {
    return id;
  }

  public String getName() {
    return name;
  }

  public Double getPlantedArea() {
    return plantedArea;
  }

  public Farm getFarm() {
    return farm;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public void setName(String name) {
    this.name = name;
  }

  public void setPlantedArea(Double plantedArea) {
    this.plantedArea = plantedArea;
  }

  public void setFarm(Farm farm) {
    this.farm = farm;
  }
}
