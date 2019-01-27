package LacksDataBaseProject;

public class User extends LacksOperations {
    protected String userName;
    protected String login;
    protected String password;
    protected String skypeID;
    protected Role role;

    public static final User NULL_USER = new User("not found");

    public User(String userName, String login, String password, String skypeID, Role role) {
        this.userName = userName;
        this.login = login;
        this.password = password;
        this.skypeID = skypeID;
        this.role = role;
    }

    public User(String userName) {
        this.userName = userName;
    }

    public String getSkypeID() {
        return skypeID;
    }

    public Role getRole() {
        return role;
    }

    public String getUserName() {
        return userName;
    }

    @Override
    public String toString() {
        return "User{" +
                "userName='" + userName + '\'' +
                ", login='" + login + '\'' +
                ", password='" + password + '\'' +
                ", skypeID='" + skypeID + '\'' +
                ", role=" + role +
                '}';
    }
}
