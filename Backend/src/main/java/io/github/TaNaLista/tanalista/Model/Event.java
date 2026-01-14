package io.github.TaNaLista.tanalista.Model;

import java.util.UUID;
import java.time.LocalDateTime;

import io.github.TaNaLista.tanalista.Model.ENUM.EventStatus;
import io.github.TaNaLista.tanalista.Model.ENUM.EventType;

import jakarta.persistence.*;

@Entity
@Table(name = "events")
public class Event {

    // =========================
    // ATRIBUTOS
    // =========================

    @Id
    @GeneratedValue
    private UUID id;

    @Column(nullable = false)
    private String name;

    private String description;

    @Column(nullable = false)
    private LocalDateTime eventDate;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private EventType eventType;

    @Column(nullable = false)
    private int limitIvitedPersons;

    @Column(nullable = false)
    private boolean guestCanInvite;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private EventStatus eventStatus;

    // =========================
    // CONSTRUTORES
    // =========================

    protected Event() {
    }

    public boolean isSmall() {
        return this.eventType == io.github.TaNaLista.tanalista.Model.ENUM.EventType.SMALL;
    }

    public boolean isBig() {
        return this.eventType == io.github.TaNaLista.tanalista.Model.ENUM.EventType.BIG;
    }

    public Event(
            String name,
            String description,
            LocalDateTime eventDate,
            EventType eventType,
            int limitIvitedPersons,
            boolean guestCanInvite,
            EventStatus eventStatus
    ) {
        this.name = name;
        this.description = description;
        this.eventDate = eventDate;
        this.eventType = eventType;
        this.limitIvitedPersons = limitIvitedPersons;
        this.guestCanInvite = guestCanInvite;
        this.eventStatus = eventStatus;
    }

    // =========================
    // GETTERS
    // =========================

    public UUID getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public LocalDateTime getEventDate() {
        return eventDate;
    }

    public EventType getEventType() {
        return eventType;
    }

    public int getLimitIvitedPersons() {
        return limitIvitedPersons;
    }

    public boolean isGuestCanInvite() {
        return guestCanInvite;
    }

    public EventStatus getEventStatus() {
        return eventStatus;
    }

    // =========================
    // REGRAS DE NEGÓCIO
    // =========================

    public void abrirEvento() {
        this.eventStatus = EventStatus.OPEN;
    }

    public void encerrarEvento() {
        this.eventStatus = EventStatus.CLOSED;
    }

    public void permitirConvites() {
        this.guestCanInvite = true;
    }

    public void bloquearConvites() {
        this.guestCanInvite = false;
    }
}
