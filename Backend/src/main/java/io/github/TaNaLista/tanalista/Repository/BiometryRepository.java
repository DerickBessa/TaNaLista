package io.github.TaNaLista.tanalista.Repository;

import io.github.TaNaLista.tanalista.Model.Biometry;
import io.github.TaNaLista.tanalista.Model.ENUM.BiometryType;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface BiometryRepository extends JpaRepository<Biometry, Long> {

    List<Biometry> findByBiometryType(BiometryType biometryType);

    Optional<Biometry> findByHash(String hash);

    boolean existsByHash(String hash);
}