package com.gifted.rss_parser.service;

import com.gifted.rss_parser.dto.PaginatedResponse;
import com.gifted.rss_parser.dto.RssFeedDto;
import com.gifted.rss_parser.dto.RssFeedRateDto;
import com.gifted.rss_parser.model.RssFeed;

import javax.management.Notification;
import java.util.List;

public interface RssService {

    PaginatedResponse findRssFeedsPage(Integer page, Integer size, String sort, String direction);
    RssFeedDto saveRssFeed(RssFeedDto rssFeed);
    Notification getNotification();
    Integer voteRssFeed(Integer rssFeedId,String name);
    List<RssFeedRateDto> getVoteRssFeed(Integer rssFeedId);
}
