package LacksDataBaseProject;

import LacksDataBaseProject.Exceptions.*;

import java.util.Scanner;

public class AddAndRemoveLack implements CheckUserRole {
    static Scanner input = new Scanner(System.in);

    @Override
    public boolean checkUserRole(User user) throws ForwarderAccessException {
        if (user.getRole() == Role.FORWARDER) {
            return true;
        }
        else
            throw new ForwarderAccessException("No authorization. Only Forwarders allowed to modify this data. ");
    }

    protected void addlack(Lack lack, User user, Supplier supplier) throws ZeroDataException, WrongDateFormatException, LessThanZeroException, ForwarderAccessException, UserLackException {
        if (checkUserRole(user)) {
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

    protected void removeLack(Lack lack, User user) throws ForwarderAccessException {
        if (checkUserRole(user)) {
            System.out.println("Give ID of lack to remove:");
            int lackID = Integer.parseInt(input.next());
            for (Lack lackToRemove : user.lacksList)
                if (lackToRemove.getLackID() == lackID) {
                    user.lacksList.remove(lackToRemove);
                    System.out.println("Lack was removed");
                }
        }
    }

    protected void changeStatus(Lack lack, User user) throws ForwarderAccessException {
        if (checkUserRole(user)) {
            lack.setStatus(false);
        } else {
            return;
        }
    }
}
