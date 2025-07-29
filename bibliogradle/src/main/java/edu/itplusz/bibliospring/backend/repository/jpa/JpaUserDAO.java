package edu.itplusz.bibliospring.backend.repository.jpa;

import edu.itplusz.bibliospring.backend.model.User;
import edu.itplusz.bibliospring.backend.repository.RepositoryException;
import edu.itplusz.bibliospring.backend.repository.UserDAO;
import jakarta.persistence.PersistenceException;
import jakarta.persistence.TypedQuery;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Repository;

@Repository
@Profile("JPA")
public class JpaUserDAO extends BaseDAOBean<User,Long> implements UserDAO {
    @Autowired
    private Logger LOG;

    public JpaUserDAO() {
        super(User.class);
    }

    @Override
    public User findByUsername(String username) {
    try{
        TypedQuery<User> query=entityManager.createQuery("FROM User u WHERE u.userName=:username",User.class);
        query.setParameter("username",username);
        return query.getSingleResult();
    }catch(PersistenceException e){
        LOG.error("findbyusername failed",e);
        throw new RepositoryException("findbyusername failed",e);
    }
    }
}
