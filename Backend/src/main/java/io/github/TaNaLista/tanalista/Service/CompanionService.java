package io.github.TaNaLista.tanalista.Service;

import io.github.TaNaLista.tanalista.Model.Companion;
import io.github.TaNaLista.tanalista.Repository.CompanionRepository;
import io.github.TaNaLista.tanalista.Repository.UserRepository;
import io.github.TaNaLista.tanalista.exception.ConflictException;
import io.github.TaNaLista.tanalista.exception.ResourceNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class CompanionService {

    private final CompanionRepository repository;
    private final UserRepository userRepository;

    public CompanionService(CompanionRepository repository, UserRepository userRepository) {
        this.repository = repository;
        this.userRepository = userRepository;
    }


    public List<Companion> findByName(String companionName){
        return repository.findByCompanionNameContainingIgnoreCase(companionName);
    }

    public void validateCompanionName(UUID userId, String name) {
        if (repository.existsByUserIdAndCompanionNameIgnoreCase(userId, name)) {
            throw new ConflictException("Já existe um companion com esse nome");
        }
    }
    

    public Companion findById(UUID companionId) {
        return repository.findById(companionId)
                .orElseThrow(() -> new ResourceNotFoundException("Companion não encontrado"));
    }

    public List<Companion> findByUser(UUID userId) {
        return repository.findByUserId(userId);
    }

    public void deleteCompanion(UUID companionId) {
        if (!repository.existsById(companionId)) {
            throw new ResourceNotFoundException("Companion não encontrado");
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
        if (!userRepository.existsById(userId)) {
            throw new ResourceNotFoundException("Usuário não encontrado");
        }

        if (repository.existsByUserIdAndCompanionNameIgnoreCase(userId, name)) {
            throw new ConflictException("Já existe um companion com esse nome");
        }

        return repository.save(new Companion(name, userId));
    }


    public List<Companion> getAllCompanions() {
        return repository.findAll();
    }

    public String getCompanionName(UUID companionId) {
        Companion companion = repository.findById(companionId)
                .orElseThrow(() -> new ResourceNotFoundException("Companion não encontrado"));
        return companion.getCompanionName();
    }

    public UUID getUserId(UUID companionId){
        Companion companion = repository.findById(companionId)
                .orElseThrow(() -> new ResourceNotFoundException("Companion não encontrado"));
        return companion.getUserId();
    }

    public void update(UUID companionId, String name) {
        Companion existing = repository.findById(companionId)
                .orElseThrow(() -> new ResourceNotFoundException("Companion não encontrado"));

        if (!existing.getCompanionName().equalsIgnoreCase(name)) {
            if (repository.existsByUserIdAndCompanionNameIgnoreCase(existing.getUserId(), name)) {
                throw new ConflictException("Já existe um companion com esse nome");
            }
            existing.setCompanionName(name);
            repository.saveAndFlush(existing);
        }
    }

    // achar usuario pela compania

    //
}
