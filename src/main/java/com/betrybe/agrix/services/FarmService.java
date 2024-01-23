package com.betrybe.agrix.services;

import com.betrybe.agrix.models.entities.Farm;
import com.betrybe.agrix.models.repositories.FarmRepository;
import org.springframework.stereotype.Service;

/**
 * Farm service.
 */
@Service
public class FarmService {
  private final FarmRepository farmRepository;

  public FarmService(FarmRepository farmRepository) {
    this.farmRepository = farmRepository;
  }

  public Farm createFarm(Farm farm) {
    return this.farmRepository.save(farm);
  }
}
