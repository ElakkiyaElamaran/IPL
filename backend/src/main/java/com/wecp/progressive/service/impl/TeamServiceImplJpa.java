package com.wecp.progressive.service.impl;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wecp.progressive.entity.Team;
import com.wecp.progressive.repository.TeamRepository;
import com.wecp.progressive.service.TeamService;
@Service
public class TeamServiceImplJpa implements TeamService {

    @Autowired
    private TeamRepository teamRepository;
     @Override
    public List<Team> getAllTeams() throws SQLException {
        return teamRepository.findAll();
    }

    @Override
    public Team getTeamById(int teamId) throws SQLException {
        return teamRepository.findById((long) teamId).orElse(null);
    }

    @Override
    public int addTeam(Team team) throws SQLException {
        Team savedTeam = teamRepository.save(team);
        return savedTeam.getTeamId();
    }
    
    @Override
    public void updateTeam(Team team) throws SQLException {
        if (teamRepository.existsById((long) team.getTeamId())) {
            teamRepository.save(team);
        }
    }
    @Override
    public void deleteTeam(int teamId) throws SQLException {
        teamRepository.deleteById((long) teamId);
    }

    @Override
    public List<Team> getAllTeamsSortedByName() throws SQLException {
        List<Team> teams = teamRepository.findAll();
        teams.sort((a, b) -> a.getTeamName().compareToIgnoreCase(b.getTeamName()));
        return teams;
    }
}
