package LacksDataBaseProject;

import java.sql.SQLOutput;
import java.util.Scanner;

public class AddAndRemoveUser {
    static Scanner input = new Scanner(System.in);

    public static void addUser(User user){
        System.out.println("Name: ");
        input = User.userName;
        System.out.println("SkypeID: ");
        input = User.skypeID;
        System.out.println("Role: ");


        System.out.println("Login: ");
        input = User.login;
        System.out.println("Password: ");
        input = User.password;
        System.out.println("Repeat password: ");
        input = User.password2;
        if (password.equals(password2)){
            new User(userName, login, password, skypeIde, role);
            break;
        } else {
            System.out.println("Password is not correct.");
        }

    }

    public static void removeUser(User user) {
//        System.out.println("Give me user ID, to remove: ");
//        for (User x : User.listOfUsers) {
//            if (x.getUserID().) {
//                User.listOfUsers.remove(user);
//                System.out.println("User deleted.");
//                return;
//
//            }
//        }
    }
}

