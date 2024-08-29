package dev.serrodcal.domain.model;

import dev.serrodcal.shared.domain.exception.DuplicatedTweetException;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

public class UserSocialMedia extends User {

    private List<Tweet> tweets;

    public UserSocialMedia() {
        super();
    }

    public UserSocialMedia(Long id, String username, String fullName, String email, List<Tweet> tweets) {
        super(id, username, fullName, email);
        this.tweets = new ArrayList<>(tweets);
    }

    public void add(Tweet tweet) {
        if (this.tweets.contains(tweet))
            throw new DuplicatedTweetException("This tweet is duplicated");
        this.tweets.add(tweet);
    }

    public boolean remove(Tweet tweet) {
        if (this.tweets.contains(tweet))
            throw new NoSuchElementException("This tweet is not in the list");

        return this.tweets.remove(tweet);
    }

    public List<Tweet> getTweets() {
        return tweets;
    }

    public void setTweets(List<Tweet> tweets) {
        this.tweets = new ArrayList<>(tweets);
    }

}
