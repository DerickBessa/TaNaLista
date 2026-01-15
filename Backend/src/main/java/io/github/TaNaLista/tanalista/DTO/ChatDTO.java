package io.github.TaNaLista.tanalista.DTO;

import io.github.TaNaLista.tanalista.Model.Chat;
import io.github.TaNaLista.tanalista.Model.ENUM.ChatType;

import java.util.UUID;

public record ChatDTO(
        UUID id,
        ChatType chatType
) {
    // Construtor para criar DTO a partir da entidade
    public ChatDTO(Chat chat) {
        this(
                chat.getId(),
                chat.getChatType()
        );
    }

    // Método para converter DTO em entidade
    public Chat toEntity() {
        return new Chat(this.chatType);
    }
}