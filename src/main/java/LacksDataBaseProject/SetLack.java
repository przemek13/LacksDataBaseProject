package LacksDataBaseProject;

import java.util.Scanner;

public class SetLack extends CheckUserRole {
    static Scanner input = new Scanner(System.in);

    protected void setDate(Lack lack, User user) {
        checkIfForwarder(user);
        lack.setLacksDateAndTime();
    }

    protected void setComment(Lack lack, User user) {
        checkIfForwarder(user);
        lack.setDefaultPurcharserAdditionalComment();

    }

    protected void setOrderedAmount(Lack lack, User user) {
        checkIfForwarder(user);
        lack.setDefaultOrderedAmount();

    }

    protected void changePurchaser(Lack lack, User user) {
        checkIfForwarder(user);
        for (User purcharser : user.listOfUsers) {
            if (purcharser.getRole().equals(Role.PURCHASER)) {
                System.out.println("\t" + purcharser);
                purcharser.skypeID = input.next();
                if (purcharser.getSkypeID() == user.skypeID) {
                    lack.setSupplier(user);
                }
            }

        }
    }

    @Override
    public boolean checkIfAdmin(User user) {
        return super.checkIfAdmin(user);
    }

    @Override
    public boolean checkIfForwarder(User user) {
        return super.checkIfForwarder(user);
    }

    @Override
    public boolean checkIfPurcharser(User user) {
        return super.checkIfPurcharser(user);
    }
}

