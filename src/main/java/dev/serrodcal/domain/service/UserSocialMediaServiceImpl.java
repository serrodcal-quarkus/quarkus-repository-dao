package dev.serrodcal.domain.service;

import dev.serrodcal.domain.dto.TweetDTO;
import dev.serrodcal.domain.dto.UserDTO;
import dev.serrodcal.domain.dto.UserSocialMediaDTO;
import dev.serrodcal.domain.model.User;
import dev.serrodcal.domain.model.UserSocialMedia;
import dev.serrodcal.domain.repository.UserSocialMediaRepository;
import dev.serrodcal.application.service.UserSocialMediaService;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

import java.util.ArrayList;
import java.util.List;

@ApplicationScoped
public class UserSocialMediaServiceImpl implements UserSocialMediaService {

    @Inject
    UserSocialMediaRepository userSocialMediaRepository;

    @Override
    public UserSocialMediaDTO findById(Long id) {
        UserSocialMedia user = (UserSocialMedia) this.userSocialMediaRepository.get(id);
        List<TweetDTO> tweets = user.getTweets().stream()
                .map(i -> new TweetDTO(i.getEmail(), i.getTweetText(), i.getDateCreated()))
                .toList();

        return new UserSocialMediaDTO(
                user.getId(),
                user.getUsername(),
                user.getFullName(),
                user.getEmail(),
                new ArrayList<>(tweets)
        );
    }

    @Override
    public void createUser(UserDTO dto) {
        this.userSocialMediaRepository.add(new User(
                null,
                dto.username(),
                dto.fullName(),
                dto.email()
        ));
    }
}
