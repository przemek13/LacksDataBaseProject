package LacksDataBaseProject;

import LacksDataBaseProject.Exceptions.NullUserException;

import java.util.Scanner;

public class App {
    public static void main(String[] args) {

        User user1 = createUser();
        CRUDRepository<User> userCRUDRepository = new UserLocalRepository();
        AddAndRemoveUser addAndRemoveUser = new AddAndRemoveUser(userCRUDRepository);
    }

    private static Scanner input = new Scanner(System.in);

    public static final User NULL_OBJECT = new User("not found", "not found", "not found", "not found");

    private static User createUser() {
        System.out.println("Insert name: ");
        String userName = input.next();
        System.out.println("Insert login: ");
        String login = input.next();
        System.out.println("Insert password: ");
        String password = input.next();
        System.out.println("Repeat password: ");
        String password2 = input.next();
        if (!password.equals(password2)) {
            System.out.println("Password is not correct, please try to create User one more time.");
            return createUser();
        }
        System.out.println("Insert skypeID: ");
        String skypeID = input.next();
        System.out.println("Insert number to select user role: ");
        for (int i = 0; i <= 2; i++) {
            System.out.println("\t" + (i + 1) + ". " + Role.values()[i]);
        }
        int roleNumber = input.nextInt() - 1;
        Role role = Role.values()[roleNumber];
        User createdUser = new User(userName, login, password, skypeID, role);
        System.out.println("You have created a new User with the following data: " + createdUser);
        return createdUser;
    }

    private static User getUserById(CRUDRepository<User> crudRepository) throws NullUserException {
        System.out.println("Insert User's skype ID: ");
        String skypeID = input.next();
        User userToFind = NULL_OBJECT;
        for (User user : crudRepository.getList()) {
            if (user.getSkypeID().equals(skypeID)) {
                userToFind = user;
            }
        }
        if (userToFind == NULL_OBJECT) {
            throw new NullUserException("Such User doesn't exist in the database.");
        }
        return userToFind;
    }
}
