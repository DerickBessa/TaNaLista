package io.github.TaNaLista.tanalista.Model;

import io.github.TaNaLista.tanalista.Model.ENUM.NotificationType;

import java.util.UUID;
import java.time.LocalDateTime;

import jakarta.persistence.*;

@Entity
@Table(name = "notifications")
public class Notification {

    // =========================
    // ATRIBUTOS
    // =========================

    @Id
    @GeneratedValue
    private UUID id;

    @Column(nullable = false)
    private String description;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private NotificationType typeNotification;

    @Column(nullable = false)
    private LocalDateTime date;

    // =========================
    // CONSTRUTORES
    // =========================

    protected Notification() {
    }

    public Notification(String description, NotificationType typeNotification, LocalDateTime date) {
        this.description = description;
        this.typeNotification = typeNotification;
        this.date = date;
    }

    // =========================
    // GETTERS
    // =========================

    public UUID getId() {
        return id;
    }

    public String getDescription() {
        return description;
    }

    public NotificationType getTypeNotification() {
        return typeNotification;
    }

    public LocalDateTime getDate() {
        return date;
    }

    // =========================
    // REGRAS DE NEGÓCIO
    // =========================

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
