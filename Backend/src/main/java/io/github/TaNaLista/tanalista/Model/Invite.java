package io.github.TaNaLista.tanalista.Model;

import java.util.UUID;

public class Invite {

    private UUID id;
    private String InviteCode;
    private String  qrCode;
    private InviteStatus inviteStatus;

    public void validar() {
        // lógica será definida depois
    }

    public void marcarComoUsado() {
        // lógica será definida depois
    }
}
