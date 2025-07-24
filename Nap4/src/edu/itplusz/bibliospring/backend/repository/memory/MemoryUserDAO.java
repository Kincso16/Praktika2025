package edu.itplusz.bibliospring.backend.repository.memory;

import edu.itplusz.bibliospring.backend.model.User;
import edu.itplusz.bibliospring.backend.repository.UserDAO;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;

public class MemoryUserDAO implements UserDAO {
    private ConcurrentHashMap<Long,User> users;
    private AtomicLong idGenetartor;

    public MemoryUserDAO() {
        users = new ConcurrentHashMap<>();
        idGenetartor = new AtomicLong();
    }

    @Override
    public User findById(Long id) {
        return users.get(id);
    }

    @Override
    public User create(User user) {
        user.setId(idGenetartor.incrementAndGet());
        user.getUuid();
        users.put(user.getId(), user);
        return user;
    }

    @Override
    public void update(User user) {
        users.put(user.getId(), user);
    }

    @Override
    public void delete(User user) {
        users.remove(user.getId());
    }

    @Override
    public List<User> findAll() {
        return new ArrayList<User>(users.values());
    }

    @Override
    public User findByUsername(String username) {
        return users.values().stream().filter(user -> user.getUsername().equals(username)).findAny().orElse(null);
    }
}
