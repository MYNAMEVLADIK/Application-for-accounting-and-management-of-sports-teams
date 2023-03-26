package com.example.sportsteamdatamanagementappp.service.impl;

import com.example.sportsteamdatamanagementappp.exceptions.NoTeamException;
import com.example.sportsteamdatamanagementappp.exceptions.NoTeamMembersException;
import com.example.sportsteamdatamanagementappp.model.PositionOfTeam;
import com.example.sportsteamdatamanagementappp.model.SportType;
import com.example.sportsteamdatamanagementappp.model.Team;
import com.example.sportsteamdatamanagementappp.model.TeamMembers;
import com.example.sportsteamdatamanagementappp.repository.TeamMembersRepository;
import com.example.sportsteamdatamanagementappp.repository.TeamRepository;
import com.example.sportsteamdatamanagementappp.service.TeamService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class TeamServiceImpl implements TeamService {
    private final TeamRepository teamRepository;
    private final TeamMembersRepository teamMembersRepository;

    @Override
    public long addTeam(Team team) {
        Team savedTeam = teamRepository.save(team);
        teamMembersRepository.saveAll(team.getTeamMembers());
        return savedTeam.getId();
    }

    @Override
    public Team editTeam(int id, Team team) {
        team.setId(id);
        Team updatedTeam = teamRepository.save(team);
        teamMembersRepository.saveAll(team.getTeamMembers());
        return updatedTeam;
    }

    @Override
    public boolean deleteTeam(int id) {
        if (teamRepository.existsById(id)) {
            teamRepository.deleteById(id);
            return true;
        }
        return false;
    }

    @Override
    public List<Team> getAllTeam(SportType sportType, Integer dateMin, Integer dateMax) {
        List<Team> teamList = new ArrayList<>();
        teamRepository.findAll().forEach(team -> {
            if (team.getSportType().equals(sportType)
                    && (dateMin <= team.getYearsOfFoundation())
                    && (dateMax >= team.getYearsOfFoundation())) {
                teamList.add(team);
            } else {
                throw new NoTeamException("No teams!");
            }
        });
        return teamList;
    }

    @Override
    public List<TeamMembers> getAllTeamMembersTeam(PositionOfTeam positionOfTeam, int id) {
        List<TeamMembers> teamMembersList = new ArrayList<>();
        Optional<Team> teamOptional = teamRepository.findById(id);
        if (teamOptional.isPresent()) {
            Team team = teamOptional.get();
            for (TeamMembers teamMembers : team.getTeamMembers()) {
                if (teamMembers.getPositionOfTeam().equals(positionOfTeam)) {
                    teamMembersList.add(teamMembers);
                } else {
                    throw new NoTeamMembersException("No members!");
                }
            }
        }
        return teamMembersList;
    }
}
