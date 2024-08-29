package dev.serrodcal.domain.model;

import java.time.LocalDateTime;
import java.util.Objects;

public class Tweet {

    private String email;
    private String tweetText;
    private LocalDateTime dateCreated;

    public Tweet() {}

    public Tweet(String email, String tweetText, LocalDateTime dateCreated) {
        this.email = email;
        this.tweetText = tweetText;
        this.dateCreated = dateCreated;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTweetText() {
        return tweetText;
    }

    public void setTweetText(String tweetText) {
        this.tweetText = tweetText;
    }

    public LocalDateTime getDateCreated() {
        return dateCreated;
    }

    public void setDateCreated(LocalDateTime dateCreated) {
        this.dateCreated = dateCreated;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Tweet tweet = (Tweet) o;
        return Objects.equals(email, tweet.email) && Objects.equals(tweetText, tweet.tweetText) && Objects.equals(dateCreated, tweet.dateCreated);
    }

    @Override
    public int hashCode() {
        return Objects.hash(email, tweetText, dateCreated);
    }

    @Override
    public String toString() {
        return "Tweet{" +
                "email='" + email + '\'' +
                ", tweetText='" + tweetText + '\'' +
                ", dateCreated=" + dateCreated +
                '}';
    }

}
