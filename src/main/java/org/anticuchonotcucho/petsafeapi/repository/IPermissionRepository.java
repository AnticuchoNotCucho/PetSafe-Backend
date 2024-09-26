package org.anticuchonotcucho.petsafeapi.repository;

import org.anticuchonotcucho.petsafeapi.model.entity.PermissionEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository

public interface IPermissionRepository extends JpaRepository<PermissionEntity, Integer> {
}
