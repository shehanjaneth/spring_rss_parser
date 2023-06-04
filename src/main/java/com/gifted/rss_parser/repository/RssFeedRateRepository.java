package com.gifted.rss_parser.repository;

import com.gifted.rss_parser.model.RssFeedRate;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RssFeedRateRepository extends JpaRepository<RssFeedRate, Integer> {
}
