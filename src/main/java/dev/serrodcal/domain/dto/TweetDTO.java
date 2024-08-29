package dev.serrodcal.domain.dto;

import java.time.LocalDateTime;

public record TweetDTO(
    String email,
    String tweetText,
    LocalDateTime dateCreated
) { }
