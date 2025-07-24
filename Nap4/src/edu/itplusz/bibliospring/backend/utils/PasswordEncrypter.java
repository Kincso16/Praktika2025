package edu.itplusz.bibliospring.backend.utils;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class PasswordEncrypter {
    public static String hashPassword(String password,String salt){
        try {
            MessageDigest md=MessageDigest.getInstance("SHA-256");
            byte[] input =(password+salt).getBytes();
            md.reset();
            md.update(input);
            byte[] output=md.digest();
            StringBuffer sb=new StringBuffer();
            for(int i=0;i<output.length;i++){
                sb.append(String.format("%02x",output[i]));
            }
            return sb.toString();
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }
    }
}
