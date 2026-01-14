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

    public void abrirEvento() {
        // evento passa para estado aberto
    }

    public void encerrarEvento() {
        // evento passa para estado encerrado
    }

    public void permitirConvites() {
        // convidados podem convidar outros
    }

    public void bloquearConvites() {
        // convidados não podem mais convidar
    }
}
