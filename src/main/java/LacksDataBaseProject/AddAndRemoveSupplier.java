package LacksDataBaseProject;

import LacksDataBaseProject.Exceptions.AdminAccessException;

import java.util.Scanner;

public class AddAndRemoveSupplier implements CheckUserRole {
    static Scanner input = new Scanner(System.in);
    private int startId = 1;

    @Override
    public boolean checkUserRole(User user) throws AdminAccessException {
        if (user.getRole() == Role.ADMIN) {
            return true;
        }
        else
            throw new AdminAccessException ("No authorization. Only Admin allowed to modify this data. ");
    }

    protected void setSupplierID(Supplier supplier) {
        supplier.setSupplierID(startId++);
    }

    protected void addSupplier(Supplier supplier, User user) throws AdminAccessException {
        if (checkUserRole(user)) {
            setSupplierID(supplier);
            System.out.println("Supplier name: ");
            supplier.setSupplierName(input.next());
            System.out.println("Select Purchaser from List, give Skype ID: ");
            for (User purcharser : user.addAndRemoveUser.crudRepository.getList()) {
                if (purcharser.getRole().equals(Role.PURCHASER)) {
                    System.out.println("\t" + purcharser);
                    String skypeID = input.next();
                    if (purcharser.getSkypeID().equals(skypeID)) {
                        supplier.setUser(purcharser);
                    }
                    supplier.listOfSuppliers.add(supplier);
                }
            }
        } else {
            return;
        }
    }

    protected void removeSupplier(Supplier supplier, User user) throws AdminAccessException {
        if (checkUserRole(user)) {
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

