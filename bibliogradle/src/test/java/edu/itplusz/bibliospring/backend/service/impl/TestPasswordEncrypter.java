package edu.itplusz.bibliospring.backend.service.impl;

import edu.itplusz.bibliospring.backend.utils.PasswordEncrypter;

public class TestPasswordEncrypter implements PasswordEncrypter {
    @Override
    public String hashPassword(String password, String salt) {
        return "";
    }
}
