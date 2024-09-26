package org.anticuchonotcucho.petsafeapi.model.entity;

import jakarta.persistence.*;

import java.sql.Timestamp;

@Entity
@jakarta.persistence.Table(name = "lost_pet_report", schema = "public", catalog = "postgres")
public class LostPetReportEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @jakarta.persistence.Column(name = "id", nullable = false)
    private int id;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "point_id", nullable = false)
    private int pointId;

    public int getPointId() {
        return pointId;
    }

    public void setPointId(int pointId) {
        this.pointId = pointId;
    }

    @Basic
    @Column(name = "pet_description", nullable = false, length = -1)
    private String petDescription;

    public String getPetDescription() {
        return petDescription;
    }

    public void setPetDescription(String petDescription) {
        this.petDescription = petDescription;
    }

    @Basic
    @Column(name = "reporter_id", nullable = false)
    private int reporterId;

    public int getReporterId() {
        return reporterId;
    }

    public void setReporterId(int reporterId) {
        this.reporterId = reporterId;
    }

    @Basic
    @Column(name = "status", nullable = true, length = 50)
    private String status;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Basic
    @Column(name = "reported_at", nullable = false)
    private Timestamp reportedAt;

    public Timestamp getReportedAt() {
        return reportedAt;
    }

    public void setReportedAt(Timestamp reportedAt) {
        this.reportedAt = reportedAt;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        LostPetReportEntity that = (LostPetReportEntity) o;

        if (id != that.id) return false;
        if (pointId != that.pointId) return false;
        if (reporterId != that.reporterId) return false;
        if (petDescription != null ? !petDescription.equals(that.petDescription) : that.petDescription != null)
            return false;
        if (status != null ? !status.equals(that.status) : that.status != null) return false;
        if (reportedAt != null ? !reportedAt.equals(that.reportedAt) : that.reportedAt != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + pointId;
        result = 31 * result + (petDescription != null ? petDescription.hashCode() : 0);
        result = 31 * result + reporterId;
        result = 31 * result + (status != null ? status.hashCode() : 0);
        result = 31 * result + (reportedAt != null ? reportedAt.hashCode() : 0);
        return result;
    }
}
