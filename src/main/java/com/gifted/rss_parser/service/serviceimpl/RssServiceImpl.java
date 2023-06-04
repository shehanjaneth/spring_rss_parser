package com.gifted.rss_parser.service.serviceimpl;

import com.gifted.rss_parser.dto.PaginatedResponse;
import com.gifted.rss_parser.dto.RssFeedDto;
import com.gifted.rss_parser.dto.RssFeedRateDto;
import com.gifted.rss_parser.mapper.RssFeedMapper;
import com.gifted.rss_parser.mapper.RssFeedRateMapper;
import com.gifted.rss_parser.model.RssFeed;
import com.gifted.rss_parser.model.RssFeedRate;
import com.gifted.rss_parser.repository.RssFeedRateRepository;
import com.gifted.rss_parser.repository.RssFeedRepository;
import com.gifted.rss_parser.service.RssService;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import javax.management.Notification;
import java.util.List;
import java.util.Optional;
import java.util.Random;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class RssServiceImpl implements RssService {

    private final RssFeedRepository rssFeedRepository;
    private final RssFeedRateRepository rssFeedRateRepository;
    private final RssFeedMapper rssFeedMapper;
    private final RssFeedRateMapper rssFeedRateMapper;

    @Override
    public PaginatedResponse findRssFeedsPage(Integer page, Integer size, String sort, String direction) {
        Sort sorting = direction.equalsIgnoreCase("ASC") ? Sort.by(sort).ascending() : Sort.by(sort).descending();
        Pageable pageable = PageRequest.of(page, size, sorting);
        Page<RssFeed> rssFeedPage = rssFeedRepository.findAll(pageable);
        List<RssFeedDto> results =  rssFeedPage.getContent().stream().map(rssFeedMapper::toDto).collect(Collectors.toList());
        return new PaginatedResponse(page, rssFeedPage.getNumberOfElements(), rssFeedPage.getTotalElements(), results);
    }

    @Override
    public RssFeedDto saveRssFeed(RssFeedDto rssFeed) {
        return rssFeedMapper.toDto(rssFeedRepository.save(rssFeedMapper.toEntity(rssFeed)));
    }

    @Override
    public Notification getNotification() {
        List<RssFeed> rssFeeds = rssFeedRepository.findAll();
        if (rssFeeds.isEmpty()){
            return new Notification("CREATE","Null",1);
        }
        Random random = new Random();
        Integer randomNumber = random.nextInt(rssFeeds.size());
        RssFeed rssFeed = rssFeeds.get(randomNumber);
        return new Notification("POLL",rssFeed,2);
    }

    @Override
    public Integer voteRssFeed(Integer rssFeedId, String name) {
        Optional<RssFeed> rssFeedOptional = rssFeedRepository.findById(rssFeedId);
        if(rssFeedOptional.isPresent()){
            RssFeed rssFeed = rssFeedOptional.get();
            RssFeedRate rssFeedRate = new RssFeedRate();
            rssFeedRate.setUserName(name);
            rssFeedRate.setRssFeed(rssFeed);
            rssFeedRateRepository.save(rssFeedRate);
            return rssFeedOptional.get().getRssFeedRateList().size()+1;
        }
        return 0;
    }

    @Override
    public List<RssFeedRateDto> getVoteRssFeed(Integer rssFeedId) {
        Optional<RssFeed> rssFeedOptional =  rssFeedRepository.findById(rssFeedId);
        if(!rssFeedOptional.isPresent()) {
            throw new RuntimeException("Data Not Found");
        }
        return rssFeedOptional.get().getRssFeedRateList().stream().map(rssFeedRateMapper::toDto).collect(Collectors.toList());
    }
}
