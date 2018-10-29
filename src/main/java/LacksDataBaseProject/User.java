package LacksDataBaseProject;

public class User {
    private String employeeName;
    private int employeeID;
    private String login;
    private String password;
    private int skypeID;
    private Role role;

    public User(String employeeName, int employeeID, String login, String password, int skypeID) {
        this.employeeName = employeeName;
        this.employeeID = employeeID;
        this.login = login;
        this.password = password;
        this.skypeID = skypeID;
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
}
