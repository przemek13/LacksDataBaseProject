package LacksDataBaseProject;

import java.util.ArrayList;
import java.util.List;

public class User {
    protected String userName;
    protected String login;
    protected String password;
    protected String skypeID;
    protected Role role;

    protected List<User>listOfUsers = new ArrayList<>();

    public User() {
    }

    public User(String userName, String login, String password, String skypeID, Role role) {
        this.userName = userName;
        this.login = login;
        this.password = password;
        this.skypeID = skypeID;
        this.role = role;
    }

    public String getSkypeID() {
        return skypeID;
    }

    public Role getRole() {
        return role;
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
