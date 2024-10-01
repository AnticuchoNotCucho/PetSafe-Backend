package org.anticuchonotcucho.petsafeapi.service;

import org.anticuchonotcucho.petsafeapi.model.DTO.PetReportDTO;
import org.anticuchonotcucho.petsafeapi.model.entity.LostPetReportEntity;
import org.anticuchonotcucho.petsafeapi.repository.ILostPetReportRepository;
import org.springframework.stereotype.Service;

@Service
public class LostPetReportService {
    private final ILostPetReportRepository iLostPetReportRepository;

    public LostPetReportService(ILostPetReportRepository iLostPetReportRepository) {
        this.iLostPetReportRepository = iLostPetReportRepository;
    }

    public boolean saveLostPetReport(PetReportDTO petReportDTO) {
        try {
            LostPetReportEntity lostPetReportEntity = new LostPetReportEntity();
            lostPetReportEntity.setPetDescription(petReportDTO.getPetDescription());
            lostPetReportEntity.setReporterId(petReportDTO.getReporterOrFinderId());
            lostPetReportEntity.setStatus(petReportDTO.getStatus());
            lostPetReportEntity.setReportedAt(petReportDTO.getReportedOrFoundAt());
            lostPetReportEntity.setImage(petReportDTO.getImage());
            lostPetReportEntity.setName(petReportDTO.getName());
            lostPetReportEntity.setTypeId(petReportDTO.getTypeId());
            lostPetReportEntity.setCoords(petReportDTO.getCoords());

            iLostPetReportRepository.save(lostPetReportEntity);
            return true; // Retornar true si se guardó exitosamente
        } catch (Exception e) {
            // Manejar la excepción (puedes registrar el error o lanzar una excepción personalizada)
            System.err.println("Error al guardar el reporte de mascota perdida: " + e.getMessage());
            return false; // Retornar false en caso de error
        }
    }

}
