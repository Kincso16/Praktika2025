package edu.itplusz.bibliospring.backend.service.impl;

import edu.itplusz.bibliospring.backend.model.User;
import edu.itplusz.bibliospring.backend.repository.UserDAO;

import java.util.List;

public class TestUserDAO implements UserDAO {
    @Override
    public User findByID(Long id) {
        return null;
    }

    @Override
    public User create(User user) {
        return null;
    }

    @Override
    public User findByUsername(String username) {
        return null;
    }

    @Override
    public void update(User user) {

    }

    @Override
    public void delete(User user) {

    }

    @Override
    public List<User> findAll() {
        return List.of();
    }
}
