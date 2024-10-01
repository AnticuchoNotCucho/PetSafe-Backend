package org.anticuchonotcucho.petsafeapi.model.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.anticuchonotcucho.petsafeapi.model.entity.FoundPetReportEntity;
import org.anticuchonotcucho.petsafeapi.model.entity.LostPetReportEntity;
import org.anticuchonotcucho.petsafeapi.model.entity.PointsOfInterestEntity;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PointsDTO {
    private List<LostPetReportEntity> lostPets;
    private List<FoundPetReportEntity> foundPets;
    private List<PointsOfInterestEntity> pointsOfInterestEntities;

}
