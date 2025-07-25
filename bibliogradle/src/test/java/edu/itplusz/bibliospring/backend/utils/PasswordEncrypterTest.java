package edu.itplusz.bibliospring.backend.utils;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.UUID;

import static org.assertj.core.api.Assertions.*;

class PasswordEncrypterTest {

    @ParameterizedTest
    @CsvSource({"password,ebddeb7b-32fb-4f51-9743-190bedfc0e7f,BC50CD2F0BC9EE55739E2EC419FF45C6F7E160A64A23136A9A171F9AD7B19CF6"})
    @CsvSource({"password, 7eeb0665-ae04-43f3-bf9b-b7d8eac9cf0e, 5920607674B1E10DDC63EA3CAA59BDF66F1402D288DCB1B7444A06AB69A0CA4E"})
    @CsvSource({"kiskutya, 4491e5b4-ee14-45d2-a532-c4a276cd69de, 3F162714CA3FD2FB0FC88C7C5121562E0A194E074B33067EA90E6B488E56702D",})
    @CsvSource({"alma, 123a10da-1226-4637-b9cb-b28cbbffeb8d, 1382B89A107D9278A7B044EA1AFCCABA5C05BB4F2F41042101305662FFFD52D8"})
    public void passwordAndSalt_hashingPassword_passwordIsHashed(String password, String salt,String expectedHash){
        //given//arrange
        PasswordEncrypter sut = new PasswordEncrypter(); //system under tester
        //when//act
        String hash = sut.hashPassword(password, salt);
        //then//assert
        assertThat(hash).isEqualTo(expectedHash);
    }

    void hashPassword() {
    }
}