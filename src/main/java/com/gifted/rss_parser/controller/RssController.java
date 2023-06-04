package com.gifted.rss_parser.controller;

import com.gifted.rss_parser.dto.PaginatedResponse;
import com.gifted.rss_parser.dto.RssFeedDto;
import com.gifted.rss_parser.dto.RssFeedRateDto;
import com.gifted.rss_parser.service.RssService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@Slf4j
public class RssController {

    private final RssService rssService;

    @GetMapping("/items")
    PaginatedResponse findRssFeedsPage(@RequestParam(defaultValue = "0") Integer page, @RequestParam(defaultValue = "10") Integer size,
                                       @RequestParam(defaultValue = "publicationDate") String sort, @RequestParam(defaultValue = "DESC") String direction){
        log.info("Rest request for get rss feeds page,size,sort,direction : {},{},{},{}",page,size,sort,direction);
        return rssService.findRssFeedsPage(page, size,sort,direction);
    }

    @PostMapping("/item/save")
    RssFeedDto saveRssFeed(@RequestBody RssFeedDto rssFeed){
        return rssService.saveRssFeed(rssFeed);
    }


    @PostMapping("/vote/{rssFeedId}/{name}")
    Integer voteRssFeed(@PathVariable Integer rssFeedId, @PathVariable String name){
        log.info("Rest request for add vote  : {} {}",rssFeedId,name);
        return rssService.voteRssFeed(rssFeedId,name);
    }

    @GetMapping("/vote/{rssFeedId}")
    List<RssFeedRateDto> getVoteRssFeed(@PathVariable Integer rssFeedId){
        log.info("Rest request for get vote  : {}",rssFeedId);
        return rssService.getVoteRssFeed(rssFeedId);
    }

}
