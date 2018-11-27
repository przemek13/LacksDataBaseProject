package LacksDataBaseProject;

import LacksDataBaseProject.Exceptions.*;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class LacksOperations extends CheckUserRole {

    protected final List<Lack> lacksList;

    public LacksOperations () {
        this.lacksList = new ArrayList<>();
    };

    private int startId=1;

    protected void createMissingLackData(Lack lack, User user) throws ZeroDataException, WrongDateFormatException, LessThanZeroException, ForwarderAccessException, UserLackException {
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
            //sendForwarderAlert(lack, user);
        }
    }
    protected boolean checkUser (User user) throws ForwarderAccessException {
        if (checkIfForwarder(user)) {
            return true;
        }
        else
            throw new ForwarderAccessException("No authorization. Only Forwarders allowed to modify this data. ");
    }

    protected void setLackID(Lack lack) throws ZeroDataException {
        lack.setLackID(startId++);
    }

    protected void setForwarderSkypeID(Lack lack, User user) throws ForwarderAccessException {
        checkUser(user);
        lack.setForwarderSkypeID(user.getSkypeID());
    }

    protected void setLacksSetDateAndTime(Lack lack, User user) throws WrongDateFormatException, ForwarderAccessException {
        checkUser(user);
        lack.setLacksDateAndTime(new SimpleDateFormat("yyyy-MM-dd HH:mm").format(new Date()));
    }

    protected void openStatus(Lack lack, User user) throws ForwarderAccessException {
        checkUser(user);
        lack.setStatus(true);
    }

    protected void setDefaultOrderedAmount(Lack lack, User user) throws LessThanZeroException, ForwarderAccessException {
        checkUser(user);
        lack.setOrderedAmount(0);
    }

    protected void setDefaultExpectedDeliveryDateAndTime(Lack lack, User user) throws WrongDateFormatException, ForwarderAccessException {
        checkUser(user);
        lack.setExpectedDeliveryDateAndTime(null);
    }

    protected void setDefaultPurchaserAdditionalComment(Lack lack, User user) throws ForwarderAccessException {
        checkUser(user);
        lack.setPurchaserAdditionalComment(null);
    }

    protected String sendPurchaserAlert(Lack lack, User user) throws ForwarderAccessException, UserLackException {
        checkUser(user);
        if (lack.getSupplier().getUser() != null) {
            return "Sending Alert to " + lack.getSupplier().getUser().getUserName();
        }
        else throw new UserLackException("No Purchaser assigned to this Supplier");
    }

    //! przenieść metodę do klasy SetLack - to tam powinien być wywoływany alert dla Forwardera
    protected void sendForwarderAlert(Lack lack, User user) throws ForwarderAccessException {
        checkUser(user);
        if ((lack.getOrderedAmount() != 0) && (lack.getExpectedDeliveryDateAndTime() != lack.getLacksDateAndTime()) && (lack.getPurchaserAdditionalComment() != null)) {
            System.out.println("Sending Alert to " + lack.getForwarderSkypeID());
        }
    }

    public List<Lack> getLacksList() {
        return lacksList;
    }
}