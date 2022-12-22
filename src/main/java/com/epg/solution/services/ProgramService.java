package com.epg.solution.services;

import com.epg.solution.converter.ProgramConverter;
import com.epg.solution.models.dto.ProgramDto;
import com.epg.solution.models.entities.Program;
import com.epg.solution.repository.ProgramRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Optional;
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
        Optional<Program> program = programRepository.findById(id);
        return program.map(programConverter::entityToDto).orElse(null);
    }

    public Boolean deleteProgram(Long id) {
        Optional<Program> program = programRepository.findById(id);
        program.ifPresent(programRepository::delete);
        return program.isPresent();
    }

    public ProgramDto updateProgram(Long id, ProgramDto programDto) {
        Optional<Program> program = programRepository.findById(id);
        if (program.isPresent()){
            Program p = program.get();
            p.setDescription(programDto.getDescription());
            p.setEndTime(programDto.getEndTime());
            p.setImagemUrl(programDto.getImagemUrl());
            p.setTittle(programDto.getTittle());
            p.setStartTime(programDto.getStartTime());
            p.setChannel(program.get().getChannel());
            programRepository.save(p);
            return programConverter.entityToDto(p);
        }else{
            return null;
        }
    }
}
