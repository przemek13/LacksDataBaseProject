package LacksDataBaseProject;

import LacksDataBaseProject.Exceptions.LessThanZeroException;
import LacksDataBaseProject.Exceptions.WrongDateFormatException;
import LacksDataBaseProject.Exceptions.ZeroDataException;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class LacksOperations extends CheckUserRole {

    protected final List<Lack> lacksList = new ArrayList<>();

    private int startId = 1;

    protected void createMissingLackData(Lack lack, User user) throws ZeroDataException, WrongDateFormatException, LessThanZeroException {
        if (checkIfForwarder(user)) {
            setLackID(lack);
            setForwarderSkypeID(lack, user);
            setLacksSetDateAndTime(lack, user);
            openStatus(lack, user);
            setDefaultOrderedAmount(lack, user);
            setDefaultExpectedDeliveryDateAndTime(lack, user);
            setDefaultPurchaserAdditionalComment(lack, user);
            lacksList.add(lack);
            sendPurchaserAlert(lack, user);
            sendForwarderAlert(lack, user);
        }
    }

    protected void setLackID(Lack lack) throws ZeroDataException {

        lack.setLackID(startId++);
    }

    protected void setForwarderSkypeID(Lack lack, User user) {
        if (checkIfForwarder(user)) {
            lack.setForwarderSkypeID(user.getSkypeID());
        }
    }

    protected void setLacksSetDateAndTime(Lack lack, User user) throws WrongDateFormatException {
        if (checkIfForwarder(user)) {
            lack.setLacksDateAndTime(new SimpleDateFormat("yyyy-MM-dd, HH:mm").format(new Date()));
        }
    }

    protected void openStatus(Lack lack, User user) {
        if (checkIfForwarder(user)) {
            lack.setStatus(true);
        }
    }

    protected void setDefaultOrderedAmount(Lack lack, User user) throws LessThanZeroException {
        if (checkIfForwarder(user)) {
            lack.setOrderedAmount(0);
        }
    }

    protected void setDefaultExpectedDeliveryDateAndTime(Lack lack, User user) throws WrongDateFormatException {
        if (checkIfForwarder(user)) {
            lack.setExpectedDeliveryDateAndTime(null);
        }
    }

    protected void setDefaultPurchaserAdditionalComment(Lack lack, User user) {
        if (checkIfForwarder(user)) {
            lack.setPurchaserAdditionalComment(" ");
        }
    }

    public List<Lack> getLacksList() {
        return lacksList;
    }

    protected void sendPurchaserAlert(Lack lack, User user) {
        if (checkIfForwarder(user)) {
            if (lack.getSupplier().getUser() != null) {
                System.out.println("Sending Alert to " + lack.getSupplier().getUser().getUserName());
            }
        }
    }

    protected void sendForwarderAlert(Lack lack, User user) {
        if (user.getRole() == Role.FORWARDER) {
            if ((lack.getOrderedAmount() != 0) && (lack.getExpectedDeliveryDateAndTime() != lack.getLacksDateAndTime()) && (lack.getPurchaserAdditionalComment() != " ")) {
                System.out.println("Sending Alert to" + lack.getForwarderSkypeID());
            }
        } else
            System.out.println("no authorization");
    }
}