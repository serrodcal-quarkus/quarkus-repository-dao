package dev.serrodcal.infrastructure.dao;

import dev.serrodcal.domain.model.Tweet;
import dev.serrodcal.shared.domain.DAO;

import java.util.List;

public interface TweetDAO extends DAO<Tweet> {

    List<Tweet> fetchTweets(String email);

}
