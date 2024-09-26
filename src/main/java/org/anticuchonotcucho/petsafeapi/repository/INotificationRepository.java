package org.anticuchonotcucho.petsafeapi.repository;

import org.anticuchonotcucho.petsafeapi.model.entity.NotificationEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository

public interface INotificationRepository extends JpaRepository<NotificationEntity, Integer> {
}
