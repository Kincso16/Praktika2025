package edu.itplusz.bibliospring.backend.service.impl;

import edu.itplusz.bibliospring.backend.utils.PasswordEncrypter;

public class TestPasswordEncrypter implements PasswordEncrypter {
    public static final String password = "password";
    public static final String salt = "salt";
    public static final String hashedPassword = "hashPassword";
    @Override
    public String hashPassword(String password, String salt) {
        if(password.equals("123") && salt.equals("salt")){
            return "hashed123";
        }else throw new IllegalArgumentException("Invalid password");
    }
}
