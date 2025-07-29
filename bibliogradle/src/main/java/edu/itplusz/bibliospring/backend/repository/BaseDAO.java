package edu.itplusz.bibliospring.backend.repository;

import edu.itplusz.bibliospring.backend.model.AbstractModel;
import edu.itplusz.bibliospring.backend.model.User;

import java.util.List;

public interface BaseDAO<T extends AbstractModel,I>{
    T findByID (I id);
    T create(T entity);
    void update(T entity);
    void delete(T entity);
    List<T> findAll();
}
