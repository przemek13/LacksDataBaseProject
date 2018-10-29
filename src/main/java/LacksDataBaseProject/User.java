package LacksDataBaseProject;

import java.util.ArrayList;
import java.util.List;

public class User {
    private String employeeName;
    private int employeeID;
    private String login;
    private String password;
    private int skypeID;
    private Role role;

    static List<User>listOfUsers = new ArrayList<>();

    public User(String employeeName, int employeeID, String login, String password, int skypeID, Role role) {
        this.employeeName = employeeName;
        this.employeeID = employeeID;
        this.login = login;
        this.password = password;
        this.skypeID = skypeID;
        this.role = role;
    }

    public String getEmployeeName() {
        return employeeName;
    }

    public void setEmployeeName(String employeeName) {
        this.employeeName = employeeName;
    }

    public int getEmployeeID() {
        return employeeID;
    }

    public void setEmployeeID(int employeeID) {
        this.employeeID = employeeID;
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

    public int getSkypeID() {
        return skypeID;
    }

    public void setSkypeID(int skypeID) {
        this.skypeID = skypeID;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }
}
