package LacksDataBaseProject;

import java.util.Scanner;

public class AddAndRemoveLack {
    static Scanner input = new Scanner(System.in);

/*    protected void addlack(Lack lack,User user) {
        if (checkIfForwarder(user)) {
            lack.item = input.next();
            System.out.println("Required amount: ");
            lack.requiredAmount = input.nextInt();
            System.out.println("Unit of measure: ");
            lack.unitOfMeasure = input.next();
            System.out.println("Comment: ");
            lack.forwarderAdditionalComment = input.next();
            lack.createMissingLackData();
        } else {
            return;
        }
    }
    protected void removeLack(Lack lack, User user) {
        if (checkIfForwarder(user)) {
            System.out.println("Give number of itemID to remove:");
            lack.itemID = input.next();
        for(Lack lack : LackOperations.lackList)
            if(lack.getItemID == itemID){
                lack.lacksList.remove(lack);
                System.out.println("Lack was removed");
            }
        }
    }*/

    public static void changeStatus(){
    }

    private boolean checkIfForwarder(User user) {
        boolean userForwarder = true;
        if (user.getRole() != Role.FORWARDER) {
            System.out.println("no authorization to create/change Lack data.");
            userForwarder = false;
        }
        return userForwarder;
    }
}
