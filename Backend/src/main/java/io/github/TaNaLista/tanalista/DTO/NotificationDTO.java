package io.github.TaNaLista.tanalista.DTO;

import io.github.TaNaLista.tanalista.Model.Notification;
import io.github.TaNaLista.tanalista.Model.ENUM.NotificationType;

import java.time.LocalDateTime;
import java.util.UUID;

public record NotificationDTO(
        UUID id,
        String description,
        NotificationType typeNotification,
        LocalDateTime date
) {
    // Construtor para criar DTO a partir da entidade
    public NotificationDTO(Notification notification) {
        this(
                notification.getId(),
                notification.getDescription(),
                notification.getTypeNotification(),
                notification.getDate()
        );
    }

    // Método para converter DTO em entidade
    public Notification toEntity() {
        return new Notification(
                this.description,
                this.typeNotification,
                this.date
        );
    }
}