package org.anticuchonotcucho.petsafeapi.repository;

import org.anticuchonotcucho.petsafeapi.model.entity.RoleEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository

public interface IRoleRepository extends JpaRepository<RoleEntity, Integer> {
}
