package io.github.TaNaLista.tanalista.Model;

import io.github.TaNaLista.tanalista.Model.ENUM.ChatType;

import java.util.UUID;

public class Chat {
    private UUID id;
    private ChatType chatType;

    public void enviarMensagem(String mensagem) {
        // envio de mensagem no domínio
    }

    public void receberMensagem(String mensagem) {
        // recebimento de mensagem no domínio
    }
}
