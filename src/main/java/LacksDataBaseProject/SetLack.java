package LacksDataBaseProject;

import LacksDataBaseProject.Exceptions.LessThanZeroException;
import LacksDataBaseProject.Exceptions.WrongDateFormatException;

import java.util.Scanner;

public class SetLack extends CheckUserRole {
    static Scanner input = new Scanner(System.in);

    protected void setDate(Lack lack, User user) throws WrongDateFormatException {
        if (checkIfPurchaser(user)) {
            System.out.println("Give expected delivery date and time: ");
            lack.setExpectedDeliveryDateAndTime(input.next());
        } else {
            return;
        }
    }

    protected void setComment(Lack lack, User user) {
        if (checkIfPurchaser(user)) {
            System.out.println("Give comment: ");
            lack.setPurchaserAdditionalComment(input.next());
        } else {
            return;
        }
    }

    protected void setOrderedAmount(Lack lack, User user) throws LessThanZeroException {
        if (checkIfPurchaser(user)) {
            System.out.println("Give ordered amount: ");
            lack.setOrderedAmount(input.nextInt());
        } else {
            return;
        }
    }

    protected void changePurchaser(Lack lack, User user) {
        if (checkIfPurchaser(user)) {
            System.out.println("Select Purchaser from list, give Skype ID: ");
            for (User purcharser : user.listOfUsers) {
                if (purcharser.getRole().equals(Role.PURCHASER)) {
                    System.out.println("\t" + purcharser);
                    String skypeID = input.next();
                    if (purcharser.getSkypeID().equals(skypeID)) {
                        lack.getSupplier().setUser(purcharser);
                    }
                }
            }
        } else {
            return;
        }
    }
}

