package dev.serrodcal.infrastructure.dao.impl;

import dev.serrodcal.domain.model.Tweet;
import dev.serrodcal.infrastructure.dao.TweetDAO;
import jakarta.enterprise.context.ApplicationScoped;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@ApplicationScoped
public class InMemoryTweetDAO implements TweetDAO {

    @Override
    public List<Tweet> fetchTweets(String email) {
        List<Tweet> tweets = new ArrayList<Tweet>();

        //call Twitter API and prepare Tweet object
        tweets.add(new Tweet("user1@email.com", "Some tweet by user 1, first try", LocalDateTime.now()));
        tweets.add(new Tweet("user1@email.com", "Some tweet by user 1, second try", LocalDateTime.now()));
        tweets.add(new Tweet("user1@email.com", "Some tweet by user 1, third try", LocalDateTime.now()));
        tweets.add(new Tweet("user2@email.com", "Some tweet by user 2, first try", LocalDateTime.now()));
        tweets.add(new Tweet("user2@email.com", "Some tweet by user 2, second try", LocalDateTime.now()));
        tweets.add(new Tweet("user3@email.com", "Some tweet by user 3, first try", LocalDateTime.now()));

        return tweets;
    }

    @Override
    public void save(Tweet entity) {
        // Unsupported yet
    }

    @Override
    public void update(Tweet entity, Map<String, Object> params) {
        // Unsupported yet
    }

    @Override
    public Tweet search(Long id) {
        // Unsupported yet
        return null;
    }

    @Override
    public void delete(Tweet entity) {
        // Unsupported yet
    }
}
