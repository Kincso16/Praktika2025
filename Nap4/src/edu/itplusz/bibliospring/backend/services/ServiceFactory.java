package edu.itplusz.bibliospring.backend.services;

import edu.itplusz.bibliospring.backend.services.impl.LoginServiceImpl;

public class ServiceFactory {
    public static LoginService getInstance(){
        return new LoginServiceImpl();
    }
}
