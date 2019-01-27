package LacksDataBaseProject;

import LacksDataBaseProject.Exceptions.NullLackException;
import LacksDataBaseProject.Exceptions.NullSupplierException;
import LacksDataBaseProject.Exceptions.NullUserException;

import java.util.Scanner;
import java.util.UUID;

public class App {
    public static void main(String[] args) {

    }

    private static Scanner input = new Scanner(System.in);

    private static User createUser() {
        System.out.println("Insert User's name: ");
        String userName = input.next();
        System.out.println("Insert User's login: ");
        String login = input.next();
        System.out.println("Insert Users's password: ");
        String password = input.next();
        System.out.println("Repeat User's password: ");
        String password2 = input.next();
        if (!password.equals(password2)) {
            System.out.println("Password is not correct, please try to create User one more time.");
            return createUser();
        }
        System.out.println("Insert User's skypeID: ");
        String skypeID = input.next();
        System.out.println("Insert number to select User's role: ");
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
        User userToFind = User.NULL_USER;
        for (User user : crudRepository.getList()) {
            if (user.getSkypeID().equals(skypeID)) {
                userToFind = user;
            }
        }
        if (userToFind == User.NULL_USER) {
            throw new NullUserException("Such User doesn't exist in the database.");
        }
        return userToFind;
    }

    private static User choosePurchaser(CRUDRepository<User> crudRepository) {
        User user = User.NULL_USER;
        System.out.println("Select Purchaser from the List. Insert Purchaser's Skype ID: ");
        for (User purchaser : crudRepository.getList()) {
            if (purchaser.getRole().equals(Role.PURCHASER)) {
                System.out.println("\t" + purchaser);
            }
            String skypeID = input.next();
            if (purchaser.getSkypeID().equals(skypeID)) {
                user = purchaser;
            }
        }
        return user;
    }

    private static Supplier createSupplier(CRUDRepository<User> crudRepository) {
        String supplierID = UUID.randomUUID().toString();
        System.out.println("Insert Supplier's name: ");
        String supplierName = input.next();
        Supplier createdSupplier = new Supplier(supplierID, supplierName, choosePurchaser(crudRepository));
        System.out.println("You have created a new Supplier with the following data: " + createdSupplier);
        return createdSupplier;
    }

    private static Supplier getSupplierById(CRUDRepository<Supplier> crudRepository) throws NullSupplierException {
        System.out.println("Insert Supplier's ID: ");
        String supplierID = input.next();
        Supplier supplierToFind = Supplier.NULL_SUPPLIER;
        for (Supplier supplier : crudRepository.getList()) {
            if (supplier.getSupplierID().equals(supplierID)) {
                supplierToFind = supplier;
            }
            if (supplierToFind == Supplier.NULL_SUPPLIER) {
                throw new NullSupplierException("Such Supplier doesn't exist in the database.");
            }
        }
        return supplierToFind;
    }

    private static Supplier chooseSupplier(CRUDRepository<Supplier> crudRepository) {
        System.out.println("Select Supplier from the list. Insert Supplier's ID: ");
        Supplier supplierToAdd = Supplier.NULL_SUPPLIER;
        for (Supplier supplier : crudRepository.getList()) {
            System.out.println("\t" + supplier);
            String supplierID = input.next();
            if (supplier.getSupplierID().equals(supplierID)) {
                supplierToAdd = supplier;
            }
        }
        return supplierToAdd;
    }

    private static Lack createLack(CRUDRepository<Supplier> crudRepository) {
        System.out.println("Insert Item's ID: ");
        String itemID = input.next();
        System.out.println("Insert Item'S name: ");
        String itemName = input.next();
        System.out.println("Insert required amount: ");
        int requiredAmount = input.nextInt();
        System.out.println("Insert unit of measure: ");
        String unitOfMeasure = input.next();
        System.out.println("Insert comment: ");
        String additionalComment = input.next();
        Lack createdLack = new Lack(itemID, itemName, requiredAmount, unitOfMeasure, additionalComment, chooseSupplier(crudRepository));
        return createdLack;
    }

    private static Lack getLackById(CRUDRepository<Lack> crudRepository) throws NullLackException {
        System.out.println("Insert Lack's ID: ");
        int lackID = input.nextInt();
        Lack lackToFind = Lack.NULL_LACK;
        for (Lack lack : crudRepository.getList()) {
            if (lack.getLackID() == lackID) {
                lackToFind = lack;
            }
        }
        if (lackToFind == Lack.NULL_LACK) {
            throw new NullLackException("Such Lack doesn't exist in the database.");
        }
        return lackToFind;
    }

    protected static String getExpectedDeliveryDateAndTime() {
        System.out.println("Insert expected delivery date and time: ");
        return input.next();
    }

    protected static String getPurchaserComment() {
        System.out.println("Insert comment: ");
        return input.next();
    }

    protected static int getOrderedAmount() {
        System.out.println("Insert ordered amount: ");
        return input.nextInt();
    }

}