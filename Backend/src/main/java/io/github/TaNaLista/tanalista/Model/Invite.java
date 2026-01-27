package io.github.TaNaLista.tanalista.Model;

import java.util.UUID;

import io.github.TaNaLista.tanalista.Model.ENUM.InviteStatus;

import jakarta.persistence.*;

@Entity
@Table(name = "invites")
public class Invite {

    // =========================
    // ATRIBUTOS
    // =========================

    @Id
    @GeneratedValue
    private UUID id;

    @Column(nullable = false, unique = true)
    private String inviteCode;

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
    // GETTERS MANUAIS
    // =========================

    public UUID getId() {
        return id;
    }

    public String getInviteCode() {
        return inviteCode;
    }

    public String getQrCode() {
        return qrCode;
    }

    // =========================
    // GETTERS / REGRAS DE NEGÓCIO
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
