package edu.itplusz.bibliospring.backend.service.impl;

import edu.itplusz.bibliospring.backend.model.User;
import edu.itplusz.bibliospring.backend.repository.UserDAO;

import java.util.ArrayList;
import java.util.List;

public class TestUserDAO implements UserDAO {
    private User user;

    public TestUserDAO() {
        this.user = new User();
        user.setUsername("user12");
        user.setPassword("123");
        user.setUuid("salt");
        user.setId(1L);
    }

    @Override
    public User findByID(Long id) {
        if(user.getId().equals(id)){
            return user;
        }else{
            return null;
        }
    }

    @Override
    public User create(User user) {
        return null;
    }

    @Override
    public User findByUsername(String username) {
        if(user.getUsername().equals(username)){
            return user;
        }else{
            return null;
        }
    }

    @Override
    public void update(User user) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void delete(User user) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public List<User> findAll() {
        return List.of(new User[]{user});
    }
}
