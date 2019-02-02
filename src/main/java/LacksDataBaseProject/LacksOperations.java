package LacksDataBaseProject;

import LacksDataBaseProject.Exceptions.*;

import java.text.SimpleDateFormat;
import java.util.Date;

public class LacksOperations implements CheckUserRole {

    private int startId = 1;

    @Override
    public boolean checkUserRole(User user) throws ForwarderAccessException {
        if (user.getRole() == Role.FORWARDER) {
            return true;
        } else
            throw new ForwarderAccessException("No authorization. Only Forwarders allowed to modify this data. ");
    }

    protected void createMissingLackData(Lack lack, User user) throws ZeroDataException, WrongDateFormatException, LessThanZeroException, ForwarderAccessException, UserLackException {
        if (checkUserRole(user)) {
            setLackID(lack);
            setForwarderSkypeID(lack, user);
            setLacksSetDateAndTime(lack, user);
            openStatus(lack, user);
            setDefaultOrderedAmount(lack, user);
            setDefaultExpectedDeliveryDateAndTime(lack, user);
            setDefaultPurchaserAdditionalComment(lack, user);
            sendPurchaserAlert(lack, user);
        }
    }

    protected void setLackID(Lack lack) throws ZeroDataException {
        lack.setLackID(startId++);
    }

    protected void setForwarderSkypeID(Lack lack, User user) throws ForwarderAccessException {
        checkUserRole(user);
        lack.setForwarderSkypeID(user.getSkypeID());
    }

    protected void setLacksSetDateAndTime(Lack lack, User user) throws WrongDateFormatException, ForwarderAccessException {
        checkUserRole(user);
        lack.setLacksDateAndTime(new SimpleDateFormat("yyyy-MM-dd HH:mm").format(new Date()));
    }

    protected void openStatus(Lack lack, User user) throws ForwarderAccessException {
        checkUserRole(user);
        lack.setStatus(true);
    }

    protected void setDefaultOrderedAmount(Lack lack, User user) throws LessThanZeroException, ForwarderAccessException {
        checkUserRole(user);
        lack.setOrderedAmount(0);
    }

    protected void setDefaultExpectedDeliveryDateAndTime(Lack lack, User user) throws WrongDateFormatException, ForwarderAccessException {
        checkUserRole(user);
        lack.setExpectedDeliveryDateAndTime(null);
    }

    protected void setDefaultPurchaserAdditionalComment(Lack lack, User user) throws ForwarderAccessException {
        checkUserRole(user);
        lack.setPurchaserAdditionalComment(null);
    }

    protected String sendPurchaserAlert(Lack lack, User user) throws ForwarderAccessException, UserLackException {
        checkUserRole(user);
        if (lack.getSupplier().getUser() != null) {
            return "Sending Alert to " + lack.getSupplier().getUser().getUserName();
        } else throw new UserLackException("No Purchaser assigned to this Supplier");
    }
}