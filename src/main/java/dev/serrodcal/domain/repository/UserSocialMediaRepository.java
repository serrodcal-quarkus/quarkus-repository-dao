package dev.serrodcal.domain.repository;

import dev.serrodcal.domain.model.User;

public interface UserSocialMediaRepository {

    User get(Long id);

    void add(User user);

    void update(User user);

    void remove(User user);

}
