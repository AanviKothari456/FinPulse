package com.finpulse.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "social_posts")
public class SocialPost {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String platform;
    private String content;
    private String sector;
    private String sentiment;
    private double confidence;
    private LocalDateTime timestamp;

    public SocialPost() {}

    // Getters and setters omitted for brevity
}
