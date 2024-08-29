package dev.serrodcal.shared.domain.exception;

public class DuplicatedTweetException extends RuntimeException {

    public DuplicatedTweetException() {
        super();
    }

    public DuplicatedTweetException(String message) {
        super(message);
    }

}
