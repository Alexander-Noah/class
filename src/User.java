public class User {

    private String username;
    private String password;
    private String role;
    private String clazz;

    public User(String username, String password, String role, String clazz) {
        this.username = username;
        this.password = password;
        this.role = role;
        this.clazz = clazz;
    }

    public String getUsername() { return username; }
    public String getPassword() { return password; }
    public String getRole() { return role; }
    public String getClazz() { return clazz; }
}

