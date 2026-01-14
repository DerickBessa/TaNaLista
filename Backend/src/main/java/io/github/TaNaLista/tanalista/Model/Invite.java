package io.github.TaNaLista.tanalista.Model;

import java.util.UUID;

import io.github.TaNaLista.tanalista.Model.ENUM.InviteStatus;

import jakarta.persistence.*;
import lombok.Getter;

@Entity
@Table(name = "invites")
public class Invite {

    // =========================
    // ATRIBUTOS
    // =========================

    @Getter
    @Id
    @GeneratedValue
    private UUID id;

    @Getter
    @Column(nullable = false, unique = true)
    private String inviteCode;

    @Getter
    @Column(nullable = false, unique = true)
    private String qrCode;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private InviteStatus inviteStatus;

    // =========================
    // CONSTRUTORES
    // =========================

    protected Invite() {
    }

    public Invite(String inviteCode, String qrCode, InviteStatus inviteStatus) {
        this.inviteCode = inviteCode;
        this.qrCode = qrCode;
        this.inviteStatus = inviteStatus;
    }

    // =========================
    // GETTERS
    // =========================

    public boolean isValid() {
        return this.inviteStatus == InviteStatus.VALID;
    }

    public boolean isUsed() {
        return this.inviteStatus == InviteStatus.USED;
    }

    public boolean isExpired() {
        return this.inviteStatus == InviteStatus.EXPIRED;
    }

    public void validar() {
        // lógica futura
    }

    public void marcarComoUsado() {
        this.inviteStatus = InviteStatus.USED;
    }
}
