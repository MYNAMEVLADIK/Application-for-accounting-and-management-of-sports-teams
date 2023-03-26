package com.example.sportsteamdatamanagementappp.service;

import com.example.sportsteamdatamanagementappp.model.PositionOfTeam;
import com.example.sportsteamdatamanagementappp.model.SportType;
import com.example.sportsteamdatamanagementappp.model.Team;
import com.example.sportsteamdatamanagementappp.model.TeamMembers;

import java.util.List;

public interface TeamService {

    long addTeam(Team team);

    Team editTeam(int id, Team team);

    boolean deleteTeam(int id);

    List<Team> getAllTeam(SportType sportType, Integer dataMin, Integer dataMax);


    List<TeamMembers> getAllTeamMembersTeam(PositionOfTeam positionOfTeam, int id);
}
