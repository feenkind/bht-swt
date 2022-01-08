package normalTest;

import java.util.regex.Pattern;

public class User {
    private String loginErrorLabel;
    private String registrationErrorLabel;

    public User() {
        this.loginErrorLabel = "";
        this.registrationErrorLabel = "";
    }

    private final Pattern VALID_EMAIL_REGEX =
            Pattern.compile("^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$", Pattern.CASE_INSENSITIVE);


    /**
     * Basic implementation for login with validation.
     *
     * @param email given email address
     * @param password given password
     * @return true if login data is valid, false if not
     * @throws IllegalArgumentException if a parameter is null
     */
    public boolean login(String email, String password) throws IllegalArgumentException {
        this.loginErrorLabel = "";

        if (email == null || password == null) {
            throw new IllegalArgumentException("Email and password must not be null.");
        }

        if (email.length() < 1 || password.length() < 1) {
            this.loginErrorLabel = "Email and Password are required.";
            return false;
        }

        if (!isEmailValid(email)) {
            this.loginErrorLabel = "Email is not valid.";
            return false;
        }

        return true;
    }

    /**
     * Basic implementation for registration with validation.
     *
     * @param name fiven name
     * @param email given email address
     * @param password given password
     * @return true if registration data is valid, false if not
     * @throws IllegalArgumentException if a parameter is null
     */
    public boolean register(String name, String email, String password) throws IllegalArgumentException {
        this.registrationErrorLabel = "";

        if (name == null || email == null || password == null) {
            throw new IllegalArgumentException("Name, email and password must not be null.");
        }

        if (name.length() < 1 || email.length() < 1 || password.length() < 1) {
            this.registrationErrorLabel = "Name, Email and Password are required.";
            return false;
        }

        if (!isEmailValid(email)) {
            this.registrationErrorLabel = "Email is not valid.";
            return false;
        }

        return true;
    }

    private boolean isEmailValid(String email) {
        return this.VALID_EMAIL_REGEX.matcher(email).find();
    }

    public String getLoginErrorLabelProperty() {
        return this.loginErrorLabel;
    }

    public String getRegistrationErrorLabelProperty() {
        return this.registrationErrorLabel;
    }
}
