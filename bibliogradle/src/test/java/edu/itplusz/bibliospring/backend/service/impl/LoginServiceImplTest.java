package edu.itplusz.bibliospring.backend.service.impl;

import edu.itplusz.bibliospring.backend.model.User;
import edu.itplusz.bibliospring.backend.repository.UserDAO;
import edu.itplusz.bibliospring.backend.utils.PasswordEncrypter;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.test.util.ReflectionTestUtils;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.*;

class LoginServiceImplTest {
    private LoginServiceImpl serviceUnderTest;

    private UserDAO testUserDao;

    private PasswordEncrypter testPasswordEncrypter;

    private User nonDbUser;

    private User dbUser;

    @BeforeEach
    void setUp() {
        // Initialize the service under test
        serviceUnderTest = new LoginServiceImpl();

        nonDbUser = new User();
        nonDbUser.setPassword(TestPasswordEncrypter.password);
        nonDbUser.setUsername("Pistike");
        nonDbUser.setUuid(TestPasswordEncrypter.salt);
        nonDbUser.setId(1L);

        dbUser = new User();
        dbUser.setPassword(TestPasswordEncrypter.hashedPassword);
        dbUser.setUsername("Pistike");
        dbUser.setUuid(TestPasswordEncrypter.salt);
        dbUser.setId(1L);

        testUserDao = mock(UserDAO.class);
        testPasswordEncrypter = mock(PasswordEncrypter.class);
        when(testPasswordEncrypter.hashPassword(nonDbUser.getPassword(), nonDbUser.getUuid()))
                .thenReturn(dbUser.getPassword());

        ReflectionTestUtils.setField(serviceUnderTest, "userDAO", testUserDao);
        when(testUserDao.findByUsername(nonDbUser.getUsername())).thenReturn(dbUser);

        ReflectionTestUtils.setField(serviceUnderTest, "passwordEncrypter", testPasswordEncrypter);

        // Mock dependencies if necessary, e.g., UserDAO and PasswordEncrypter
        // This can be done using a mocking framework like Mockito
        // For example:
        // userDAO = mock(UserDAO.class);


    }

    @Test
    void login() {
        // Arrange
        // Mock the PasswordEncrypter to return a hashed password when hashPassword is called

        // Act
        // Call the login method with the mock User object
        boolean loginStatus = serviceUnderTest.login(nonDbUser);

        // Assert
        // Verify that the UserDAO's findByUsername method was called with the correct username
        // Verify that the PasswordEncrypter's hashPassword method was called with the correct parameters
        assertThat(loginStatus).isTrue();
        verify(testUserDao, times(1)).findByUsername(nonDbUser.getUsername());

        //assertThat(testUserDao.getLastSearchedUsernName()).isEqualTo(TestUserDAO.nonDbUser.getUsername());
    }
}