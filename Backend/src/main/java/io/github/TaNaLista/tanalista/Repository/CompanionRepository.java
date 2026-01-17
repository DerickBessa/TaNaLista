package io.github.TaNaLista.tanalista.Repository;

import io.github.TaNaLista.tanalista.Model.Companion;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface CompanionRepository extends JpaRepository<Companion, UUID> {

    List<Companion> findByCompanionNameContainingIgnoreCase(String companionName);

    List<Companion> findByUserId(UUID userId);

    boolean existsByUserIdAndCompanionNameIgnoreCase(UUID userId, String name);
}