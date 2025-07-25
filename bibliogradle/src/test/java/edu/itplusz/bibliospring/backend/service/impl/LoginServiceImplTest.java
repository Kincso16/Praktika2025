package edu.itplusz.bibliospring.backend.service.impl;

import edu.itplusz.bibliospring.backend.service.LoginService;
import edu.itplusz.bibliospring.backend.utils.PasswordEncrypter;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.platform.commons.util.ReflectionUtils;
import org.springframework.test.util.ReflectionTestUtils;
import org.springframework.test.util.ReflectionTestUtils;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

class LoginServiceImplTest {
    private LoginServiceImpl sut;

    @BeforeEach
    public void setup() {
        sut=new LoginServiceImpl();
        ReflectionTestUtils.setField(sut, "userDAO", new TestUserDAO());
        ReflectionTestUtils.setField(sut,"PasswordEncrypter", new PasswordEncrypter());
    }

    @Test
    void login() {
        // Arrange

        // Act
        boolean loginStatus=sut.login(TestUserDAO.user);

        // Assert
        assertThat(loginStatus)
    }

    @Test
    void register() {
        // Arrange

        // Act

        // Assert
    }
}