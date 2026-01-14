package io.github.TaNaLista.tanalista.Model;

import io.github.TaNaLista.tanalista.Model.ENUM.RequestStatus;


import jakarta.persistence.*;
import java.util.UUID;

@Entity
@Table(name = "entry_requests")
public class EntryRequest {

    @Id
    @GeneratedValue
    private UUID id;

    @Column(nullable = false)
    private int totalGuestCompanions;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private RequestStatus requestStatus;

    // Construtor protegido vazio
    protected EntryRequest() {
    }

    // Construtor de domínio
    public EntryRequest(int totalGuestCompanions, RequestStatus requestStatus) {
        this.totalGuestCompanions = totalGuestCompanions;
        this.requestStatus = requestStatus;
    }

    // Getters
    public UUID getId() {
        return id;
    }

    public int getTotalGuestCompanions() {
        return totalGuestCompanions;
    }

    public RequestStatus getRequestStatus() {

        return requestStatus;
    }

    // Regras de negócio
    public void aprovar() {

        this.requestStatus = RequestStatus.APPROVED;
    }

    public void rejeitar() {

        this.requestStatus = RequestStatus.REJECTED;
    }
}
