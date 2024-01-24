package com.betrybe.agrix.services;

import com.betrybe.agrix.exceptions.FarmNotFoundException;
import com.betrybe.agrix.models.entities.Crop;
import com.betrybe.agrix.models.entities.Farm;
import com.betrybe.agrix.models.repositories.CropRepository;
import com.betrybe.agrix.models.repositories.FarmRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.stereotype.Service;

/**
 * Farm service.
 */
@Service
public class FarmService {
  private final FarmRepository farmRepository;
  private final CropRepository cropRepository;

  public FarmService(FarmRepository farmRepository, CropRepository cropRepository) {
    this.farmRepository = farmRepository;
    this.cropRepository = cropRepository;
  }

  public Farm createFarm(Farm farm) {
    return farmRepository.save(farm);
  }

  public List<Farm> getAllFarms() {
    return farmRepository.findAll();
  }

  /**
   * Get farm by id.
   */
  public Farm getFarmById(Long farmId) {
    Optional<Farm> farm = farmRepository.findById(farmId);
    if (farm.isEmpty()) {
      throw new FarmNotFoundException();
    }
    return farm.get();
  }

  /**
   * Create crop.
   */
  public Crop createCrop(Long farmId, Crop crop) {
    Optional<Farm> farm = farmRepository.findById(farmId);
    if (farm.isEmpty()) {
      throw new FarmNotFoundException();
    }
    crop.setFarm(farm.get());

    return cropRepository.save(crop);
  }

  /**
   * Get all crops from a farm.
   */
  public List<Crop> getAllCropsFromFarm(Long farmId) {
    Optional<Farm> farm = farmRepository.findById(farmId);
    if (farm.isEmpty()) {
      throw new FarmNotFoundException();
    }

    return farm.get().getCrops();
  }
}
