package com.gifted.rss_parser.service;


import com.gifted.rss_parser.controller.RssController;
import com.gifted.rss_parser.dto.PaginatedResponse;
import com.gifted.rss_parser.dto.RssFeedDto;
import com.gifted.rss_parser.mapper.RssFeedMapper;
import com.gifted.rss_parser.mapper.RssFeedRateMapper;
import com.gifted.rss_parser.model.RssFeed;
import com.gifted.rss_parser.repository.RssFeedRateRepository;
import com.gifted.rss_parser.repository.RssFeedRepository;
import com.gifted.rss_parser.service.serviceimpl.RssServiceImpl;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.data.domain.*;
import static org.mockito.Mockito.any;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class RssServiceImplTest {

    @Mock
    private RssFeedRepository rssFeedRepository;
    @Mock
    private RssFeedRateRepository rssFeedRateRepository;
    @Mock
    private RssFeedMapper rssFeedMapper;
    @Mock
    private RssFeedRateMapper rssFeedRateMapper;

    @InjectMocks
    private RssServiceImpl rssService;

    @Test
    void findRssFeedsPageTest(){
        Integer page = 0;
        Integer size = 10;
        String sort = "publicationDate";
        String direction = "DESC";
        Sort sorting = direction.equalsIgnoreCase("ASC") ? Sort.by(sort).ascending() : Sort.by(sort).descending();
        Pageable pageable = PageRequest.of(page, size, sorting);
        when(rssFeedRepository.findAll(pageable)).thenReturn(new PageImpl<RssFeed>(new ArrayList<RssFeed>()));
        PaginatedResponse paginatedResponse = rssService.findRssFeedsPage(page, size, sort, direction);
        assertNotNull(paginatedResponse);
    }

    @Test
    void saveRssFeedTest(){
        RssFeed rssFeed = new RssFeed();
        when(rssFeedRepository.save(rssFeed)).thenReturn(rssFeed);
        when(rssFeedMapper.toEntity((RssFeedDto) any())).thenReturn(rssFeed);
        when(rssFeedMapper.toDto(rssFeed)).thenReturn(new RssFeedDto());
        RssFeedDto rssFeedDto = rssService.saveRssFeed(new RssFeedDto());
        assertNotNull(rssFeedDto);
    }

}
