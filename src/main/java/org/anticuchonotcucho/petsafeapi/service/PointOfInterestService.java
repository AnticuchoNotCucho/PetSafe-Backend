package org.anticuchonotcucho.petsafeapi.service;

import org.anticuchonotcucho.petsafeapi.model.DTO.PetReportDTO;
import org.anticuchonotcucho.petsafeapi.model.entity.PointsOfInterestEntity;
import org.anticuchonotcucho.petsafeapi.repository.IPointOfInterestRepository;
import org.springframework.stereotype.Service;

@Service
public class PointOfInterestService {
    private final IPointOfInterestRepository iPointOfInterestRepository;


    public PointOfInterestService(IPointOfInterestRepository iPointOfInterestRepository) {
        this.iPointOfInterestRepository = iPointOfInterestRepository;
    }

    public boolean savePointOfInterest(PetReportDTO reportsDTO) {
        try {
            PointsOfInterestEntity pointsOfInterestEntity = new PointsOfInterestEntity();
            pointsOfInterestEntity.setDescription(reportsDTO.getPetDescription());
            pointsOfInterestEntity.setReporterId(reportsDTO.getReporterOrFinderId());
            pointsOfInterestEntity.setStatus(reportsDTO.getStatus());
            pointsOfInterestEntity.setReportedAt(reportsDTO.getReportedOrFoundAt());
            pointsOfInterestEntity.setImage(reportsDTO.getImage());
            pointsOfInterestEntity.setName(reportsDTO.getName());
            pointsOfInterestEntity.setTypeId(reportsDTO.getTypeId());
            pointsOfInterestEntity.setCoords(reportsDTO.getCoords());

            iPointOfInterestRepository.save(pointsOfInterestEntity);
            return true; // Retornar true si se guardó exitosamente
        } catch (Exception e) {
            // Manejar la excepción (puedes registrar el error o lanzar una excepción personalizada)
            System.err.println("Error al guardar el punto de interés: " + e.getMessage());
            return false; // Retornar false en caso de error
        }
    }


}
