package mockTest;

import org.junit.jupiter.api.DisplayName;
import static org.mockito.Mockito.*;

import static org.junit.jupiter.api.Assertions.*;

public class UserTest {
    private User user;

    @org.junit.jupiter.api.BeforeEach
    void setUp() {
        UserService userService = mock(UserService.class);
        when(userService.getName()).thenReturn("test");
        when(userService.getEmail()).thenReturn("test@test.de");
        when(userService.getImage()).thenReturn("test.png");

        this.user = new User(userService);
    }

    @org.junit.jupiter.api.Test
    @DisplayName("Test successful login")
    void loginSuccessful() {
        user.login("test@test.de", "1234");

        assertEquals("test", user.getUserName());
        assertEquals("test@test.de", user.getUserEmail());
        assertEquals("test.png", user.getUserImage());
    }

    @org.junit.jupiter.api.Test
    @DisplayName("Test login with null parameter")
    void loginExceptionNull() {
        assertThrows(IllegalArgumentException.class, () -> user.login(null, "pw123"), "Email and password must not be null.");
        assertThrows(IllegalArgumentException.class, () -> user.login("test@test.de", null), "Email and password must not be null.");
        assertThrows(IllegalArgumentException.class, () -> user.login(null, null), "Email and password must not be null.");
    }

    @org.junit.jupiter.api.Test
    @DisplayName("Test login with empty parameter")
    void loginExceptionEmpty() {
        assertThrows(IllegalArgumentException.class, () -> user.login("", "pw123"), "Email and password must not be empty.");
        assertThrows(IllegalArgumentException.class, () -> user.login("test@test.de", ""), "Email and password must not be empty.");
        assertThrows(IllegalArgumentException.class, () -> user.login("", ""), "Email and password must not be empty.");
    }
}