package org.anticuchonotcucho.petsafeapi.model.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.IdClass;
import jakarta.persistence.Table;
import jakarta.persistence.Column;

@Entity
@Table(name = "role_permission", schema = "public", catalog = "postgres")
@IdClass(RolePermissionEntityPK.class)
public class RolePermissionEntity {

    @Id
    @Column(name = "role_id", nullable = false)
    private int roleId;

    @Id
    @Column(name = "permission_id", nullable = false)
    private int permissionId;

    // Getters y setters
    public int getRoleId() {
        return roleId;
    }

    public void setRoleId(int roleId) {
        this.roleId = roleId;
    }

    public int getPermissionId() {
        return permissionId;
    }

    public void setPermissionId(int permissionId) {
        this.permissionId = permissionId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        RolePermissionEntity that = (RolePermissionEntity) o;

        if (roleId != that.roleId) return false;
        return permissionId == that.permissionId;
    }

    @Override
    public int hashCode() {
        int result = roleId;
        result = 31 * result + permissionId;
        return result;
    }
}
