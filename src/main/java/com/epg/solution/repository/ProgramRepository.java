package com.epg.solution.repository;

import com.epg.solution.models.entities.Program;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Collection;

public interface ProgramRepository extends JpaRepository<Program, Long> {

    Collection<Program> getAllByChannel(Long channelId);
}