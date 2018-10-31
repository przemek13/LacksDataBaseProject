package LacksDataBaseProject;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class LacksOperations {

    protected List<Lack> lacksList = new ArrayList<>();

    private int startId = 1;

    private boolean checkIfForwarder(User user) {
        boolean userForwarder = true;
        if (user.getRole() != Role.FORWARDER) {
            System.out.println("no authorization to create/change Lack data.");
            userForwarder = false;
        }
        return userForwarder;
    }


    protected void createMissingLackData(Lack lack, User user) {
        if (checkIfForwarder(user)) {
            setLackID(lack, user);
            setForwarderSkypeID(lack, user);
            setLacksSetDateAndTime(lack, user);
            openStatus(lack, user);
            setDefaultOrderedAmount(lack, user);
            setDefaultExpectedDeliveryDateAndTime(lack, user);
            setDefaultPurchaserAdditionalComment(lack, user);
            lacksList.add(lack);
            sendPurchaserAlert(lack, user);
        } else
            return;
    }

    protected void setLackID(Lack lack, User user) {

        lack.setLackID(startId++);
    }

    protected void setForwarderSkypeID(Lack lack, User user) {
        if (checkIfForwarder(user)) {
            lack.setForwarderSkypeID(user.getSkypeID());
        }
    }

    protected void setLacksSetDateAndTime(Lack lack, User user) {
        if (checkIfForwarder(user)) {
            lack.setLacksDateAndTime(new SimpleDateFormat("yyyy-MM-dd, HH:mm ").format(new Date()));
        }
    }

    protected void openStatus(Lack lack, User user) {
        if (checkIfForwarder(user)) {
            lack.setStatus(true);
        }
    }

    protected void setDefaultOrderedAmount(Lack lack, User user) {
        if (checkIfForwarder(user)) {
            lack.setOrderedAmount(0);
        }
    }

    protected void setDefaultExpectedDeliveryDateAndTime(Lack lack, User user) {
        if (checkIfForwarder(user)) {
            lack.setExpectedDeliveryDateAndTime(lack.getLacksDateAndTime());
        }
    }

    protected void setDefaultPurchaserAdditionalComment(Lack lack, User user) {
        if (checkIfForwarder(user)) {
            lack.setPurchaserAdditionalComment(" ");
        }
    }

    protected void sendPurchaserAlert(Lack lack, User user) {
        if (checkIfForwarder(user)) {
            System.out.println("Sending Alert to " + lack.getSupplier().user.getSkypeID());
        }
    }

    protected void sendForwarderAlert(Lack lack, User user) {
        if (user.getRole() == Role.PURCHASER) {
            if ((lack.getOrderedAmount() != 0) && (lack.getExpectedDeliveryDateAndTime() != lack.getLacksDateAndTime()) && (lack.getPurchaserAdditionalComment() != " ")) {
                System.out.println("Sending Alert to" + lack.getForwarderSkypeID());
            }
        } else
            System.out.println("no authorization to send alerts to forwarder.");
    }
}