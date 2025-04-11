package com.finpulse.service;

import com.finpulse.model.SocialPost;
import com.finpulse.repository.SocialPostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SocialPostService {

    @Autowired
    private SocialPostRepository socialPostRepository;

    public List<SocialPost> getPostsBySector(String sector) {
        return socialPostRepository.findBySectorIgnoreCase(sector);
    }

    public SocialPost savePost(SocialPost post) {
        return socialPostRepository.save(post);
    }
}