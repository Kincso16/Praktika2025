package edu.itplusz.bibliospring.backend.repository.memory;

import edu.itplusz.bibliospring.backend.repository.DAOFactory;
import edu.itplusz.bibliospring.backend.repository.UserDAO;

public class MemoryDAOFactory extends DAOFactory {
    @Override
    public UserDAO getUserDAO() {
        return new MemoryUserDAO();
    }
}
