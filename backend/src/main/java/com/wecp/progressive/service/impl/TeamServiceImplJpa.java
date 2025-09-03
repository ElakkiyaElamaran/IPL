package com.wecp.progressive.service.impl;

import java.sql.SQLException;
import java.util.Comparator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wecp.progressive.entity.Team;
import com.wecp.progressive.repository.TeamRepository;
import com.wecp.progressive.service.TeamService;

@Service
public class TeamServiceImplJpa implements TeamService {

    
    private TeamRepository teamRepository;

    @Autowired
    public TeamServiceImplJpa(TeamRepository teamRepository) {
        this.teamRepository = teamRepository;
    }

    @Override
    public List<Team> getAllTeams() throws SQLException {
        return teamRepository.findAll();
    }

    @Override
    public int addTeam(Team team) throws SQLException {
        // Team savedTeam = teamRepository.save(team);
        // return savedTeam.getTeamId();
        // teamRepository.save(team);
        // Team tg=teamRepository.findById(team.getTeamId()).orElse(null);
        return teamRepository.save(team).getTeamId();
    }

    @Override
    public List<Team> getAllTeamsSortedByName() throws SQLException {
        List<Team> sortedTeam = teamRepository.findAll();
        sortedTeam.sort(Comparator.comparing(Team::getTeamName));
        // teams.sort((a,b) -> a.getTeamName().compareToIgnoreCase(b.getTeamName()));
        return sortedTeam;
    }

    @Override
    public Team getTeamById(int teamId) throws SQLException
    {
        return teamRepository.findByTeamId(teamId);
    }

    @Override
    public void updateTeam(Team team) throws SQLException{
        if(teamRepository.existsById(team.getTeamId()))
        teamRepository.save(team);
    }

    @Override
    public void deleteTeam(int teamId) throws SQLException
    {
        teamRepository.deleteById(teamId);
    }
}
