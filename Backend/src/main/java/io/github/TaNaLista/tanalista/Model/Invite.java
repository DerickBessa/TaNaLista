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
    // GETTERS
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

    public InviteStatus getInviteStatus() {
        return inviteStatus;
    }

    // =========================
    // REGRAS DE NEGÓCIO
    // =========================

    public void validar() {
        // lógica futura
    }

    public void marcarComoUsado() {
        this.inviteStatus = InviteStatus.USED;
    }
}
