package dev.serrodcal.shared.domain;

import java.util.Map;

public interface DAO<T> {

    void save(T entity);

    void update(T entity, Map<String, Object> params);

    T search(Long id);

    void delete(T entity);

}
