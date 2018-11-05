package LacksDataBaseProject;

import java.util.Scanner;

public class AddAndRemoveUser {
    static Scanner input = new Scanner(System.in);
    private String password2;

    protected void addUser(User user) {
        if (checkIfAdmin(user)) {
            System.out.println("Name: ");
            user.userName = input.next();
            System.out.println("SkypeID: ");
            user.skypeID = input.next();
            System.out.println("Login: ");
            user.login = input.next();
            System.out.println("Password: ");
            user.password = input.next();
            System.out.println("Repeat password: ");
            password2 = input.next();
            if (user.password.equals(password2)) {
                while (true) {
                    System.out.println("Select user roles: ");
                    for (int i = 0; i < 2; i++) {
                        System.out.println("\t" + (i + 1) + ". " + Role.values()[i]);
                    }
                    int addUserRole = input.nextInt();
                    Role role = Role.values()[addUserRole - 1];
                    user.listOfUsers.add(user);
                    break;
                }
            } else {
                System.out.println("Password is not correct.");
            }
        } else {
            return;
        }
    }

    protected void removeUser (User user) {
        if (checkIfAdmin(user)) {
            System.out.println("Give skype ID, to remove: ");
            user.skypeID = input.next();
            for (User userToRemove : user.listOfUsers)
                if (userToRemove.getSkypeID() == user.skypeID && userToRemove.getRole() != Role.ADMIN) {
                    user.listOfUsers.remove(userToRemove);
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


