package LacksDataBaseProject;

import java.util.ArrayList;
import java.util.List;

public class User extends LacksOperations{
    protected String userName;
    protected String login;
    protected String password;
    protected String skypeID;
    protected Role role;

    AddAndRemoveSupplier addAndRemoveSupplier;
    AddAndRemoveUser addAndRemoveUser;
    AddAndRemoveLack addAndRemoveLack;
    SetLack setLack;

    protected List<User>listOfUsers = new ArrayList<>();

    public User(Role role, AddAndRemoveSupplier addAndRemoveSupplier, AddAndRemoveUser addAndRemoveUser) {
        this.role = role;
        this.addAndRemoveSupplier = addAndRemoveSupplier;
        this.addAndRemoveUser = addAndRemoveUser;
    }

    public User(Role role, AddAndRemoveLack addAndRemoveLack) {
        this.role = role;
        this.addAndRemoveLack = addAndRemoveLack;
    }

    public User(Role role, SetLack setLack) {
        this.role = role;
        this.setLack = setLack;
    }

    public User(String userName, String skypeID, Role role) {
        this.userName = userName;
        this.skypeID = skypeID;
        this.role = role;
    }

    public String getSkypeID() {
        return skypeID;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public String getUserName() { return userName; }

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
