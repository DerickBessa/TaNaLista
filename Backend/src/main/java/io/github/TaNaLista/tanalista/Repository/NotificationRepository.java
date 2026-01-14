package io.github.TaNaLista.tanalista.Repository;

import io.github.TaNaLista.tanalista.Model.Notification;
import io.github.TaNaLista.tanalista.Model.ENUM.NotificationType;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

public interface NotificationRepository extends JpaRepository<Notification, UUID> {

    List<Notification> findByTypeNotification(NotificationType typeNotification);

    List<Notification> findByDateAfter(LocalDateTime date);

    List<Notification> findByDateBefore(LocalDateTime date);

    List<Notification> findByDateBetween(LocalDateTime startDate, LocalDateTime endDate);

    List<Notification> findByDescriptionContainingIgnoreCase(String description);
}