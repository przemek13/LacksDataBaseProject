package LacksDataBaseProject;

import java.util.Scanner;

public class AddAndRemoveSupplier extends CheckUserRole {
    static Scanner input = new Scanner(System.in);

    protected void addSupplier(Supplier supplier, User user) {
        if (checkIfAdmin(user)) {
            System.out.println("Supplier name: ");
            supplier.supplierName = input.next();
            System.out.println("Select Purchaser from List, give Skype ID: ");
            for (User purcharser : user.listOfUsers) {
                if (purcharser.getRole().equals(Role.PURCHASER)) {
                    System.out.println("\t" + purcharser);
                    purcharser.skypeID = input.next();
                    if (purcharser.getSkypeID() == user.skypeID) {
                        supplier.setUser(user);
                        supplier.listOfSuppliers.add(supplier);
                    }
                }
            }
        } else {
            return;
        }
    }
    protected void removeSupplier(Supplier supplier, User user) {
        if (checkIfAdmin(user)) {
            System.out.println("Give me supplier ID, to remove: ");
            int supplierId = input.nextInt();
            for (Supplier supplierToRemove : supplier.listOfSuppliers) {
                if (supplierToRemove.getSupplierID() == supplierId) {
                    supplier.listOfSuppliers.remove(supplierToRemove);
                    System.out.println("Supplier was removed.");
                    return;
                }
            }
        } else {
            return;
        }
    }
}

