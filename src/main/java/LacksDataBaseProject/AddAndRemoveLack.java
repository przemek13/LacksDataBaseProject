package LacksDataBaseProject;

import java.util.Scanner;

public class AddAndRemoveLack {
    static Scanner input = new Scanner(System.in);

    public static void addlack(User user){
        System.out.println("Item: ");
        //Item item
        System.out.println("Required amount: ");
        int requiredAmount = input.nextInt();
        System.out.println("Unit of measure: ");
        String unitOfMeasure = input.next();
        System.out.println("Comment: ");
        String forwarderAdditionalComment = input.next();
        // Lack lack = new Lack(item, requiredAmount, unitOfMeasure, forwarderAdditionalComment,....
        // i dodatkowe dane które przekazuje Purchaser

    }
    public static void removeLack(){
        System.out.println("Give number of itemID to remove:");
        String itemID = input.next();
        /*for(Lack lack : LackOperations.lackList)
            if(Lack.getItemID == itemID){
                LackOperations.lacksList.remove(lack);
                System.out.println("Lack was removed");
            }*/

    }
    public static void chooseSupplier(){

    }
    public static void changeStatus(){

    }
}
