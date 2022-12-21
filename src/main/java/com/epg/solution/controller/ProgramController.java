package com.epg.solution.controller;

import com.epg.solution.services.ProgramService;
import com.epg.solution.models.dto.ProgramDto;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
public class ProgramController {

    private final ProgramService programService;

    public ProgramController(ProgramService programService) {
        this.programService = programService;
    }

    @PostMapping(path = "/programs/create", consumes = APPLICATION_JSON_VALUE, produces = APPLICATION_JSON_VALUE)
    public ProgramDto createProgram(@RequestBody ProgramDto dto) {
        return programService.createProgram(dto);
    }

    @GetMapping(path = "/programs/{channelId}")
    public Collection<ProgramDto> getAllProgramByChannel(@PathVariable Long channelId) {
        return programService.getAllProgramByChannel(channelId);
    }

    @GetMapping(path = "/programs/{id}")
    public ProgramDto getProgramDetails(@PathVariable Long id) {
        return programService.getProgramDetails(id);
    }

    @DeleteMapping("/programs/{id}")
    public Boolean deleteProgram(@PathVariable Long id) {
        return programService.deleteProgram(id);
    }

    @PutMapping(value = "programs/{id}", consumes = APPLICATION_JSON_VALUE, produces = APPLICATION_JSON_VALUE)
    public ProgramDto updateProgram(@PathVariable Long id) {
        return programService.updateProgram(id);
    }


}
