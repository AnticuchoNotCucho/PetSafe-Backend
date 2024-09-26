package org.anticuchonotcucho.petsafeapi.model.entity;

import java.io.Serializable;

public class RolePermissionEntityPK implements Serializable {
    private int roleId;
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

        RolePermissionEntityPK that = (RolePermissionEntityPK) o;

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
