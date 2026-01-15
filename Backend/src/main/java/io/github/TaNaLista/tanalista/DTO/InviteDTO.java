package io.github.TaNaLista.tanalista.DTO;

import io.github.TaNaLista.tanalista.Model.Invite;
import io.github.TaNaLista.tanalista.Model.ENUM.InviteStatus;

import java.util.UUID;

public record InviteDTO(
        UUID id,
        String inviteCode,
        String qrCode,
        InviteStatus inviteStatus
) {
    // Construtor para criar DTO a partir da entidade
    public InviteDTO(Invite invite) {
        this(
                invite.getId(),
                invite.getInviteCode(),
                invite.getQrCode(),
                invite.isValid() ? InviteStatus.VALID :
                        invite.isUsed() ? InviteStatus.USED : InviteStatus.EXPIRED
        );
    }

    // Método para converter DTO em entidade
    public Invite toEntity() {
        return new Invite(this.inviteCode, this.qrCode, this.inviteStatus);
    }
}