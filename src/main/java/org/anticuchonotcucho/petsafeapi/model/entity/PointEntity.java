package org.anticuchonotcucho.petsafeapi.model.entity;

import jakarta.persistence.*;

import java.sql.Timestamp;

@Entity
@jakarta.persistence.Table(name = "point", schema = "public", catalog = "postgres")
public class PointEntity {
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
    @Column(name = "type_point_id", nullable = false)
    private int typePointId;

    public int getTypePointId() {
        return typePointId;
    }

    public void setTypePointId(int typePointId) {
        this.typePointId = typePointId;
    }

    @Basic
    @Column(name = "user_id", nullable = false)
    private int userId;

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    @Basic
    @Column(name = "location_coords", nullable = false, length = -1)
    private String locationCoords;

    public String getLocationCoords() {
        return locationCoords;
    }

    public void setLocationCoords(String locationCoords) {
        this.locationCoords = locationCoords;
    }

    @Basic
    @Column(name = "time", nullable = false)
    private Timestamp time;

    public Timestamp getTime() {
        return time;
    }

    public void setTime(Timestamp time) {
        this.time = time;
    }

    @Basic
    @Column(name = "description", nullable = true, length = -1)
    private String description;

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        PointEntity that = (PointEntity) o;

        if (id != that.id) return false;
        if (typePointId != that.typePointId) return false;
        if (userId != that.userId) return false;
        if (locationCoords != null ? !locationCoords.equals(that.locationCoords) : that.locationCoords != null)
            return false;
        if (time != null ? !time.equals(that.time) : that.time != null) return false;
        if (description != null ? !description.equals(that.description) : that.description != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + typePointId;
        result = 31 * result + userId;
        result = 31 * result + (locationCoords != null ? locationCoords.hashCode() : 0);
        result = 31 * result + (time != null ? time.hashCode() : 0);
        result = 31 * result + (description != null ? description.hashCode() : 0);
        return result;
    }
}
