package edu.itplusz.bibliospring.backend.utils;

public interface PasswordEncrypter {
    String hashPassword(String password,String salt);
}
