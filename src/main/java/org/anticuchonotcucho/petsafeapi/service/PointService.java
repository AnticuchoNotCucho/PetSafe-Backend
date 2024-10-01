package org.anticuchonotcucho.petsafeapi.service;

import org.anticuchonotcucho.petsafeapi.model.DTO.PetReportDTO;
import org.anticuchonotcucho.petsafeapi.model.DTO.PointsDTO;
import org.anticuchonotcucho.petsafeapi.model.entity.FoundPetReportEntity;
import org.anticuchonotcucho.petsafeapi.model.entity.LostPetReportEntity;
import org.anticuchonotcucho.petsafeapi.model.entity.PointsOfInterestEntity;
import org.anticuchonotcucho.petsafeapi.repository.IFoundPetReportRepository;
import org.anticuchonotcucho.petsafeapi.repository.ILostPetReportRepository;
import org.anticuchonotcucho.petsafeapi.repository.IPointOfInterestRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class PointService {
    private final ILostPetReportRepository iLostPetReportRepository;
    private final IFoundPetReportRepository iFoundPetReportRepository;

    private final IPointOfInterestRepository iPointOfInterestRepository;
    private final FoundPetReportService foundPetReportService;

    private final LostPetReportService lostPetReportService;

    private final PointOfInterestService pointOfInterestService;

    public PointService(ILostPetReportRepository iLostPetReportRepository, IFoundPetReportRepository iFoundPetReportRepository, IPointOfInterestRepository iPointOfInterestRepository, FoundPetReportService foundPetReportService, LostPetReportService lostPetReportService, PointOfInterestService pointOfInterestService) {
        this.iLostPetReportRepository = iLostPetReportRepository;
        this.iFoundPetReportRepository = iFoundPetReportRepository;
        this.iPointOfInterestRepository = iPointOfInterestRepository;
        this.foundPetReportService = foundPetReportService;
        this.lostPetReportService = lostPetReportService;
        this.pointOfInterestService = pointOfInterestService;
    }

    public PointsDTO getAllPoints() {
        // Obtener todas las mascotas perdidas
        List<LostPetReportEntity> lostPets = iLostPetReportRepository.findAll();

        // Obtener todas las mascotas encontradas
        List<FoundPetReportEntity> foundPets = iFoundPetReportRepository.findAll();

        List<PointsOfInterestEntity> pointsOfInterest = iPointOfInterestRepository.findAll();

        // Retornar el DTO que contiene ambas listas
        return new PointsDTO(lostPets, foundPets, pointsOfInterest);
    }

    public ResponseEntity<Map<String, String>> saveEntity(PetReportDTO petReportDTO) {
        Map<String, String> response = new HashMap<>();

        if (petReportDTO.getTypeId() == null) {
            response.put("error", "Type ID is required.");
            return ResponseEntity.badRequest().body(response);
        }

        switch (petReportDTO.getTypeId()) {
            case 1: // Mascota perdida
                lostPetReportService.saveLostPetReport(petReportDTO);
                response.put("message", "Lost pet report saved successfully.");
                return ResponseEntity.ok(response);
            case 2: // Mascota encontrada
                foundPetReportService.saveFoundPetReport(petReportDTO);
                response.put("message", "Found pet report saved successfully.");
                return ResponseEntity.ok(response);
            case 3: // Mascota encontrada
                pointOfInterestService.savePointOfInterest(petReportDTO);
                response.put("message", "Found pet report saved successfully.");
                return ResponseEntity.ok(response);
            default:
                response.put("error", "Invalid Type ID.");
                return ResponseEntity.badRequest().body(response);
        }
    }





}
