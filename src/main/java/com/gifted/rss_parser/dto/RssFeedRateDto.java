package com.gifted.rss_parser.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class RssFeedRateDto {
    private Integer rssFeedRateId;
    private String userName;
    private RssFeedDto rssFeed;
}
