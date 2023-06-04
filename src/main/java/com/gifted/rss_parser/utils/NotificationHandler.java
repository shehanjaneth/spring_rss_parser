package com.gifted.rss_parser.utils;

import com.gifted.rss_parser.service.RssService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import javax.management.Notification;
import java.util.Date;

@Service
@AllArgsConstructor
@Slf4j
public class NotificationHandler {

    @Autowired
    private SimpMessagingTemplate messagingTemplate;

    private final RssService rssService;

//    @Scheduled(cron = "0 */5 * * * *")
    @Scheduled(cron = "*/10 * * * * *")
    public String sendNotification() {
        Notification notification = rssService.getNotification();
        log.info("Send notification via web sockets : {} ,{}" + notification.getSource(), new Date());
        messagingTemplate.convertAndSend("/rss/notifications", notification);
        return "Done";
    }
}
