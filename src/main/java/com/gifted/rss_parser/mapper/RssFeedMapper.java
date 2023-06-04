package com.gifted.rss_parser.mapper;

import com.gifted.rss_parser.dto.RssFeedDto;
import com.gifted.rss_parser.model.RssFeed;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface RssFeedMapper {

    /**
     * The constant INSTANCE.
     */
    RssFeedMapper INSTANCE = Mappers.getMapper(RssFeedMapper.class);

    RssFeedDto toDto(RssFeed rssFeed);

    RssFeed toEntity(RssFeedDto rssFeed);
}
