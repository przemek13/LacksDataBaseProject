package LacksDataBaseProject;

import java.util.ArrayList;
import java.util.List;

public class User {
    private String userName;
    private int userID;
    private String login;
    private String password;
    private String skypeID;
    private Role role;

    static List<User>listOfUsers = new ArrayList<>();

    public User(String employeeName, int employeeID, String login, String password, String skypeID, Role role) {
        this.userName = employeeName;
        this.userID = employeeID;
        this.login = login;
        this.password = password;
        this.skypeID = skypeID;
        this.role = role;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public int getUserID() {
        return userID;
    }

    public void setUserID(int userID) {
        this.userID = userID;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getSkypeID() {
        return skypeID;
    }

    public void setSkypeID(String skypeID) {
        this.skypeID = skypeID;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public static List<User> getListOfUsers() {
        return listOfUsers;
    }

    public static void setListOfUsers(List<User> listOfUsers) {
        User.listOfUsers = listOfUsers;
    }
}
