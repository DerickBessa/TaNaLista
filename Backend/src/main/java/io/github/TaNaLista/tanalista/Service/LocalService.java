package io.github.TaNaLista.tanalista.Service;

import io.github.TaNaLista.tanalista.DTO.LocalDTO;
import io.github.TaNaLista.tanalista.Model.Local;
import io.github.TaNaLista.tanalista.Repository.LocalRepository;
import io.github.TaNaLista.tanalista.exception.ConflictException;
import io.github.TaNaLista.tanalista.exception.ResourceNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class LocalService {

    private final LocalRepository repository;

    public LocalService(LocalRepository repository) {
        this.repository = repository;
    }

    // Cria um novo Local: valida duplicidade por latitude/longitude, salva e retorna DTO
    @Transactional
    public LocalDTO create(LocalDTO dto) {
        repository.findByLatitudeAndLongitude(dto.latitude(), dto.longitude())
                .ifPresent(l -> { throw new ConflictException("Local com mesmas coordenadas já existe."); });

        Local toSave = dto.toEntity();
        Local saved = repository.save(toSave);
        return new LocalDTO(saved);
    }

    // Busca um Local por id; lança ResourceNotFoundException se não existir
    @Transactional(readOnly = true)
    public LocalDTO getById(Long id) {
        return repository.findById(id)
                .map(LocalDTO::new)
                .orElseThrow(() -> new ResourceNotFoundException("Local não encontrado: " + id));
    }

    // Retorna todos os Locais como lista de DTOs
    @Transactional(readOnly = true)
    public List<LocalDTO> listAll() {
        return repository.findAll().stream()
                .map(LocalDTO::new)
                .collect(Collectors.toList());
    }

    // Busca locais cujo endereço contém o texto informado (case-insensitive)
    @Transactional(readOnly = true)
    public List<LocalDTO> findByAddress(String address) {
        return repository.findByAddressContainingIgnoreCase(address).stream()
                .map(LocalDTO::new)
                .collect(Collectors.toList());
    }

    // Lista locais que possuem link do Google Maps preenchido
    @Transactional(readOnly = true)
    public List<LocalDTO> listWithGoogleMaps() {
        return repository.findByLinkGoogleMapsIsNotNull().stream()
                .map(LocalDTO::new)
                .collect(Collectors.toList());
    }

    // Lista locais que não possuem link do Google Maps
    @Transactional(readOnly = true)
    public List<LocalDTO> listWithoutGoogleMaps() {
        return repository.findByLinkGoogleMapsIsNull().stream()
                .map(LocalDTO::new)
                .collect(Collectors.toList());
    }

    // Atualiza os campos do Local existente a partir do DTO; lança se não encontrar
    @Transactional
    public LocalDTO update(Long id, LocalDTO dto) {
        Local existing = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Local não encontrado para atualizar: " + id));

        existing.setAddress(dto.address());
        existing.setLatitude(dto.latitude());
        existing.setLongitude(dto.longitude());
        existing.setLinkGoogleMaps(dto.linkGoogleMaps());

        Local saved = repository.save(existing);
        return new LocalDTO(saved);
    }

    // Deleta um Local por id; lança se não existir
    @Transactional
    public void delete(Long id) {
        if (!repository.existsById(id)) {
            throw new ResourceNotFoundException("Local não encontrado para deletar: " + id);
        }
        repository.deleteById(id);
    }
}