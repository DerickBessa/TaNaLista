package io.github.TaNaLista.tanalista.Repository;

import io.github.TaNaLista.tanalista.Model.Event;
import io.github.TaNaLista.tanalista.Model.ENUM.EventStatus;
import io.github.TaNaLista.tanalista.Model.ENUM.EventType;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

public interface EventRepository extends JpaRepository<Event, UUID> {

    List<Event> findByEventStatus(EventStatus eventStatus);

    List<Event> findByEventType(EventType eventType);

    List<Event> findByEventDateAfter(LocalDateTime date);

    List<Event> findByEventDateBefore(LocalDateTime date);

    List<Event> findByEventDateBetween(LocalDateTime startDate, LocalDateTime endDate);

    List<Event> findByNameContainingIgnoreCase(String name);

    List<Event> findByGuestCanInvite(boolean guestCanInvite);

    List<Event> findByEventStatusAndEventType(EventStatus eventStatus, EventType eventType);
}