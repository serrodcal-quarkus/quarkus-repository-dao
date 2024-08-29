package dev.serrodcal.application.rest.model.response;

import java.time.LocalDateTime;

public record TweetResponse(
        String tweetText,
        LocalDateTime createdAt
) { }
