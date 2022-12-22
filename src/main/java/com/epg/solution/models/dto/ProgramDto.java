package com.epg.solution.models.dto;

import java.time.Instant;


public class ProgramDto {

    private final Long id;
    private final String imagemUrl;
    private final Long channelId;
    private final String tittle;
    private final String description;
    private final Instant startTime;
    private final Instant endTime;


    public ProgramDto(Long id, String imagemUrl, Long channelId, String tittle, String description, Instant startTime, Instant endTime) {
        this.id = id;
        this.imagemUrl = imagemUrl;
        this.channelId = channelId;
        this.tittle = tittle;
        this.description = description;
        this.startTime = startTime;
        this.endTime = endTime;
    }

    public String getImagemUrl() {
        return imagemUrl;
    }

    public Long getChannelId() {
        return channelId;
    }

    public String getTittle() {
        return tittle;
    }

    public String getDescription() {
        return description;
    }

    public Instant getStartTime() {
        return startTime;
    }

    public Instant getEndTime() {
        return endTime;
    }

    public Long getId() {
        return id;
    }
}