package com.finpulse.controller;

import com.finpulse.model.SocialPost;
import com.finpulse.service.SocialPostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/posts")
public class SocialPostController {

    @Autowired
    private SocialPostService socialPostService;

    @GetMapping("/{sector}")
    public List<SocialPost> getPostsBySector(@PathVariable String sector) {
        return socialPostService.getPostsBySector(sector);
    }

    @PostMapping
    public SocialPost addPost(@RequestBody SocialPost post) {
        return socialPostService.savePost(post);
    }
}
