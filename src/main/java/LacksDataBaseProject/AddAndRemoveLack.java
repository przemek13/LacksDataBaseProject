package LacksDataBaseProject;

import LacksDataBaseProject.Exceptions.LessThanZeroException;
import LacksDataBaseProject.Exceptions.WrongDateFormatException;
import LacksDataBaseProject.Exceptions.ZeroDataException;

import java.util.Scanner;

public class AddAndRemoveLack extends CheckUserRole {
    static Scanner input = new Scanner(System.in);

    protected void addlack(Lack lack, User user, Supplier supplier) throws ZeroDataException, WrongDateFormatException, LessThanZeroException {
        if (checkIfForwarder(user)) {
            System.out.println("Give item name: ");
            lack.setItemID(input.next());
            System.out.println("Give item ID: ");
            lack.setItemName(input.next());
            System.out.println("Required amount: ");
            lack.setRequiredAmount(Integer.parseInt(input.next()));
            System.out.println("Unit of measure: ");
            lack.setUnitOfMeasure(input.next());
            System.out.println("Comment: ");
            lack.setForwarderAdditionalComment(input.next());
            System.out.println("Select Supplier from list, give Supplier ID: ");
            for (Supplier supplierToAdd : supplier.listOfSuppliers) {
                System.out.println("\t" + supplierToAdd);
                int supplierId = Integer.parseInt(input.next());
                if (supplierToAdd.getSupplierID() == supplierId) {
                    lack.setSupplier(supplierToAdd);
                }
            }
            user.createMissingLackData(lack, user);
        } else {
            return;
        }
    }

    protected void removeLack(Lack lack, User user) {
        if (checkIfForwarder(user)) {
            System.out.println("Give ID of lack to remove:");
            int lackID = Integer.parseInt(input.next());
            for (Lack lackToRemove : user.lacksList)
                if (lackToRemove.getLackID() == lackID) {
                    user.lacksList.remove(lackToRemove);
                    System.out.println("Lack was removed");
                }
        }
    }

    protected void changeStatus(Lack lack, User user) {
        if (checkIfForwarder(user)) {
            lack.setStatus(false);
        } else {
            return;
        }
    }
}
