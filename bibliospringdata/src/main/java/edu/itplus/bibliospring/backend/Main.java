package edu.itplus.bibliospring.backend;

import edu.itplus.bibliospring.backend.model.User;
import edu.itplus.bibliospring.backend.repository.UserRepository;
import edu.itplus.bibliospring.backend.services.LoginService;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Main {
    @Autowired

    private LoginService loginService;
    @Autowired
    private UserRepository userRepository;


    public static void main(String[] args) {
        SpringApplication.run(Main.class,args);
    }
    @PostConstruct
    public void postConstruct() {
        User testUser = new User();
        testUser.setUsername("Nomi");
        testUser.setPassword("Nomi");

        loginService.register(testUser);
        testUser.setPassword("Nomi");


        System.out.println(loginService.login(testUser));

        System.out.println(userRepository.findAll());;
        //System.out.println(userRepository.findByUsername("Nomi"));
        System.out.println(userRepository.getUserByUsername("Nomi"));
        //System.out.println(userRepository.findByUsername("1L"));


    }
}