package LacksDataBaseProject;

import java.util.Scanner;

public class SetLack extends CheckUserRole {
    static Scanner input = new Scanner(System.in);

    protected void setDate(Lack lack, User user) {
        if (checkIfForwarder(user)) {
            lack.setLacksDateAndTime();
        } else {
            return;
        }
    }

    protected void setComment(Lack lack, User user) {
        if (checkIfForwarder(user)) {
            lack.setDefaultPurcharserAdditionalComment();
        } else {
            return;
        }
    }

    protected void setOrderedAmount(Lack lack, User user) {
        if (checkIfForwarder(user)) {
            lack.setDefaultOrderedAmount();
        } else {
            return;
        }
    }

    protected void changePurchaser(Lack lack, User user) {
        if (checkIfForwarder(user)) {
            for (User purcharser : user.listOfUsers) {
                if (purcharser.getRole().equals(Role.PURCHASER)) {
                    System.out.println("\t" + purcharser);
                    purcharser.skypeID = input.next();
                    if (purcharser.getSkypeID() == user.skypeID) {
                        lack.setUser(user);// nie wiem jak tu poprawnie przypisać purcharsera
                    }
                }

            }
        } else {
            return;
        }
    }
}

