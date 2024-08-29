package dev.serrodcal.application.rest.model.response;

import java.util.List;

public record UserSocialMediaResponse(
    Long id,
    String username,
    String fullName,
    String email,
    List<TweetResponse> tweets
) { }
