package io.github.TaNaLista.tanalista.Model;

import java.util.UUID;

public class EntryRequest {

    private UUID id;
    private int totalGuestCompanions;
    private RequestStatus requestStatus;

    public void aprovar() {
        // solicitação passa para estado APROVADA
    }

    public void rejeitar() {
        // solicitação passa para estado REJEITADA
    }
}
