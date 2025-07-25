package edu.itplusz.bibliospring.backend.utils;

import edu.itplusz.bibliospring.backend.utils.impl.PasswordEncrypterImpl;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.*;

class PasswordEncrypterTest {

    @ParameterizedTest
    @CsvSource({"password,ebddeb7b-32fb-4f51-9743-190bedfc0e7f,BC50CD2F0BC9EE55739E2EC419FF45C6F7E160A64A23136A9A171F9AD7B19CF6"})
    @CsvSource({"password, 7eeb0665-ae04-43f3-bf9b-b7d8eac9cf0e, 5920607674B1E10DDC63EA3CAA59BDF66F1402D288DCB1B7444A06AB69A0CA4E"})
    @CsvSource({"kiskutya, 4491e5b4-ee14-45d2-a532-c4a276cd69de, 3F162714CA3FD2FB0FC88C7C5121562E0A194E074B33067EA90E6B488E56702D"})
    @CsvSource({"alma, 123a10da-1226-4637-b9cb-b28cbbffeb8d, 1382B89A107D9278A7B044EA1AFCCABA5C05BB4F2F41042101305662FFFD52D8"})
    //@CsvSource({"hello, 12345678-aaaa-bbbb-cccc-123456789abc, 7DB4C93787A1EF9608D20B87E117AF9A53F0DE84FC38B68C92DE5BE0F1C71C4F"})
    //@CsvSource({"123456,9f8a6b9d-23c7-44db-a4d4-64c2f5b8451a,82D2F701D6E90F8F7AB89159AAEC219F1923C3D69A110C950C457BDE6C177F0A"})
    public void passwordAndSalt_hashingPassword_passwordIsHashed(String password, String salt,String expectedHash){
        //given//arrange
        PasswordEncrypterImpl sut = new PasswordEncrypterImpl(); //system under tester
        //when//act
        String hash = sut.hashPassword(password, salt);
        //then//assert
        assertThat(hash).isEqualTo(expectedHash);
    }
}