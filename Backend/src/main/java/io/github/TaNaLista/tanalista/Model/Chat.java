package io.github.TaNaLista.tanalista.Model;

import io.github.TaNaLista.tanalista.Model.ENUM.ChatType;

import jakarta.persistence.*;
import java.util.UUID;

@Entity
@Table(name = "chats")
public class Chat {

    @Id
    @GeneratedValue
    private UUID id;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private ChatType chatType;

    // Construtor protegido vazio
    protected Chat() {
    }

    // Construtor de domínio
    public Chat(ChatType chatType) {
        this.chatType = chatType;
    }

    public boolean isBot() {
        return this.chatType == ChatType.BOT;
    }

    public boolean isManager() {
        return this.chatType == ChatType.MANAGER;
    }

    // Getters
    public UUID getId() {
        return id;
    }

    public ChatType getChatType() {
        return chatType;
    }

    // Regras de negócio
    public void enviarMensagem(String mensagem) {
        // envio de mensagem no domínio
    }

    public void receberMensagem(String mensagem) {
        // recebimento de mensagem no domínio
    }
}
