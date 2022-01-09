package mockTest;

public class User {
    private UserService userService;

    private String userName;
    private String userEmail;
    private String userImage;

    public User(UserService userService) {
        this.userService = userService;

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
     * Login with call to user service, sets user data.
     *
     * @param email given email address
     * @param password given password
     * @throws IllegalArgumentException if a parameter is null or empty
     */
    public void login(String email, String password) throws IllegalArgumentException {
        if (email == null || password == null) {
            throw new IllegalArgumentException("Email and password must not be null.");
        }

        if (email.equals("") || password.equals("")) {
            throw new IllegalArgumentException("Email and password must not be empty.");
        }

        userService.setData(email, password);
        this.userEmail = userService.getEmail();
        this.userName = userService.getName();
        this.userImage = userService.getImage();
    }
}
