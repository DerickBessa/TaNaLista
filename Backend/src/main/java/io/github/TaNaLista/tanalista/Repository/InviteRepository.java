package io.github.TaNaLista.tanalista.Repository;

import io.github.TaNaLista.tanalista.Model.Invite;
import io.github.TaNaLista.tanalista.Model.ENUM.InviteStatus;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface InviteRepository extends JpaRepository<Invite, UUID> {

    Optional<Invite> findByInviteCode(String inviteCode);

    Optional<Invite> findByQrCode(String qrCode);

    List<Invite> findByInviteStatus(InviteStatus inviteStatus);

    boolean existsByInviteCode(String inviteCode);

    boolean existsByQrCode(String qrCode);
}