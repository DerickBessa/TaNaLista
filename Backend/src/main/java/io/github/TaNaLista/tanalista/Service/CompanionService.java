package io.github.TaNaLista.tanalista.Service;

import io.github.TaNaLista.tanalista.Model.Companion;
import io.github.TaNaLista.tanalista.Model.User;
import io.github.TaNaLista.tanalista.Repository.CompanionRepository;
import io.github.TaNaLista.tanalista.Repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class CompanionService {

    private final CompanionRepository repository;
    private final UserRepository UserRepository;

    public CompanionService(CompanionRepository repository, UserRepository userRepository) {
        this.repository = repository;
        this.UserRepository = userRepository;
    }




    public Companion create(UUID userId, String name) {
        if (!UserRepository.existsById(userId)) {
            throw new RuntimeException("Usuário não encontrado");
        }

        return repository.save(new Companion(name, userId));
    }


    public List<Companion> findByUser(UUID userId) {
        return repository.findByUserId(userId);
    }
}
