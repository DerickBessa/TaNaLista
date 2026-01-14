package io.github.TaNaLista.tanalista.Repository;

import io.github.TaNaLista.tanalista.Model.Chat;
import io.github.TaNaLista.tanalista.Model.ENUM.ChatType;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface ChatRepository extends JpaRepository<Chat, UUID> {

    List<Chat> findByChatType(ChatType chatType);
}