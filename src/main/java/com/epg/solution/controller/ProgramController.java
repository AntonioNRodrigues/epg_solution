package com.epg.solution.controller;

import com.epg.solution.models.dto.ProgramDto;
import com.epg.solution.services.ProgramService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
@RequestMapping("programs")
public class ProgramController {

    private static final Logger logger = LoggerFactory.getLogger(ProgramController.class);
    private final ProgramService programService;

    public ProgramController(ProgramService programService) {
        this.programService = programService;
    }

    @PostMapping(path = "/create", consumes = APPLICATION_JSON_VALUE, produces = APPLICATION_JSON_VALUE)
    public ResponseEntity<ProgramDto> createProgram(@RequestBody ProgramDto dto) {
        try {
            ProgramDto programDto = programService.createProgram(dto);
            if (programDto != null) {
                return new ResponseEntity<>(programDto, HttpStatus.CREATED);
            } else {
                return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
            }

        } catch (Exception e) {
            logger.error("Problem creating program");
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping(path = "/channel/{id}")
    public ResponseEntity<Collection<ProgramDto>> getAllProgramByChannel(@PathVariable Long id) {
        try {
            Collection<ProgramDto> collection = programService.getAllProgramByChannel(id);
            return new ResponseEntity<>(collection, HttpStatus.OK);
        } catch (Exception ex) {
            logger.error("Problem getting program channel id");
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<ProgramDto> getProgramDetails(@PathVariable Long id) {
        try {
            ProgramDto dto = programService.getProgramDetails(id);
            if (dto != null) {
                return new ResponseEntity<>(programService.getProgramDetails(id), HttpStatus.OK);
            } else {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }

        } catch (Exception e) {
            logger.error("Problem getting program");
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Boolean> deleteProgram(@PathVariable Long id) {
        try {
            boolean action = programService.deleteProgram(id);
            return new ResponseEntity<>(action ? HttpStatus.OK : HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            logger.error("Problem deleting program");
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping(value = "/{id}", consumes = APPLICATION_JSON_VALUE, produces = APPLICATION_JSON_VALUE)
    public ResponseEntity<ProgramDto> updateProgram(@PathVariable Long id, @RequestBody ProgramDto programDto) {
        try {
            ProgramDto ret = programService.updateProgram(id, programDto);
            if (ret == null) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            } else {
                return new ResponseEntity<>(ret, HttpStatus.OK);
            }
        } catch (Exception e) {
            logger.error("Problem updating program");
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
