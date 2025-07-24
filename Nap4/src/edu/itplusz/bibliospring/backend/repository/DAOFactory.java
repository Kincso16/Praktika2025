package edu.itplusz.bibliospring.backend.repository;

import edu.itplusz.bibliospring.backend.repository.jdbc.JdbcDAOFactory;
import edu.itplusz.bibliospring.backend.repository.memory.MemoryDAOFactory;

public abstract class DAOFactory {
    public abstract UserDAO getUserDAO();
    public static DAOFactory getInstance() {
        //return new MemoryDAOFactory();
        return new JdbcDAOFactory();
    }
}
