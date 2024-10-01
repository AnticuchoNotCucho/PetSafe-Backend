package org.anticuchonotcucho.petsafeapi.service;

import org.anticuchonotcucho.petsafeapi.model.DTO.PetReportDTO;
import org.anticuchonotcucho.petsafeapi.model.entity.FoundPetReportEntity;
import org.anticuchonotcucho.petsafeapi.repository.IFoundPetReportRepository;
import org.springframework.stereotype.Service;

@Service
public class FoundPetReportService {

    private final IFoundPetReportRepository iFoundPetReportRepository;

    public FoundPetReportService(IFoundPetReportRepository iFoundPetReportRepository) {
        this.iFoundPetReportRepository = iFoundPetReportRepository;
    }

    public void saveFoundPetReport(PetReportDTO petReportDTO) {
        FoundPetReportEntity foundPetReportEntity = new FoundPetReportEntity();
        foundPetReportEntity.setPetDescription(petReportDTO.getPetDescription());
        foundPetReportEntity.setFinderId(petReportDTO.getReporterOrFinderId()); // Cambia según tu lógica
        foundPetReportEntity.setStatus(petReportDTO.getStatus());
        foundPetReportEntity.setFoundAt(petReportDTO.getReportedOrFoundAt()); // Cambia según tu lógica
        foundPetReportEntity.setImage(petReportDTO.getImage());
        foundPetReportEntity.setName(petReportDTO.getName());
        foundPetReportEntity.setTypeId(petReportDTO.getTypeId());
        foundPetReportEntity.setCoords(petReportDTO.getCoords());

        iFoundPetReportRepository.save(foundPetReportEntity);
    }
}
