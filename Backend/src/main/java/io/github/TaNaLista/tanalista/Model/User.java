package io.github.TaNaLista.tanalista.Model;

import io.github.TaNaLista.tanalista.Model.ENUM.UserType;

import java.util.UUID;


public class User {

    private UUID id;
    private String name;
    private String cpf;
    private String email;
    private String phone;
    private UserType typeUser;

    public void autenticar() {
        // regra de negócio de autenticação (ainda não implementada)
    }

    public void atualizarPerfil(String name, String phone) {
        // regra de negócio para atualizar dados do usuário
    }
}
