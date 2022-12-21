package com.epg.solution.converter;

public interface IConverter<E, D> {

    D entityToDto(E entity);

    E dtoToEntity(D dto);

}
