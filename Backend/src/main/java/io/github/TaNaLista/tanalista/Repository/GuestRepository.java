package io.github.TaNaLista.tanalista.Repository;

import io.github.TaNaLista.tanalista.Model.Guest;
import io.github.TaNaLista.tanalista.Model.ENUM.GuestType;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface GuestRepository extends JpaRepository<Guest, Long> {

    List<Guest> findByGuestType(GuestType guestType);
}