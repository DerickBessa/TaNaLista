package io.github.TaNaLista.tanalista.DTO;

import io.github.TaNaLista.tanalista.Model.Event;
import io.github.TaNaLista.tanalista.Model.ENUM.EventStatus;
import io.github.TaNaLista.tanalista.Model.ENUM.EventType;

import java.time.LocalDateTime;
import java.util.UUID;

public record EventDTO(
        UUID id,
        String name,
        String description,
        LocalDateTime eventDate,
        EventType eventType,
        int limitIvitedPersons,
        boolean guestCanInvite,
        EventStatus eventStatus
) {
    // Construtor para criar DTO a partir da entidade
    public EventDTO(Event event) {
        this(
                event.getId(),
                event.getName(),
                event.getDescription(),
                event.getEventDate(),
                event.getEventType(),
                event.getLimitIvitedPersons(),
                event.isGuestCanInvite(),
                event.getEventStatus()
        );
    }

    // Método para converter DTO em entidade
    public Event toEntity() {
        return new Event(
                this.name,
                this.description,
                this.eventDate,
                this.eventType,
                this.limitIvitedPersons,
                this.guestCanInvite,
                this.eventStatus
        );
    }
}