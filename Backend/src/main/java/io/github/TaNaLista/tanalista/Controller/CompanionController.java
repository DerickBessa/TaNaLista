package io.github.TaNaLista.tanalista.Controller;

import io.github.TaNaLista.tanalista.Model.Companion;
import io.github.TaNaLista.tanalista.Service.CompanionService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/companions")
public class CompanionController {

    private final CompanionService companionService;

    public CompanionController(CompanionService companionService) {
        this.companionService = companionService;
    }

    // =========================
    // Criar um novo Companion
    // =========================
    @PostMapping
    public ResponseEntity<Companion> createCompanion(
            @RequestParam UUID userId,
            @RequestParam String name) {

        Companion companion = companionService.create(userId, name);
        return new ResponseEntity<>(companion, HttpStatus.CREATED);
    }

    @GetMapping("/user/{userId}")
    public ResponseEntity<List<Companion>> getCompanionsByUser(@PathVariable UUID userId) {
        List<Companion> companions = companionService.findByUser(userId);
        return ResponseEntity.ok(companions);
    }
}
