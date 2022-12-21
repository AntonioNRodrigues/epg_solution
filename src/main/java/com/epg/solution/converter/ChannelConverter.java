package com.epg.solution.converter;

import com.epg.solution.models.dto.ChannelDto;
import com.epg.solution.models.entities.Channel;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

@Component
public class ChannelConverter implements IConverter<Channel, ChannelDto> {

    @Override
    public ChannelDto entityToDto(Channel entity) {
        return new ChannelDto(entity.getId(), entity.getName(), entity.getCategory(), entity.getPosition());
    }

    @Override
    public Channel dtoToEntity(ChannelDto dto) {
        Channel channel = new Channel();
        BeanUtils.copyProperties(channel, dto);
        return channel;
    }
}
