package edu.espe.f1.service;

import edu.espe.f1.entity.Team;
import edu.espe.f1.repository.TeamRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
public class TeamService {

    @Autowired
    private TeamRepository teamRepository;

    public List<Team> getAllTeams() {
        return teamRepository.findAll();
    }

    public Team getTeamById(String id) {
        return teamRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Escudería no encontrada con ID: " + id));
    }

    public Team createTeam(Team team) {
        if (teamRepository.existsById(team.getId())) {
            throw new ResponseStatusException(HttpStatus.CONFLICT, "La escudería ya existe con el ID: " + team.getId());
        }
        return teamRepository.save(team);
    }

    public Team updateTeam(String id, Team teamDetails) {
        Team team = getTeamById(id);
        team.setName(teamDetails.getName());
        team.setFullName(teamDetails.getFullName());
        team.setBase(teamDetails.getBase());
        team.setFounded(teamDetails.getFounded());
        team.setChampionships(teamDetails.getChampionships());
        team.setColor(teamDetails.getColor());
        team.setWins(teamDetails.getWins());
        return teamRepository.save(team);
    }

    public void deleteTeam(String id) {
        Team team = getTeamById(id);
        teamRepository.delete(team);
    }
}