package LacksDataBaseProject;

import java.util.Scanner;

public class AddAndRemoveUser {
    static Scanner input = new Scanner(System.in);
    private String password2;

    protected void addUser(User addingUser, User addedUser) {
        if (checkIfAdmin(addingUser)) {
            System.out.println("Name: ");
            addedUser.userName = input.next();
            System.out.println("SkypeID: ");
            addedUser.skypeID = input.next();
            System.out.println("Login: ");
            addedUser.login = input.next();
            System.out.println("Password: ");
            addedUser.password = input.next();
            System.out.println("Repeat password: ");
            password2 = input.next();
            if (addedUser.password.equals(password2)) {
                while (true) {
                    System.out.println("Select user roles: ");
                    for (int i = 0; i < 2; i++) {
                        System.out.println("\t" + (i + 1) + ". " + Role.values()[i]);
                    }
                    int addUserRole = input.nextInt();
                    addedUser.setRole(Role.values()[addUserRole - 1]);
                    addedUser.listOfUsers.add(addedUser);
                    break;
                }
            } else {
                System.out.println("Password is not correct.");
            }
        } else {
            return;
        }
    }

    protected void removeUser (User removingUser, User removedUser) {
        if (checkIfAdmin(removingUser)) {
            System.out.println("Give skype ID, to remove: ");
            removedUser.skypeID = input.next();
            for (User userToRemove : removedUser.listOfUsers)
                if (userToRemove.getSkypeID() == removedUser.skypeID && userToRemove.getRole() != Role.ADMIN) {
                    removedUser.listOfUsers.remove(userToRemove);
                    System.out.println("User was removed.");
                    return;
                }
        } else {
            return;
        }
    }
    private boolean checkIfAdmin(User user) {
        boolean userAdmin = true;
        if (user.getRole() != Role.ADMIN) {
            System.out.println("no authorization to add/remove User.");
            userAdmin = false;
        }
        return userAdmin;
    }
}


