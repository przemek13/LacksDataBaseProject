package LacksDataBaseProject;

import LacksDataBaseProject.Exceptions.LessThanZeroException;
import LacksDataBaseProject.Exceptions.PurchaserAccessException;
import LacksDataBaseProject.Exceptions.WrongDateFormatException;

public class SetLack implements CheckUserRole {

    @Override
    public boolean checkUserRole(User user) throws PurchaserAccessException {
        if (user.getRole() == Role.PURCHASER) {
            return true;
        } else
            throw new PurchaserAccessException("No authorization. Only Purhcaser allowed to modify this data. ");
    }

    protected void setDate(Lack lack, User user) throws WrongDateFormatException, PurchaserAccessException {
        if (checkUserRole(user)) {
            lack.setExpectedDeliveryDateAndTime(App.getExpectedDeliveryDateAndTime());
            System.out.println("Sending Alert to " + lack.getForwarderSkypeID() + ". "
                    + " Purchaser changed delivery date in the following lack: " + lack);
        }
    }

    protected void setComment(Lack lack, User user) throws PurchaserAccessException {
        if (checkUserRole(user)) {
            lack.setPurchaserAdditionalComment(App.getPurchaserComment());
            System.out.println("Sending Alert to " + lack.getForwarderSkypeID() + ". "
                    + " Purchaser put new comment in the following lack: " + lack);
        }
    }

    protected void setOrderedAmount(Lack lack, User user) throws LessThanZeroException, PurchaserAccessException {
        if (checkUserRole(user)) {
            lack.setOrderedAmount(App.getOrderedAmount());
            System.out.println("Sending Alert to " + lack.getForwarderSkypeID() + ". "
                    + " Purchaser changed ordered amount in the following lack: " + lack);
        }
    }
}

