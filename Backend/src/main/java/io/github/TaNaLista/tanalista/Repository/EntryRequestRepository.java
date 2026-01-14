package io.github.TaNaLista.tanalista.Repository;

import io.github.TaNaLista.tanalista.Model.EntryRequest;
import io.github.TaNaLista.tanalista.Model.ENUM.RequestStatus;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface EntryRequestRepository extends JpaRepository<EntryRequest, UUID> {

    List<EntryRequest> findByRequestStatus(RequestStatus requestStatus);

    List<EntryRequest> findByTotalGuestCompanionsGreaterThan(int totalGuestCompanions);

    List<EntryRequest> findByTotalGuestCompanionsLessThanEqual(int totalGuestCompanions);
}