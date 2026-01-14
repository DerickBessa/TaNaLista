package io.github.TaNaLista.tanalista.Model;

import io.github.TaNaLista.tanalista.Model.ENUM.NotificationType;

import java.util.UUID;
import java.time.LocalDateTime;

public class Notification {

    private UUID id;
    private String description;
    private NotificationType type_notification;
    private LocalDateTime date;

    public void iniciar() {
        // comportamento do domínio
    }

    public void encerrar() {
        // comportamento do domínio
    }

    public void enviarMensagem(String mensagem) {
        // comportamento do domínio
    }
}
