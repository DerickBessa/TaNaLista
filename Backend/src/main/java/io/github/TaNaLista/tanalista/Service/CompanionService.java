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


    public List<Companion> findByName(String companionName){

        return repository.findByCompanionNameContainingIgnoreCase(companionName);
    }

    public void validateCompanionName(UUID userId, String name) {
        if (repository.existsByUserIdAndCompanionNameIgnoreCase(userId, name)) {
            throw new RuntimeException("Já existe um companion com esse nome");
        }
    }
    

    public Companion findById(UUID companionId) {

        return repository.findById(companionId).orElse(null);
    }

    public List<Companion> findByUser(UUID userId) {
        return repository.findByUserId(userId);
    }

    public void deleteCompanion(UUID companionId) {
        if (!repository.existsById(companionId)) {
            throw new RuntimeException("Companion não encontrado");
        }
        repository.deleteById(companionId);
    }

    public Companion saveOrUpdate(UUID companionId, Companion companion) {
        if (companionId != null && repository.existsById(companionId)) {
            Companion existing = repository.findById(companionId).get();
            existing.setCompanionName(companion.getCompanionName());

            return repository.saveAndFlush(existing);
        } else {
            return repository.saveAndFlush(companion);
        }
    }

    public Companion create(UUID userId, String name) {
        if (!UserRepository.existsById(userId)) {
            throw new RuntimeException("Usuário não encontrado");
        }

        return repository.save(new Companion(name, userId));
    }


    public List<Companion> getAllCompanions() {
        return repository.findAll();
    }

    public String getCompanionName(UUID companionId) {
        Companion companion = repository.findById(companionId)
                .orElseThrow(() -> new RuntimeException("Companion não encontrado"));
        return companion.getCompanionName();
    }

    public UUID getUserId(UUID companionId){
        Companion companion = repository.findById(companionId)
                .orElseThrow(() -> new RuntimeException("Companion não encontrado"));
        return companion.getUserId();
    }


    // achar usuario pela compania

    //
}
