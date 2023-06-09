package com.example.sportsteamdatamanagementappp.service;

import com.example.sportsteamdatamanagementappp.model.TeamMembers;

import java.util.Collection;

public interface TeamMembersService {
    long addTeamMembers(TeamMembers teamMembers, int idTeam);

    String transferParticipant(int idTeam, int idMembers, int idTeam2, TeamMembers teamMembers);

    TeamMembers editTeamMembers(int idTeam, int id, TeamMembers teamMembers);

    boolean deleteTeamMembers(int id, int idTeam);

    Collection<TeamMembers> getTeamMembers();
}
