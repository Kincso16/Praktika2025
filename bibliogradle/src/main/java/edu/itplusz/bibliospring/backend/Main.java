package edu.itplusz.bibliospring.backend;

import edu.itplusz.bibliospring.backend.model.User;
import edu.itplusz.bibliospring.backend.repository.UserDAO;
import edu.itplusz.bibliospring.backend.service.LoginService;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Main {

    @Autowired
    private LoginService loginService;
    @Autowired     // :(( don t forget ab this
    private UserDAO userDAO;

    public static void main(String[] args) {

        SpringApplication.run(Main.class,args);
    }

    @PostConstruct
    public void postConstruct(){
        User testUser = new User();
        testUser.setUsername("Lajoska");
        testUser.setPassword("cica");
        System.out.println(userDAO.findByID(1L));
        System.out.println(userDAO.findAll());
        System.out.println(userDAO.findByUsername("Lajoska"));
        /*
            loginService.register(testUser);
            testUser.setPassword("cica12334");

        System.out.println(loginService.login(testUser));
        System.out.println(testUser);*/
    }
}