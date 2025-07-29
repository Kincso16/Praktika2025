package edu.itplus.bibliospring.backend.services.impl;

import edu.itplus.bibliospring.backend.model.User;
import edu.itplus.bibliospring.backend.repository.UserRepository;
import edu.itplus.bibliospring.backend.services.LoginService;
import edu.itplus.bibliospring.backend.utils.PasswordEncrypter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LoginServiceImpl implements LoginService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncrypter passwordEncrypter;

    @Override
    public boolean login(User user) {
        User dbUser = userRepository.findByUsername(user.getUsername());
        if (dbUser == null) {
            return false;
        } else {
            return dbUser.getPassword().equals(
                    passwordEncrypter.hashPassword(user.getPassword(), dbUser.getUuid())
            );
        }
    }

    @Override
    public void register(User user) {
        user.setPassword(passwordEncrypter.hashPassword(user.getPassword(), user.getUuid()));
        userRepository.save(user);
    }
}
