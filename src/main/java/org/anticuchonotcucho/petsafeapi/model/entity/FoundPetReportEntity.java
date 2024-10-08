package org.anticuchonotcucho.petsafeapi.model.entity;

import jakarta.persistence.*;

import java.sql.Timestamp;

@Entity
@Table(name = "found_pet_report", schema = "public", catalog = "postgres")
public class FoundPetReportEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id", nullable = false)
    private int id;
    @Basic
    @Column(name = "pet_description", nullable = false, length = -1)
    private String petDescription;
    @Basic
    @Column(name = "finder_id", nullable = false)
    private int finderId;
    @Basic
    @Column(name = "status", nullable = true, length = 50)
    private String status;
    @Basic
    @Column(name = "found_at", nullable = false)
    private Timestamp foundAt;
    @Basic
    @Column(name = "image", nullable = true, length = -1)
    private String image;
    @Basic
    @Column(name = "name", nullable = true, length = -1)
    private String name;
    @Basic
    @Column(name = "type_id", nullable = true)
    private Integer typeId;
    @Basic
    @Column(name = "coords", nullable = true, length = 100)
    private String coords;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPetDescription() {
        return petDescription;
    }

    public void setPetDescription(String petDescription) {
        this.petDescription = petDescription;
    }

    public int getFinderId() {
        return finderId;
    }

    public void setFinderId(int finderId) {
        this.finderId = finderId;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Timestamp getFoundAt() {
        return foundAt;
    }

    public void setFoundAt(Timestamp foundAt) {
        this.foundAt = foundAt;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getTypeId() {
        return typeId;
    }

    public void setTypeId(Integer typeId) {
        this.typeId = typeId;
    }

    public String getCoords() {
        return coords;
    }

    public void setCoords(String coords) {
        this.coords = coords;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        FoundPetReportEntity that = (FoundPetReportEntity) o;

        if (id != that.id) return false;
        if (finderId != that.finderId) return false;
        if (petDescription != null ? !petDescription.equals(that.petDescription) : that.petDescription != null)
            return false;
        if (status != null ? !status.equals(that.status) : that.status != null) return false;
        if (foundAt != null ? !foundAt.equals(that.foundAt) : that.foundAt != null) return false;
        if (image != null ? !image.equals(that.image) : that.image != null) return false;
        if (name != null ? !name.equals(that.name) : that.name != null) return false;
        if (typeId != null ? !typeId.equals(that.typeId) : that.typeId != null) return false;
        if (coords != null ? !coords.equals(that.coords) : that.coords != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (petDescription != null ? petDescription.hashCode() : 0);
        result = 31 * result + finderId;
        result = 31 * result + (status != null ? status.hashCode() : 0);
        result = 31 * result + (foundAt != null ? foundAt.hashCode() : 0);
        result = 31 * result + (image != null ? image.hashCode() : 0);
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (typeId != null ? typeId.hashCode() : 0);
        result = 31 * result + (coords != null ? coords.hashCode() : 0);
        return result;
    }
}
