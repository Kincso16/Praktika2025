package edu.itplusz.bibliospring.backend.utils;

import org.junit.jupiter.api.Test;

import java.util.UUID;

import static org.assertj.core.api.Assertions.*;

class PasswordEncrypterTest {

    @Test
    public void passwordAndSalt_HashingPassword_PasswordIsHashed(){
        //given//arrange
        PasswordEncrypter sut = new PasswordEncrypter(); //system under tester
        String password = "password";
        String salt = UUID.randomUUID().toString();
        //when//act
        sut.hashPassword(password, salt);
        String hash = sut.hashPassword(password, salt);
        //then//assert
        String expectedHash="123456";
        assertThat(hash).isEqualTo(expectedHash);
    }

    void hashPassword() {
    }
}