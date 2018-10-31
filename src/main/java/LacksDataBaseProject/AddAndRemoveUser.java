package LacksDataBaseProject;

import java.util.Scanner;

public class AddAndRemoveUser {
    static Scanner input = new Scanner(System.in);

    public static void addUser(User user) {
        System.out.println("Name: ");
        String userName = input.next();
        System.out.println("SkypeID: ");
        String skypeId = input.next();
        System.out.println("Login: ");
        String login = input.next();
        System.out.println("Password: ");
        String password = input.next();
        System.out.println("Repeat password: ");
        String password2 = input.next();
        if (password.equals(password2)) {
            while (true) {
                System.out.println("Select user roles: ");
                for (int i = 0; i < 2; i++) {
                    System.out.println("\t" + (i+1) + ". " + Role.values()[i]);
                }
                int addUserRole = input.nextInt();
                Role role = Role.values()[addUserRole - 1];
                User newUser = new User(userName, login, password, skypeId, role);
                User.listOfUsers.add(newUser);
                break;
            }
        }else {
            System.out.println("Password is not correct.");
        }
    }

    public static void removeUser () {
            System.out.println("Give me user ID, to remove: ");
            int userId = input.nextInt();
            for (User user : User.listOfUsers)
                if (user.getUserID() == userId && user.getRole() != Role.ADMIN) {
                    User.listOfUsers.remove(user);
                    System.out.println("User was removed.");
                    return;
            }
    }
}


