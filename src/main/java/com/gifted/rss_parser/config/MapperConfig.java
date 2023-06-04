package com.gifted.rss_parser.config;

import com.gifted.rss_parser.mapper.RssFeedMapper;
import com.gifted.rss_parser.mapper.RssFeedRateMapper;
import org.mapstruct.factory.Mappers;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MapperConfig {

    @Bean
    public RssFeedRateMapper rssFeedRateMapper() {
        return Mappers.getMapper(RssFeedRateMapper.class);
    }

    @Bean
    public RssFeedMapper rssFeedMapper() {
        return Mappers.getMapper(RssFeedMapper.class);
    }
}
