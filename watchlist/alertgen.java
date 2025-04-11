package com.finpulse.service;

import com.finpulse.model.Alert;
import com.finpulse.model.SocialPost;
import com.finpulse.repository.AlertRepository;
import com.finpulse.repository.SocialPostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class AlertGeneratorService {

    @Autowired
    private SocialPostRepository postRepo;

    @Autowired
    private AlertRepository alertRepo;

    @Scheduled(fixedRate = 60000) // Every 60 seconds
    public void detectSpikesAndAlert() {
        // Example: generate an alert if >5 bullish posts in last 60s
        LocalDateTime cutoff = LocalDateTime.now().minusMinutes(1);
        List<SocialPost> recentPosts = postRepo.findAll();

        recentPosts.stream()
            .filter(p -> p.getTimestamp().isAfter(cutoff) && "bullish".equalsIgnoreCase(p.getSentiment()))
            .map(SocialPost::getSector)
            .distinct()
            .forEach(sector -> {
                long count = recentPosts.stream()
                    .filter(p -> sector.equalsIgnoreCase(p.getSector()) && "bullish".equalsIgnoreCase(p.getSentiment()))
                    .count();
                if (count > 5) {
                    alertRepo.save(new Alert(
                        sector,
                        "High bullish sentiment detected in the past minute.",
                        LocalDateTime.now()
                    ));
                }
            });
    }
}
