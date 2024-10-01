package org.anticuchonotcucho.petsafeapi.model.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PetReportDTO {
    private String petDescription;
    private int reporterOrFinderId; // ID del reportero o del que encuentra
    private String status;
    private Timestamp reportedOrFoundAt; // Fecha de reporte o de encuentro
    private String image;
    private String name;
    private Integer typeId; // Tipo de mascota
    private String coords;

}
