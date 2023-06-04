package com.gifted.rss_parser.repository;

import com.gifted.rss_parser.model.RssFeed;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RssFeedRepository extends JpaRepository<RssFeed, Integer> {
}
