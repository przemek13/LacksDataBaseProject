package LacksDataBaseProject;

public class AddAndRemoveUser {
    public static void addUser(User user) {
        User.listOfUsers.add(user);
    }

    public static void removeUser(User user) {

        User.listOfUsers.remove(user);
    }
}

