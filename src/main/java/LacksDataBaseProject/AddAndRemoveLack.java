package LacksDataBaseProject;

import java.util.Scanner;

public class AddAndRemoveLack {
    static Scanner input = new Scanner(System.in);

    protected void addlack(Lack lack, User user) {
        if (checkIfForwarder(user)) {
            System.out.println("Give item name: ");
            lack.item.itemName = input.next();
            System.out.println("Give item ID: ");
            lack.item.itemID = input.next();
            System.out.println("Required amount: ");
            lack.requiredAmount = input.nextInt();
            System.out.println("Unit of measure: ");
            lack.unitOfMeasure = input.next();
            System.out.println("Comment: ");
            lack.forwarderAdditionalComment = input.next();
            user.LacksOperations.createMissingLackData(lack, user);
            System.out.println("Select Supplier from list, give Skype ID: ");
            for (Supplier supplierToAdd : supplier.listOfSuppliers) {
                System.out.println("\t" + supplierToAdd);
                int supplierId = input.nextInt();
                if (supplierToAdd.getSupplierID() == supplier.supplierId) {
                    // nie wiem jak przypisać tego suppliera po jego wyborze do lacka
                    // np. lack.supplier ?
                }
            }
        } else {
            return;
        }
    }

    protected void removeLack(Lack lack, User user) {
        if (checkIfForwarder(user)) {
            System.out.println("Give number of itemID to remove:");
            lack.itemID = input.next();
        for(Lack lackToRemove : user.LackOperations.lackList)
            if(lackToRemove.getItemID == itemID){
                lack.lacksList.remove(lackToRemove);
                System.out.println("Lack was removed");
            }
        }
    }

    public static void changeStatus(Lack lack, User user){
        if (checkIfForwarder(user)) {
            lack.setStatus = false;
        } else {
            return;
        }
    }
}
