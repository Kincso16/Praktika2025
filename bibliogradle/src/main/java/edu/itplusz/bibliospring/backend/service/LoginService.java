package edu.itplusz.bibliospring.backend.service;

import edu.itplusz.bibliospring.backend.model.User;

public interface LoginService {
    boolean login(User user);
    void register(User user);
}
