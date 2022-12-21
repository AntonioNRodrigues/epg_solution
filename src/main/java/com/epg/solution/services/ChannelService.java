package com.epg.solution.services;

import com.epg.solution.converter.ChannelConverter;
import com.epg.solution.models.dto.ChannelDto;
import com.epg.solution.repository.ChannelRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.stream.Collectors;

@Service
public class ChannelService {

    private static final Logger logger = LoggerFactory.getLogger(ChannelService.class);
    private final ChannelRepository channelRepository;
    private final ChannelConverter channelConverter;


    @Autowired
    public ChannelService(ChannelRepository channelRepository, ChannelConverter channelConverter) {
        this.channelRepository = channelRepository;
        this.channelConverter = channelConverter;
    }


    public ChannelDto createChannel(ChannelDto channelDto) {
        return channelConverter.entityToDto(channelRepository.save(channelConverter.dtoToEntity(channelDto)));
    }

    public Collection<ChannelDto> getAllChannels() {
        return channelRepository.findAll().stream().map(channelConverter::entityToDto).collect(Collectors.toList());
    }
}
