import org.junit.Test;
import org.junit.jupiter.api.DisplayName;

import static org.junit.jupiter.api.Assertions.*;

class UserTest {
    User user;

    @org.junit.jupiter.api.BeforeEach
    void setUp() {
        this.user = new User();
    }

    @Test
    @DisplayName("Test successful login")
    void loginSuccessful() {
        assertTrue(user.login("test@test.de", "pw123"));
        assertEquals("", user.getErrorLabel());
    }

    @org.junit.jupiter.api.Test
    @DisplayName("Test successful login after missing validation")
    void loginSuccessfulAfterFail() {
        assertFalse(user.login("", ""));
        assertEquals("Email and Password are required.", user.getErrorLabel());

        assertTrue(user.login("test@test.de", "pw123"));
        // error label needs to be reset
        assertEquals("", user.getErrorLabel());
    }

    @org.junit.jupiter.api.Test
    @DisplayName("Test login with invalid email address")
    void loginEmailInvalid() {
        // usually more than one test case should not be in one test function, but since the same functionality is testet
        // and there is already a test for resetting the error label, it is ok
        assertFalse(user.login("test", "pw123"));
        assertEquals("Email is not valid.", user.getErrorLabel());

        assertFalse(user.login("test@test", "pw123"));
        assertEquals("Email is not valid.", user.getErrorLabel());

        assertFalse(user.login("@test.de", "pw123"));
        assertEquals("Email is not valid.", user.getErrorLabel());
    }

    @org.junit.jupiter.api.Test
    @DisplayName("Test login with missing password")
    void loginRequiredMissingPassword() {
        assertFalse(user.login("test", ""));
        assertEquals("Email and Password are required.", user.getErrorLabel());
    }

    @org.junit.jupiter.api.Test
    @DisplayName("Test login with missing name")
    void loginRequiredMissingName() {
        assertFalse(user.login("", "pw123"));
        assertEquals("Email and Password are required.", user.getErrorLabel());
    }

    @org.junit.jupiter.api.Test
    @DisplayName("Test login with missing password and missing name")
    void loginRequiredMissingPasswordAndName() {
        assertFalse(user.login("", ""));
        assertEquals("Email and Password are required.", user.getErrorLabel());
    }

    @org.junit.jupiter.api.Test
    @DisplayName("Test login with null parameter")
    void loginException() {
        assertThrows(IllegalArgumentException.class, () -> user.login(null, "pw123"), "Email and password must not be null.");


        assertThrows(IllegalArgumentException.class, () -> user.login("test@test.de", null), "Email and password must not be null.");
        assertEquals("", user.getErrorLabel());

        assertThrows(IllegalArgumentException.class, () -> user.login(null, null), "Email and password must not be null.");
        assertEquals(user.getErrorLabel(), "");
    }

    @org.junit.jupiter.api.Test
    @DisplayName("Test successful registration")
    void registerSuccessful() {
        assertTrue(user.register("test", "test@test.de", "pw123"));
        assertEquals("", user.getErrorLabel());
        assertEquals("test", user.getUserName());
        assertEquals("test@test.de", user.getUserEmail());
    }

    @org.junit.jupiter.api.Test
    @DisplayName("Test registration with missing name")
    void registerRequriredMissingName() {
        assertFalse(user.register("", "test@test.de", "pw123"));
        assertEquals("Name, Email and Password are required.", user.getErrorLabel());
        assertEquals("", user.getUserName());
        assertEquals("", user.getUserEmail());
    }

    @org.junit.jupiter.api.Test
    @DisplayName("Test registration with missing email")
    void registerRequriredMissingEmail() {
        assertFalse(user.register("test", "", "pw123"));
        assertEquals("Name, Email and Password are required.", user.getErrorLabel());
        assertEquals("", user.getUserName());
        assertEquals("", user.getUserEmail());
    }

    @org.junit.jupiter.api.Test
    @DisplayName("Test registration with missing password")
    void registerRequriredMissingPassword() {
        assertFalse(user.register("test", "test@test.de", ""));
        assertEquals("Name, Email and Password are required.", user.getErrorLabel());
        assertEquals("", user.getUserName());
        assertEquals("", user.getUserEmail());
    }

    @org.junit.jupiter.api.Test
    @DisplayName("Test registration with all parameters missing")
    void registerRequriredMissingAll() {
        assertFalse(user.register("", "", ""));
        assertEquals("Name, Email and Password are required.", user.getErrorLabel());
        assertEquals("", user.getUserName());
        assertEquals("", user.getUserEmail());
    }

    @org.junit.jupiter.api.Test
    @DisplayName("Test registration with invalid email address")
    void registerEmailInvalid() {
        assertFalse(user.register("test", "test", "pw123"));
        assertEquals("Email is not valid.", user.getErrorLabel());

        assertFalse(user.register("test", "@test.de", "pw123"));
        assertEquals("Email is not valid.", user.getErrorLabel());

        assertFalse(user.register("test", "test@test", "pw123"));
        assertEquals("Email is not valid.", user.getErrorLabel());

        assertEquals("", user.getUserName());
        assertEquals("", user.getUserEmail());
    }

    @org.junit.jupiter.api.Test
    @DisplayName("Test registration with null parameter")
    void registerException() {
        assertThrows(IllegalArgumentException.class, () -> user.register(null, "test@test.de", "pw123"), "Name, email and password must not be null.");
        assertEquals("", user.getErrorLabel());

        assertThrows(IllegalArgumentException.class, () -> user.register("test", null, "pw123"), "Name, email and password must not be null.");
        assertEquals("", user.getErrorLabel());

        assertThrows(IllegalArgumentException.class, () -> user.register("test", "test@test.de", null), "Name, email and password must not be null.");
        assertEquals("", user.getErrorLabel());

        assertThrows(IllegalArgumentException.class, () -> user.register(null, null, null), "Name, email and password must not be null.");
        assertEquals("", user.getErrorLabel());

        assertEquals("", user.getUserName());
        assertEquals("", user.getUserEmail());
    }

    @org.junit.jupiter.api.Test
    @DisplayName("Test setting of user image")
    void setUserImage() {
        this.user.setUserImage("testimage.png");
        assertEquals("testimage.png", user.getUserImage());
    }
}