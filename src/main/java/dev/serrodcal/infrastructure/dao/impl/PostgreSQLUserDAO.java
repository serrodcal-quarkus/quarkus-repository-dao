package dev.serrodcal.infrastructure.dao.impl;

import dev.serrodcal.domain.model.User;
import dev.serrodcal.infrastructure.dao.UserDAO;
import dev.serrodcal.infrastructure.entity.UserEntity;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.enterprise.context.SessionScoped;
import jakarta.inject.Inject;
import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;

import java.util.Map;

@ApplicationScoped
public class PostgreSQLUserDAO implements UserDAO {

    @Inject
    EntityManager entityManager;

    @Override
    @Transactional
    public void save(User entity) {
        UserEntity userEntity = new UserEntity();
        userEntity.username = entity.getUsername();
        userEntity.fullName = entity.getFullName();
        userEntity.email = entity.getEmail();

        this.entityManager.persist(userEntity);
    }

    @Override
    @Transactional
    public void update(User entity, Map<String, Object> params) {

    }

    @Override
    @SessionScoped
    public User search(Long id) {
        UserEntity userEntity = this.entityManager.find(UserEntity.class, id);
        return new User(
                userEntity.id,
                userEntity.username,
                userEntity.fullName,
                userEntity.email
        );
    }

    @Override
    @Transactional
    public void delete(User entity) {

    }
}
