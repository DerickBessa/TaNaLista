package io.github.TaNaLista.tanalista.Controller;

import io.github.TaNaLista.tanalista.DTO.CompanionDTO;
import io.github.TaNaLista.tanalista.Model.Companion;
import io.github.TaNaLista.tanalista.Service.CompanionService;
import io.github.TaNaLista.tanalista.exception.ErrorDetails;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.annotation.RequestScope;

import java.util.List;
import java.util.Objects;
import java.util.UUID;

import static org.springframework.http.ResponseEntity.*;
import static org.springframework.web.servlet.support.ServletUriComponentsBuilder.fromCurrentRequestUri;

@Slf4j
@RequestScope
@RestController
@RequestMapping(value = "companions")
@Tag(name = "Companion", description = "The Companion API. Contains all the operations that can be performed on a Companion")
@ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Request Ok"),
        @ApiResponse(responseCode = "401", description = "Not authenticated agent (missing or invalid credentials)"),
        @ApiResponse(responseCode = "403", description = "Ops! You do not have permission to access this feature! :("),
        @ApiResponse(responseCode = "404", description = "Resource not found"),
        @ApiResponse(responseCode = "500", description = "Internal server error",
                content = {@Content(mediaType = "application/json", schema = @Schema(implementation = ErrorDetails.class))})
})
public class CompanionController {

    private final CompanionService companionService;

    public CompanionController(CompanionService companionService) {
        this.companionService = companionService;
    }

    @Operation(summary = "Save Companion", description = "Saves the Companion in the database and returns the created object")
    @PostMapping
    @ResponseStatus(value = HttpStatus.CREATED)
    public ResponseEntity<CompanionDTO> save(
            @RequestParam UUID userId,
            @RequestParam String name) {

        companionService.validateCompanionName(userId, name);
        Companion companion = companionService.create(userId, name);
        return created(fromCurrentRequestUri().path(companion.getId().toString()).build().toUri())
                .body(new CompanionDTO(companion));
    }

    @Operation(summary = "Get Companion", description = "Get a companion by ID")
    @GetMapping("{id}")
    @ResponseStatus(value = HttpStatus.OK)
    @ApiResponse(responseCode = "200", description = "Request Ok")
    public ResponseEntity<CompanionDTO> getOne(@PathVariable(value = "id") UUID id) {
        Companion companion = companionService.findById(id);
        if (companion == null) {
            return notFound().build();
        }
        return ok().body(new CompanionDTO(companion));
    }

    @Operation(summary = "Get All Companions", description = "Get all Companions registered")
    @GetMapping
    @ResponseStatus(value = HttpStatus.OK)
    public ResponseEntity<List<CompanionDTO>> getAll() {
        List<Companion> companions = companionService.getAllCompanions();
        List<CompanionDTO> dtos = companions.stream()
                .map(CompanionDTO::new)
                .toList();
        return ok().body(dtos);
    }

    @Operation(summary = "Get Companions By User", description = "Get companions by user ID")
    @GetMapping("user/{userId}")
    @ResponseStatus(value = HttpStatus.OK)
    @ApiResponse(responseCode = "200", description = "Request Ok")
    public ResponseEntity<List<CompanionDTO>> getAllByUser(@PathVariable(value = "userId") UUID userId) {
        List<Companion> companions = companionService.findByUser(userId);
        List<CompanionDTO> dtos = companions.stream()
                .map(CompanionDTO::new)
                .toList();
        return ok().body(dtos);
    }

    @Operation(summary = "Search Companions", description = "Search companions by name")
    @GetMapping("search")
    @ResponseStatus(value = HttpStatus.OK)
    public ResponseEntity<List<CompanionDTO>> searchByName(@RequestParam String name) {
        List<Companion> companions = companionService.findByName(name);
        List<CompanionDTO> dtos = companions.stream()
                .map(CompanionDTO::new)
                .toList();
        return ok().body(dtos);
    }

    @Operation(summary = "Update Companion", description = "Updates the Companion by its attributes")
    @PutMapping("{id}")
    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    public ResponseEntity updateCompanion(
            @PathVariable(value = "id") UUID id,
            @RequestParam String name) {

        UUID userId = companionService.getUserId(id);
        companionService.validateCompanionName(userId, name);

        Companion companion = new Companion(name, userId);
        companionService.saveOrUpdate(id, companion);

        return noContent().build();
    }

    @Operation(summary = "Delete Companion", description = "Delete Companion by id (UUID)")
    @DeleteMapping("{id}")
    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    public ResponseEntity delete(@PathVariable("id") UUID id) {
        companionService.deleteCompanion(id);
        return noContent().build();
    }

    @Operation(summary = "Delete all Companions", description = "Delete all Companions by ids (UUID)")
    @PostMapping("/delete-by-ids")
    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    public ResponseEntity deleteAll(@RequestBody List<UUID> listId) {
        listId.forEach(companionService::deleteCompanion);
        return noContent().build();
    }
}