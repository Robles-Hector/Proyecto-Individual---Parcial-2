package edu.espe.f1.controller;

import edu.espe.f1.entity.Team;
import edu.espe.f1.service.TeamService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/teams")
@CrossOrigin(origins = "*")
public class TeamController {

    @Autowired
    private TeamService teamService;

    // 1. OBTENER TODAS LAS ESCUDERÍAS
    @GetMapping
    public ResponseEntity<List<Team>> getAllTeams() {
        return ResponseEntity.ok(teamService.getAllTeams());
    }

    // 2. OBTENER UNA ESCUDERÍA POR ID
    @GetMapping("/{id}")
    public ResponseEntity<Team> getTeamById(@PathVariable String id) {
        return ResponseEntity.ok(teamService.getTeamById(id));
    }

    // 3. REGISTRAR NUEVA ESCUDERÍA (Envía 201 Created)
    @PostMapping
    public ResponseEntity<Team> createTeam(@Valid @RequestBody Team team) {
        return new ResponseEntity<>(teamService.createTeam(team), HttpStatus.CREATED);
    }

    // 4. ACTUALIZAR ESCUDERÍA EXISTENTE
    @Valid
    @PutMapping("/{id}")
    public ResponseEntity<Team> updateTeam(@PathVariable String id, @Valid @RequestBody Team teamDetails) {
        return ResponseEntity.ok(teamService.updateTeam(id, teamDetails));
    }

    // 5. ELIMINAR UNA ESCUDERÍA (Envía 204 No Content)
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTeam(@PathVariable String id) {
        teamService.deleteTeam(id);
        return ResponseEntity.noContent().build();
    }
}