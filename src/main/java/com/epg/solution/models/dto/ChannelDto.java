package com.epg.solution.models.dto;

public class ChannelDto {

    private final Long id;
    private final String name;
    private final String category;
    private final Integer position;

    public ChannelDto(Long id, String name, String category, Integer position) {
        this.id = id;
        this.name = name;
        this.category = category;
        this.position = position;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getCategory() {
        return category;
    }

    public Integer getPosition() {
        return position;
    }

}
