package io.github.TaNaLista.tanalista.Service;

import io.github.TaNaLista.tanalista.DTO.UserDTO;
import io.github.TaNaLista.tanalista.Model.User;
import io.github.TaNaLista.tanalista.Repository.UserRepository;
import io.github.TaNaLista.tanalista.exception.ConflictException;
import io.github.TaNaLista.tanalista.exception.ResourceNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class UserService {

    private final UserRepository repository;

    public UserService(UserRepository repository) {
        this.repository = repository;
    }

    // Cria um novo usuário; valida duplicidade de email/cpf/phone
    @Transactional
    public UserDTO create(UserDTO dto) {
        if (repository.existsByEmail(dto.email())) {
            throw new ConflictException("Email já cadastrado");
        }
        if (repository.existsByCpf(dto.cpf())) {
            throw new ConflictException("CPF já cadastrado");
        }
        if (repository.existsByPhone(dto.phone())) {
            throw new ConflictException("Telefone já cadastrado");
        }

        User toSave = dto.toEntity();
        User saved = repository.save(toSave);
        return new UserDTO(saved);
    }

    // Retorna usuário por id
    @Transactional(readOnly = true)
    public UserDTO getById(UUID id) {
        return repository.findById(id)
                .map(UserDTO::new)
                .orElseThrow(() -> new ResourceNotFoundException("Usuário não encontrado: " + id));
    }

    // Lista todos os usuários
    @Transactional(readOnly = true)
    public List<UserDTO> listAll() {
        return repository.findAll().stream().map(UserDTO::new).collect(Collectors.toList());
    }

    // Atualiza um usuário existente
    @Transactional
    public UserDTO update(UUID id, UserDTO dto) {
        User existing = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Usuário não encontrado: " + id));

        // valida duplicidade em outros registros
        if (!existing.getEmail().equalsIgnoreCase(dto.email()) && repository.existsByEmail(dto.email())) {
            throw new ConflictException("Email já cadastrado por outro usuário");
        }
        if (!existing.getCpf().equals(dto.cpf()) && repository.existsByCpf(dto.cpf())) {
            throw new ConflictException("CPF já cadastrado por outro usuário");
        }
        if (!existing.getPhone().equals(dto.phone()) && repository.existsByPhone(dto.phone())) {
            throw new ConflictException("Telefone já cadastrado por outro usuário");
        }

        existing.setName(dto.name());
        existing.setEmail(dto.email());
        existing.setPhone(dto.phone());
        existing.setUserType(dto.userType());

        User saved = repository.save(existing);
        return new UserDTO(saved);
    }

    // Deleta um usuário por id
    @Transactional
    public void delete(UUID id) {
        if (!repository.existsById(id)) {
            throw new ResourceNotFoundException("Usuário não encontrado: " + id);
        }
        repository.deleteById(id);
    }

    // Busca por email
    @Transactional(readOnly = true)
    public UserDTO findByEmail(String email) {
        return repository.findByEmail(email).map(UserDTO::new)
                .orElseThrow(() -> new ResourceNotFoundException("Usuário não encontrado com email: " + email));
    }

    // Busca por cpf
    @Transactional(readOnly = true)
    public UserDTO findByCpf(String cpf) {
        return repository.findByCpf(cpf).map(UserDTO::new)
                .orElseThrow(() -> new ResourceNotFoundException("Usuário não encontrado com CPF: " + cpf));
    }

    // Busca por nome parcial
    @Transactional(readOnly = true)
    public List<UserDTO> findByName(String name) {
        return repository.findByNameContainingIgnoreCase(name).stream().map(UserDTO::new).collect(Collectors.toList());
    }
}
