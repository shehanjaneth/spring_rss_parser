package com.gifted.rss_parser.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class RssFeedDto {
    private Integer rssFeedId;
    private LocalDate publicationDate;
    private String title;
    private String description;
    private String url;
    private byte[] image;
}
