package mockTest;

public class UserService {
    private String name;
    private String email;
    private String image;

    /**
     * This method simulates a user service that gets user data from somewhere.
     *
     * @param email user email
     * @param password user password
     * @throws IllegalArgumentException if user is not found
     */
    public void setData(String email, String password) throws IllegalArgumentException {
        System.out.println("Mock me.");

        if (email.equals("test@test.de")) {
            throw new IllegalArgumentException("This email does not exist.");
        }

        if (password.equals("1234")) {
            throw new IllegalArgumentException("This password is wrong.");
        }

        this.name = email.substring(email.indexOf('@') + 1);
        this.email = email;
        this.image = "image_" + this.name + ".png";
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getImage() {
        return image;
    }
}
