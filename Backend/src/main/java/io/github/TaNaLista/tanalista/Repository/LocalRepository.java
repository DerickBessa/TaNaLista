package io.github.TaNaLista.tanalista.Repository;

import io.github.TaNaLista.tanalista.Model.Local;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface LocalRepository extends JpaRepository<Local, Long> {

    List<Local> findByAddressContainingIgnoreCase(String address);

    Optional<Local> findByLatitudeAndLongitude(double latitude, double longitude);

    List<Local> findByLinkGoogleMapsIsNotNull();

    List<Local> findByLinkGoogleMapsIsNull();
}