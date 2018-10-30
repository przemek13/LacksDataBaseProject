package LacksDataBaseProject;

import java.util.Scanner;

public class AddAndRemoveUser {
    static Scanner input = new Scanner(System.in);

    public static void addUser(User user){
        System.out.println("Name: ");
        String userName = input.next();
        System.out.println("SkypeID: ");
        String skypeId = input.next();
        System.out.println("Role: ");
        // rola do wyboru purchaser lub forwarder

        System.out.println("Login: ");
        String login = input.next();
        System.out.println("Password: ");
        String password = input.next();
        System.out.println("Repeat password: ");
        String password2 = input.next();
        if (password.equals(password2)){
            User newUser = new User(userName, login, password, skypeId, Role.ADMIN);  //rola do wyboru
            User.listOfUsers.add(newUser);
        } else {
            System.out.println("Password is not correct.");
        }
    }

    public static void removeUser() {
       System.out.println("Give me user ID, to remove: ");
       int userId = input.nextInt();
        for (User user : User.listOfUsers)
            if (user.getUserID() == userId) {
                User.listOfUsers.remove(user);
                System.out.println("User deleted.");
                return;
           }
        }
}

