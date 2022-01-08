package normalTest;

import static org.junit.jupiter.api.Assertions.*;

class UserTest {
    User user;

    @org.junit.jupiter.api.BeforeEach
    void setUp() {
        this.user = new User();
    }

    @org.junit.jupiter.api.Test
    void loginSuccessful() {
        assertTrue(user.login("test@test.de", "pw123"));
        assertEquals(user.getLoginErrorLabelProperty(), "");
        assertEquals(user.getRegistrationErrorLabelProperty(), "");
    }

    @org.junit.jupiter.api.Test
    void loginEmailInvalid() {
        assertFalse(user.login("test", "pw123"));
        assertEquals(user.getLoginErrorLabelProperty(), "Email is not valid.");
        assertEquals(user.getRegistrationErrorLabelProperty(), "");

        assertFalse(user.login("test@test", "pw123"));
        assertEquals(user.getLoginErrorLabelProperty(), "Email is not valid.");
        assertEquals(user.getRegistrationErrorLabelProperty(), "");

        assertFalse(user.login("@test.de", "pw123"));
        assertEquals(user.getLoginErrorLabelProperty(), "Email is not valid.");
        assertEquals(user.getRegistrationErrorLabelProperty(), "");

    }

    @org.junit.jupiter.api.Test
    void loginRequiredMissing() {
        assertFalse(user.login("test", ""));
        assertEquals(user.getLoginErrorLabelProperty(), "Email and Password are required.");
        assertEquals(user.getRegistrationErrorLabelProperty(), "");

        assertFalse(user.login("", "pw123"));
        assertEquals(user.getLoginErrorLabelProperty(), "Email and Password are required.");
        assertEquals(user.getRegistrationErrorLabelProperty(), "");

        assertFalse(user.login("", ""));
        assertEquals(user.getLoginErrorLabelProperty(), "Email and Password are required.");
        assertEquals(user.getRegistrationErrorLabelProperty(), "");
    }

    @org.junit.jupiter.api.Test
    void loginException() {
        assertThrows(IllegalArgumentException.class, () -> user.login(null, "pw123"), "Email and password must not be null.");
        assertEquals(user.getLoginErrorLabelProperty(), "");
        assertEquals(user.getRegistrationErrorLabelProperty(), "");

        assertThrows(IllegalArgumentException.class, () -> user.login("test@test.de", null), "Email and password must not be null.");
        assertEquals(user.getLoginErrorLabelProperty(), "");
        assertEquals(user.getRegistrationErrorLabelProperty(), "");

        assertThrows(IllegalArgumentException.class, () -> user.login(null, null), "Email and password must not be null.");
        assertEquals(user.getLoginErrorLabelProperty(), "");
        assertEquals(user.getRegistrationErrorLabelProperty(), "");
    }

    @org.junit.jupiter.api.Test
    void registerSuccessful() {
        assertTrue(user.register("test", "test@test.de", "pw123"));
        assertEquals(user.getLoginErrorLabelProperty(), "");
        assertEquals(user.getRegistrationErrorLabelProperty(), "");
    }

    @org.junit.jupiter.api.Test
    void registerRequriredMissing() {
        assertFalse(user.register("", "test@test.de", "pw123"));
        assertEquals(user.getRegistrationErrorLabelProperty(), "Name, Email and Password are required.");
        assertEquals(user.getLoginErrorLabelProperty(), "");

        assertFalse(user.register("test", "", "pw123"));
        assertEquals(user.getRegistrationErrorLabelProperty(), "Name, Email and Password are required.");
        assertEquals(user.getLoginErrorLabelProperty(), "");

        assertFalse(user.register("test", "test@test.de", ""));
        assertEquals(user.getRegistrationErrorLabelProperty(), "Name, Email and Password are required.");
        assertEquals(user.getLoginErrorLabelProperty(), "");

        assertFalse(user.register("", "", ""));
        assertEquals(user.getRegistrationErrorLabelProperty(), "Name, Email and Password are required.");
        assertEquals(user.getLoginErrorLabelProperty(), "");
    }

    @org.junit.jupiter.api.Test
    void registerEmailInvalid() {
        assertFalse(user.register("test", "test", "pw123"));
        assertEquals(user.getRegistrationErrorLabelProperty(), "Email is not valid.");
        assertEquals(user.getLoginErrorLabelProperty(), "");

        assertFalse(user.register("test", "@test.de", "pw123"));
        assertEquals(user.getRegistrationErrorLabelProperty(), "Email is not valid.");
        assertEquals(user.getLoginErrorLabelProperty(), "");

        assertFalse(user.register("test", "test@test", "pw123"));
        assertEquals(user.getRegistrationErrorLabelProperty(), "Email is not valid.");
        assertEquals(user.getLoginErrorLabelProperty(), "");
    }

    @org.junit.jupiter.api.Test
    void registerException() {
        assertThrows(IllegalArgumentException.class, () -> user.register(null, "test@test.de", "pw123"), "Name, email and password must not be null.");
        assertEquals(user.getLoginErrorLabelProperty(), "");
        assertEquals(user.getRegistrationErrorLabelProperty(), "");

        assertThrows(IllegalArgumentException.class, () -> user.register("test", null, "pw123"), "Name, email and password must not be null.");
        assertEquals(user.getLoginErrorLabelProperty(), "");
        assertEquals(user.getRegistrationErrorLabelProperty(), "");

        assertThrows(IllegalArgumentException.class, () -> user.register("test", "test@test.de", null), "Name, email and password must not be null.");
        assertEquals(user.getLoginErrorLabelProperty(), "");
        assertEquals(user.getRegistrationErrorLabelProperty(), "");

        assertThrows(IllegalArgumentException.class, () -> user.register(null, null, null), "Name, email and password must not be null.");
        assertEquals(user.getLoginErrorLabelProperty(), "");
        assertEquals(user.getRegistrationErrorLabelProperty(), "");
    }
}