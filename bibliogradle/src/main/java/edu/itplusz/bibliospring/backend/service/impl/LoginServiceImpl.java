package edu.itplusz.bibliospring.backend.service.impl;

import edu.itplusz.bibliospring.backend.model.User;
import edu.itplusz.bibliospring.backend.repository.UserDAO;
import edu.itplusz.bibliospring.backend.service.LoginService;
import edu.itplusz.bibliospring.backend.utils.impl.PasswordEncrypterImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LoginServiceImpl implements LoginService {
    @Autowired
    private UserDAO userDAO;

    @Autowired
    private PasswordEncrypterImpl passwordEncrypter;

    @Override
    public boolean login(User user) {

        User dbUser = userDAO.findByUsername(user.getUsername());
        if (dbUser == null){
            return false;
        }

        else if (dbUser.getPassword().equals(passwordEncrypter.hashPassword(user.getPassword(),dbUser.getUuid()))){
            return true;
        }


        return false;
    }

    @Override
    public void register(User user) {

        user.setPassword(passwordEncrypter.hashPassword(user.getPassword(),user.getUuid()));
        userDAO.create(user);
    }
}
