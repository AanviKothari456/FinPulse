package com.finpulse.service;

import org.springframework.stereotype.Service;

@Service
public class SentimentAnalysisService {

    // Placeholder for real LLM/Python-based integration
    public String analyzeSentiment(String text) {
        // Fake sentiment for now
        if (text.toLowerCase().contains("buy") || text.toLowerCase().contains("bullish")) {
            return "bullish";
        } else if (text.toLowerCase().contains("sell") || text.toLowerCase().contains("bearish")) {
            return "bearish";
        } else {
            return "neutral";
        }
    }

    public double getConfidence(String sentiment) {
        return switch (sentiment) {
            case "bullish" -> 0.9;
            case "bearish" -> 0.85;
            default -> 0.6;
        };
    }
}