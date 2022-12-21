package com.epg.solution.services;

import com.epg.solution.converter.ProgramConverter;
import com.epg.solution.models.dto.ProgramDto;
import com.epg.solution.repository.ProgramRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.stream.Collectors;

@Service
public class ProgramService {


    private final ProgramRepository programRepository;
    private final ProgramConverter programConverter;

    @Autowired
    public ProgramService(ProgramRepository programRepo, ProgramConverter programConverter) {
        this.programConverter = programConverter;
        this.programRepository = programRepo;
    }

    public ProgramDto createProgram(ProgramDto dto) {
       return programConverter.entityToDto(programRepository.save(programConverter.dtoToEntity(dto)));
    }

    public Collection<ProgramDto> getAllProgramByChannel(Long channelId) {
        return programRepository.getAllByChannel(channelId).stream().map(programConverter::entityToDto).collect(Collectors.toList());

    }

    public ProgramDto getProgramDetails(Long id) {
        //return programConverter.entityToDto(programRepository.findById(id).s)
        return null;
    }

    public Boolean deleteProgram(Long id) {
        return null;
    }

    public ProgramDto updateProgram(Long id) {
        return null;
    }
}
