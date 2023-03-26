package com.example.sportsteamdatamanagementappp.repository;

import com.example.sportsteamdatamanagementappp.model.TeamMembers;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TeamMembersRepository extends JpaRepository<TeamMembers, Integer> {
}