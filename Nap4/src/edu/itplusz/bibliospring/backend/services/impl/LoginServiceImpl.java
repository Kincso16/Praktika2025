package edu.itplusz.bibliospring.backend.services.impl;

import edu.itplusz.bibliospring.backend.model.User;
import edu.itplusz.bibliospring.backend.repository.DAOFactory;
import edu.itplusz.bibliospring.backend.repository.UserDAO;
import edu.itplusz.bibliospring.backend.services.LoginService;
import edu.itplusz.bibliospring.backend.utils.PasswordEncrypter;

public class LoginServiceImpl  implements LoginService {
    @Override
    public boolean login(User user) {
        UserDAO userDAO= DAOFactory.getInstance().getUserDAO();
        User dbUser =userDAO.findByUsername(user.getUsername());
        if(dbUser==null){
            return false;
        }else if(dbUser.getPassword().equals(PasswordEncrypter.hashPassword(user.getPassword(),dbUser.getUuid()))){
            return true;
        }
        return false;
    }

    @Override
    public void register(User user) {
        UserDAO userDAO= DAOFactory.getInstance().getUserDAO();
        user.setPassword(PasswordEncrypter.hashPassword(user.getPassword(),user.getUuid()));
        userDAO.create(user);
    }
}
