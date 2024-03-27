package com.br.pontoInteligente.infra.standard;

import com.br.pontoInteligente.domain.standard.Page;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public abstract class AbstractRepository {

    @PersistenceContext
    protected EntityManager entityManager;

    public <T> Optional<T> findById(Class<T> entityClass, Object id) {
        T result = entityManager.find(entityClass, id);
        return Optional.ofNullable(result);
    }

    @Transactional
    public <T> T saveEntity(T entity) {
        entityManager.persist(entity);
        return entity;
    }

    protected  <T> Page<T> findResultPageable(String sql, List<Object> parameters, int pageNumber, int pageSize, Class<T> resultClass){

        var query = entityManager.createQuery(sql, resultClass);

        for (int i = 0; i < parameters.size(); i++) {
            query.setParameter(i + 1, parameters.get(i));
        }

        List<T> result = query.setFirstResult(pageNumber)
                .setMaxResults(pageSize)
                .getResultList();

        return new Page<>(result, pageNumber, pageSize);
    }

    public <T> Page<T> findResultPageable(String sql, Object parameter, int pageNumber, int pageSize, Class<T> resultClass){

        var query = entityManager.createQuery(sql, resultClass);

        if(parameter == null){
            throw new IllegalArgumentException("Parameter cannot be null");
        }

        query.setParameter(1, parameter);

        List<T> result = query.setFirstResult(pageNumber)
                .setMaxResults(pageSize)
                .getResultList();

        return new Page<>(result, pageNumber, pageSize);
    }

    public <T> Page<T> findResultPageable(String sql, int pageNumber, int pageSize, Class<T> resultClass){

        var query = entityManager.createQuery(sql, resultClass);

        List<T> result = query.setFirstResult(pageNumber)
                .setMaxResults(pageSize)
                .getResultList();

        return new Page<>(result, pageNumber, pageSize);
    }
}
