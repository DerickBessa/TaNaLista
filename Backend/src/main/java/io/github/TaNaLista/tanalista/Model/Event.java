package io.github.TaNaLista.tanalista.Model;

import java.util.UUID;
import java.time.LocalDateTime;

import io.github.TaNaLista.tanalista.Model.ENUM.EventStatus;
import io.github.TaNaLista.tanalista.Model.ENUM.EventType;

public class Event {

    private UUID id;
    private String name;
    private String description;
    private LocalDateTime eventDate;
    private EventType eventType;
    private int limitIvitedPersons;
    private boolean guestCanInvite;
    private EventStatus eventStatus;
}
