package edu.itplusz.bibliospring.backend.repository.jdbc;

import edu.itplusz.bibliospring.backend.repository.DAOFactory;
import edu.itplusz.bibliospring.backend.repository.UserDAO;

public class JdbcDAOFactory extends DAOFactory {
    @Override
    public UserDAO getUserDAO() {
        return new JdbcUserDAO();
    }
}
