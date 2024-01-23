package com.betrybe.agrix.controllers;

import com.betrybe.agrix.controllers.dto.FarmDto;
import com.betrybe.agrix.models.entities.Farm;
import com.betrybe.agrix.services.FarmService;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Farm controller.
 */
@RestController
@RequestMapping("/farms")
public class FarmController {
  private final FarmService farmService;

  @Autowired
  public FarmController(FarmService farmService) {
    this.farmService = farmService;
  }

  @PostMapping
  public ResponseEntity<FarmDto> createFarm(@RequestBody FarmDto farmDto) {
    Farm farm = farmService.createFarm(farmDto.toFarm());
    return ResponseEntity.status(HttpStatus.CREATED).body(FarmDto.toDto(farm));
  }

  @GetMapping
  public ResponseEntity<List<FarmDto>> getAllFarms() {
    List<Farm> farms = farmService.getAllFarms();
    return ResponseEntity.ok(farms.stream().map(FarmDto::toDto).collect(Collectors.toList()));
  }
}
