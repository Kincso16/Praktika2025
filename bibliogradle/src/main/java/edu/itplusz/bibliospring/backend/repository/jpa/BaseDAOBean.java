package edu.itplusz.bibliospring.backend.repository.jpa;

import edu.itplusz.bibliospring.backend.model.AbstractModel;
import edu.itplusz.bibliospring.backend.model.User;
import edu.itplusz.bibliospring.backend.repository.BaseDAO;
import edu.itplusz.bibliospring.backend.repository.RepositoryException;
import edu.itplusz.bibliospring.backend.repository.UserDAO;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.PersistenceException;
import jakarta.persistence.TypedQuery;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;
import jakarta.persistence.metamodel.EntityType;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Transactional
public class BaseDAOBean<T extends AbstractModel,I> implements BaseDAO<T,I> {
    @Autowired
    private Logger LOG;

    @PersistenceContext
    protected EntityManager entityManager;

    private Class<T> entityType;

    public BaseDAOBean(Class<T> entityType) {
        this.entityType = entityType;
    }

    @Override
    public T findByID(I id) {
        try {
            return entityManager.find(entityType, id);
        }catch(PersistenceException e){
            LOG.error("findbyid failed",e);
            throw new RepositoryException("findbyid failed",e);
        }
    }

    @Override
    public T create(T entity) {
        try {
            entityManager.persist(entity);
            entityManager.flush();
            return entity;
        }catch(PersistenceException e){
            LOG.error("create failed",e);
            throw new RepositoryException("create failed",e);
        }
    }

    @Override
    public void update(T entity) {
        try{
            entityManager.merge(entity);
        }catch(PersistenceException e){
            LOG.error("update failed",e);
            throw new RepositoryException("update failed",e);
        }
    }

    @Override
    public void delete(T entity) {
        try{
            entityManager.remove(entity);
        }catch(PersistenceException e){
            LOG.error("delete failed",e);
            throw new RepositoryException("delete failed",e);
        }
    }

    @Override
    public List<T> findAll() {
        try{
            //ez fugg a shema nevtol
            //TypedQuery<T> query = entityManager.createQuery("FROM "+ entityType.getName(),entityType);
            CriteriaBuilder cb = entityManager.getCriteriaBuilder ();
            CriteriaQuery<T> criteriaQuery = cb.createQuery (entityType);
            Root<T> rootEntry = criteriaQuery.from (entityType);
            CriteriaQuery<T> all = criteriaQuery.select (rootEntry);
            TypedQuery<T> allQuery = entityManager.createQuery (all);

            return allQuery.getResultList ();
        }catch(PersistenceException e){
            LOG.error("findall failed",e);
            throw new RepositoryException("findall failed",e);
        }
    }
}
