package com.gifted.rss_parser.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PaginatedResponse<T>{
    Integer page;
    Integer itemCount;
    Long total;
    List<T> results;
}
