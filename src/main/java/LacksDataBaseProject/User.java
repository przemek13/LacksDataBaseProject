package LacksDataBaseProject;

public class User extends LacksOperations {

    private String userName;
    private String login;
    private String password;
    private Role role = Role.FORWARDER;
    private String skypeID = "testSkypeID";
    //zrezygnowałem z userID, bo skypeID jednoznacznie identyfikuje User'a więc wystarczy
    //wartość przypisana tylko na potrzeby sprawdzenia
    private boolean logINstatus;

    protected String getSkypeID() {
        return skypeID;
    }

    protected Role getRole() {
        return role;
    }
}
