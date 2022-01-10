package user;

import java.util.regex.Pattern;

public class User {
    private String errorLabel;
    private final Pattern VALID_EMAIL_REGEX =
            Pattern.compile("^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$", Pattern.CASE_INSENSITIVE);

    private String userName;
    private String userEmail;
    private String userImage;

    public User() {
        this.errorLabel = "";
        this.userName = "";
        this.userEmail = "";
        this.userImage = "";
    }

    /**
     * Returns username.
     *
     * @return name of current user
     */
    public String getUserName() {
        return userName;
    }

    /**
     * Returns user email.
     *
     * @return email of current user
     */
    public String getUserEmail() {
        return userEmail;
    }

    /**
     * Returns user image url.
     *
     * @return image url of current user
     */
    public String getUserImage() {
        return userImage;
    }

    /**
     * Sets a user image url.
     *
     * @param url url of the user image
     */
    public void setUserImage(String url) {
        this.userImage = url;
    }

    /**
     * Returns the error label message
     *
     * @return error label as string
     */
    public String getErrorLabel() {
        return this.errorLabel;
    }


    /**
     * Basic implementation for login with validation.
     *
     * @param email given email address
     * @param password given password
     * @return true if login data is valid, false if not
     * @throws IllegalArgumentException if a parameter is null
     */
    public boolean login(String email, String password) throws IllegalArgumentException {
        this.errorLabel = "";

        if (email == null || password == null) {
            throw new IllegalArgumentException("Email and password must not be null.");
        }

        if (email.length() < 1 || password.length() < 1) {
            this.errorLabel = "Email and Password are required.";
            return false;
        }

        if (!isEmailValid(email)) {
            this.errorLabel = "Email is not valid.";
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
        this.errorLabel = "";

        if (name == null || email == null || password == null) {
            throw new IllegalArgumentException("Name, email and password must not be null.");
        }

        if (name.length() < 1 || email.length() < 1 || password.length() < 1) {
            this.errorLabel = "Name, Email and Password are required.";
            return false;
        }

        if (!isEmailValid(email)) {
            this.errorLabel = "Email is not valid.";
            return false;
        }

        this.userName = name;
        this.userEmail = email;

        return true;
    }

    private boolean isEmailValid(String email) {
        return this.VALID_EMAIL_REGEX.matcher(email).find();
    }

    public static void main(String[] args) {
        User user = new User();
        boolean loginSuccess = user.login("test@test.de", "1234");
        boolean registrationSuccess = user.register("test", "test@test.de", "1234");
        System.out.println(loginSuccess);
        System.out.println(registrationSuccess);
    }
}
