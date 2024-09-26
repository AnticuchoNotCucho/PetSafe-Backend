package org.anticuchonotcucho.petsafeapi.repository;

import org.anticuchonotcucho.petsafeapi.model.entity.RolePermissionEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository

public interface IRolePermissionRepository extends JpaRepository<RolePermissionEntity, Integer> {
}
