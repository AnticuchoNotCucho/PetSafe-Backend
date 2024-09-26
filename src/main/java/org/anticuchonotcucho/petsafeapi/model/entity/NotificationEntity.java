package org.anticuchonotcucho.petsafeapi.model.entity;

import jakarta.persistence.*;

import java.sql.Timestamp;

@Entity
@jakarta.persistence.Table(name = "notification", schema = "public", catalog = "postgres")
public class NotificationEntity {
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
    @Column(name = "user_id", nullable = false)
    private int userId;

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    @Basic
    @Column(name = "message", nullable = false, length = -1)
    private String message;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @Basic
    @Column(name = "type", nullable = false, length = 50)
    private String type;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Basic
    @Column(name = "is_read", nullable = true)
    private Boolean isRead;

    public Boolean getRead() {
        return isRead;
    }

    public void setRead(Boolean read) {
        isRead = read;
    }

    @Basic
    @Column(name = "point_id", nullable = true)
    private Integer pointId;

    public Integer getPointId() {
        return pointId;
    }

    public void setPointId(Integer pointId) {
        this.pointId = pointId;
    }

    @Basic
    @Column(name = "created_at", nullable = false)
    private Timestamp createdAt;

    public Timestamp getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Timestamp createdAt) {
        this.createdAt = createdAt;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        NotificationEntity that = (NotificationEntity) o;

        if (id != that.id) return false;
        if (userId != that.userId) return false;
        if (message != null ? !message.equals(that.message) : that.message != null) return false;
        if (type != null ? !type.equals(that.type) : that.type != null) return false;
        if (isRead != null ? !isRead.equals(that.isRead) : that.isRead != null) return false;
        if (pointId != null ? !pointId.equals(that.pointId) : that.pointId != null) return false;
        if (createdAt != null ? !createdAt.equals(that.createdAt) : that.createdAt != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + userId;
        result = 31 * result + (message != null ? message.hashCode() : 0);
        result = 31 * result + (type != null ? type.hashCode() : 0);
        result = 31 * result + (isRead != null ? isRead.hashCode() : 0);
        result = 31 * result + (pointId != null ? pointId.hashCode() : 0);
        result = 31 * result + (createdAt != null ? createdAt.hashCode() : 0);
        return result;
    }
}
