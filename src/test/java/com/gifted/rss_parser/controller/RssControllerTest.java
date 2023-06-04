package com.gifted.rss_parser.controller;

import com.gifted.rss_parser.dto.PaginatedResponse;
import com.gifted.rss_parser.dto.RssFeedDto;
import com.gifted.rss_parser.dto.RssFeedRateDto;
import com.gifted.rss_parser.service.RssService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class RssControllerTest {

    @Mock
    private RssService rssService;
    @InjectMocks
    private RssController rssController;

    @Test
    void findRssFeedsPageTest(){
        Integer page = 0;
        Integer size = 10;
        String sort = "publicationDate";
        String direction = "DESC";
        when(rssService.findRssFeedsPage(page, size, sort, direction)).thenReturn(new PaginatedResponse());
        PaginatedResponse paginatedResponse = rssController.findRssFeedsPage(page, size, sort, direction);
        assertNotNull(paginatedResponse);
    }


    @Test
    void saveRssFeedTest(){
        RssFeedDto rssFeedDto = new RssFeedDto();
        when(rssService.saveRssFeed(rssFeedDto)).thenReturn(rssFeedDto);
        rssFeedDto= rssController.saveRssFeed(rssFeedDto);
        assertNotNull(rssFeedDto);
    }

    @Test
    void voteRssFeedTest(){
        Integer rssFeedId = 1;
        String name = "X";
        when(rssService.voteRssFeed(rssFeedId,name)).thenReturn(1);
        Integer voters = rssController.voteRssFeed(rssFeedId,name);
        assertEquals(1,voters);
    }

    @Test
    void getVoteRssFeedTest(){
        Integer rssFeedId = 1;
        List<RssFeedRateDto> voters = new ArrayList<>();
        voters.add(new RssFeedRateDto());
        when(rssService.getVoteRssFeed(rssFeedId)).thenReturn(voters);
        List<RssFeedRateDto> voteRssFeed = rssController.getVoteRssFeed(rssFeedId);
        assertEquals(voters,voteRssFeed);
    }
}
