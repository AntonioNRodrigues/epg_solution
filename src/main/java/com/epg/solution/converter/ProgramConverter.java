package com.epg.solution.converter;

import com.epg.solution.models.dto.ProgramDto;
import com.epg.solution.models.entities.Program;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

@Component
public class ProgramConverter implements IConverter<Program, ProgramDto> {
    @Override
    public ProgramDto entityToDto(Program entity) {
        return new ProgramDto(entity.getId(), entity.getImagemUrl(), entity.getChannel(), entity.getTittle(),
                entity.getDescription(), entity.getStartTime(), entity.getEndTime());
    }

    @Override
    public Program dtoToEntity(ProgramDto dto) {
        Program program = new Program();
        BeanUtils.copyProperties(dto, program);
        return program;
    }
}
