package dev.serrodcal.domain.dto;

import java.util.List;

public record UserSocialMediaDTO(
        Long id,
        String username,
        String fullName,
        String email,
        List<TweetDTO> tweets
) {
}
