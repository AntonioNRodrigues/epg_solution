package com.epg.solution.controller;

import com.epg.solution.models.dto.ChannelDto;
import com.epg.solution.services.ChannelService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
@RequestMapping("channels")
public class ChannelController {

    private static final Logger logger = LoggerFactory.getLogger(ChannelController.class);
    private final ChannelService channelService;

    public ChannelController(ChannelService channelService) {
        this.channelService = channelService;
    }

    @PostMapping(path = "/create", consumes = APPLICATION_JSON_VALUE, produces = APPLICATION_JSON_VALUE)
    public ResponseEntity<ChannelDto> createChannel(@RequestBody ChannelDto channelDto) {
        try {
            return new ResponseEntity<>(channelService.createChannel(channelDto), HttpStatus.CREATED);
        } catch (Exception e) {
            logger.error("Problem creating channel");
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping
    public ResponseEntity<Collection<ChannelDto>> getAllChannels() {
        try {
            return new ResponseEntity<>(channelService.getAllChannels(), HttpStatus.OK);
        } catch (Exception e) {
            logger.error("Problem getting all channels");
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


}
