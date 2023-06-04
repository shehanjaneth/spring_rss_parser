package com.gifted.rss_parser.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;


@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "RSS_FEED_RATE")
public class RssFeedRate implements Serializable {

    private static final long serialVersionUID = -7095336156530713535L;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "RSS_FEED_RATE")
    @SequenceGenerator(sequenceName = "RSS_FEED_RATE_SEQ", allocationSize = 1, name = "RSS_FEED_RATE")
    @Column(name = "RSS_FEED_RATE_ID", nullable = false)
    private Integer rssFeedRateId;
    @Column(name = "USER_NAME", unique = true)
    private String userName;

    @JoinColumn(name = "RSS_FEED_ID", referencedColumnName = "RSS_FEED_ID")
    @ManyToOne(fetch = FetchType.LAZY)
    private RssFeed rssFeed;
}
