package dev.serrodcal.infrastructure.repository;

import dev.serrodcal.domain.model.Tweet;
import dev.serrodcal.domain.model.User;
import dev.serrodcal.domain.model.UserSocialMedia;
import dev.serrodcal.domain.repository.UserSocialMediaRepository;
import dev.serrodcal.infrastructure.dao.TweetDAO;
import dev.serrodcal.infrastructure.dao.UserDAO;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

import java.util.List;

@ApplicationScoped
public class UserSocialMediaRepositoryImpl implements UserSocialMediaRepository {

    @Inject
    UserDAO userDAO;

    @Inject
    TweetDAO tweetDAO;

    @Override
    public UserSocialMedia get(Long id) {
        User user = this.userDAO.search(id);

        List<Tweet> tweets = this.tweetDAO.fetchTweets(user.getEmail());

        UserSocialMedia userSocialMedia = new UserSocialMedia(
                user.getId(),
                user.getUsername(),
                user.getFullName(),
                user.getEmail(),
                tweets
        );

        return userSocialMedia;
    }

    @Override
    public void add(User user) {
        this.userDAO.save(user);
    }

    @Override
    public void update(User user) {

    }

    @Override
    public void remove(User user) {

    }
}
