package org.anticuchonotcucho.petsafeapi.controller;

import org.anticuchonotcucho.petsafeapi.model.entity.LostPetReportEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.sql.Timestamp;
import java.util.List;

@RestController
@RequestMapping("/api/report")
@CrossOrigin(origins = "http://localhost:4200")
public class ReportController {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @GetMapping
    public List<LostPetReportEntity> getLostPetsLast30Days() {
        String sql = "SELECT * FROM get_lost_pets_last_30_days()"; // Llama a tu función
        return jdbcTemplate.query(sql, (rs, rowNum) -> {
            LostPetReportEntity report = new LostPetReportEntity();
            report.setId(rs.getInt("id"));
            report.setImage(rs.getString("image"));
            report.setName(rs.getString("name"));
            report.setPetDescription(rs.getString("pet_description"));
            report.setReportedAt(Timestamp.valueOf(rs.getTimestamp("reported_at").toLocalDateTime()));
            report.setReporterId(rs.getInt("reporter_id"));
            report.setStatus(rs.getString("status"));
            report.setTypeId(rs.getInt("type_id"));
            return report;
        });
    }
}
