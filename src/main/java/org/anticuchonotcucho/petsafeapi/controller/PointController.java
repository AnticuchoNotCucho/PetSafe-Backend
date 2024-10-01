package org.anticuchonotcucho.petsafeapi.controller;

import org.anticuchonotcucho.petsafeapi.model.DTO.PetReportDTO;
import org.anticuchonotcucho.petsafeapi.model.DTO.PointsDTO;
import org.anticuchonotcucho.petsafeapi.service.PointService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.sql.Timestamp;
import java.util.HashMap;
import java.util.Map;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("api/points")
public class PointController {

    private final PointService pointService;

    public PointController(PointService pointService) {
        this.pointService = pointService;
    }

    @PostMapping("/report")
    public ResponseEntity<Map<String, String>> reportPet(@RequestBody PetReportDTO petReportDTO) {
        Map<String, String> response = new HashMap<>();

        // Verificar si el Type ID es nulo
        if (petReportDTO.getTypeId() == null) {
            response.put("error", "Type ID is required.");
            return ResponseEntity.badRequest().body(response);
        }

        // Establecer la fecha de reporte
        petReportDTO.setReportedOrFoundAt(new Timestamp(System.currentTimeMillis()));

        // Guardar el reporte de mascota a través del servicio
        ResponseEntity<Map<String, String>> saveResponse = pointService.saveEntity(petReportDTO);

        // Manejar la respuesta de saveEntity
        if (saveResponse.getStatusCode().is2xxSuccessful()) {
            response.put("message", saveResponse.getBody().toString());
            return ResponseEntity.ok(response);
        } else {
            response.put("error", saveResponse.getBody().toString());
            return ResponseEntity.status(saveResponse.getStatusCode()).body(response);
        }
    }


    @GetMapping
    public PointsDTO getPointService() {
        return pointService.getAllPoints();
    }
}
