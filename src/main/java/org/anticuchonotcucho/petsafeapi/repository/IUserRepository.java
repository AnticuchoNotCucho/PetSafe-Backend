package org.anticuchonotcucho.petsafeapi.repository;

import org.anticuchonotcucho.petsafeapi.model.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IUserRepository extends JpaRepository<UserEntity, Integer> {
}
