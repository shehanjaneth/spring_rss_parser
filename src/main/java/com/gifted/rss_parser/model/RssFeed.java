package com.gifted.rss_parser.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;


@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "RSS_FEED")
public class RssFeed implements Serializable {

    private static final long serialVersionUID = 3181036866983279675L;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "RSS_FEED")
    @SequenceGenerator(sequenceName = "RSS_FEED_SEQ", allocationSize = 1, name = "RSS_FEED")
    @Column(name = "RSS_FEED_ID", nullable = false)
    private Integer rssFeedId;
    @Column(name = "PUBLICATION_DATE", nullable = false)
    private LocalDate publicationDate;
    @Column(name = "TITLE", nullable = false)
    private String title;
    @Column(name = "DESCRIPTION", nullable = false)
    private String description;
    @Column(name = "URL")
    private String url;
    @Column(name = "Image")
    private byte[] image;

    @OneToMany(mappedBy = "rssFeed", fetch = FetchType.EAGER)
    List<RssFeedRate> rssFeedRateList;
}
