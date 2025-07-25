package edu.itplusz.bibliospring.backend.utils;

import org.junit.jupiter.api.Test;

import java.util.UUID;

import static org.assertj.core.api.Assertions.*;

class PasswordEncrypterTest {

    @Test
    public void passwordAndSalt_hashingPassword_passwordIsHashed(){
        //given//arrange
        PasswordEncrypter sut = new PasswordEncrypter(); //system under tester
        String password = "password";
        String salt = "ebddeb7b-32fb-4f51-9743-190bedfc0e7f";
        //when//act
        String hash = sut.hashPassword(password, salt);
        //then//assert
        String expectedHash="BC50CD2F0BC9EE55739E2EC419FF45C6F7E160A64A23136A9A171F9AD7B19CF6";
        assertThat(hash).isEqualTo(expectedHash);
    }

    void hashPassword() {
    }
}