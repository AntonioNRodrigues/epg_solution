package com.epg.solution.controller;

import com.epg.solution.models.dto.ChannelDto;
import com.epg.solution.services.ChannelService;
import org.springframework.web.bind.annotation.*;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
public class ChannelController {

    private final ChannelService channelService;

    public ChannelController(ChannelService channelService) {
        this.channelService = channelService;
    }

    @PostMapping(path = "/channels/create", consumes = APPLICATION_JSON_VALUE, produces = APPLICATION_JSON_VALUE)
    public ChannelDto createChannel(@RequestBody ChannelDto channelDto) {
        return channelService.createChannel(channelDto);
    }



}
