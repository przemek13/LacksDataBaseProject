package LacksDataBaseProject;

import java.util.Scanner;

public class AddAndRemoveSupplier {
    static Scanner input = new Scanner(System.in);

    public static void addSupplier(Supplier supplier) {
        System.out.println("Supplier name: ");
        String supplierName = input.next();
        System.out.println("Select Purchaser from List, give me Purchaser ID: ");
        for (User user : User.listOfUsers) {
            if (user.getRole().equals(Role.PURCHASER)) {
                System.out.println("\t" + user);
                int userID = input.nextInt();
                if (user.getUserID() == userID) {
                    Supplier newSupplier = new Supplier(supplierName, user);
                    Supplier.listOfSuppliers.add(newSupplier);
                }
            }
        }
    }
    public static void removeSupplier(){
        System.out.println("Give me supplier ID, to remove: ");
        int supplierId = input.nextInt();
        for (Supplier supplier : Supplier.listOfSuppliers) {
            if (supplier.getSupplierID() == supplierId) {
                Supplier.listOfSuppliers.remove(supplier);
                System.out.println("Supplier deleted.");
                return;
            }
        }
    }
}

