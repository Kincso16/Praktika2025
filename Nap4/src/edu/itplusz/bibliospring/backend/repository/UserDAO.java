package edu.itplusz.bibliospring.backend.repository;

import edu.itplusz.bibliospring.backend.model.User;

import java.util.List;

public interface UserDAO {
    User findById(Long id);
    User create(User user);
    void update(User user);
    void delete(User user);
    List<User> findAll();
    User findByUsername(String username);
}
