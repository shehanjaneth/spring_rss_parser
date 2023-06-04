package com.gifted.rss_parser.mapper;

import com.gifted.rss_parser.dto.RssFeedRateDto;
import com.gifted.rss_parser.model.RssFeedRate;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper(uses = {RssFeedMapper.class})
public interface RssFeedRateMapper {

    /**
     * The constant INSTANCE.
     */
    RssFeedRateMapper INSTANCE = Mappers.getMapper(RssFeedRateMapper.class);

    @Mapping(source = "rssFeed" , target = "rssFeed")
    RssFeedRateDto toDto(RssFeedRate rssFeedRate);
}
