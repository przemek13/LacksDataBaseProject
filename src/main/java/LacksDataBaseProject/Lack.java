package LacksDataBaseProject;

import LacksDataBaseProject.Exceptions.LessThanZeroException;
import LacksDataBaseProject.Exceptions.WrongDateFormatException;
import LacksDataBaseProject.Exceptions.ZeroDataException;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Lack extends Item {

    private Item item;
    private int requiredAmount;
    private String unitOfMeasure;
    private String forwarderAdditionalComment;
    private Supplier supplier;
    private int lackID;
    private String forwarderSkypeID;
    private String lacksDateAndTime;
    private Boolean status;
    private int orderedAmount;
    private String expectedDeliveryDateAndTime;
    private String purchaserAdditionalComment;

    public Lack(String itemID, String itemName, int requiredAmount, String unitOfMeasure, String forwarderAdditionalComment, Supplier supplier, int lackID, String forwarderSkypeID, String lacksDateAndTime, Boolean status, int orderedAmount, String expectedDeliveryDateAndTime, String purchaserAdditionalComment) {
        super(itemID, itemName);
        this.item = new Item(itemID, itemName);
        this.requiredAmount = requiredAmount;
        this.unitOfMeasure = unitOfMeasure;
        this.forwarderAdditionalComment = forwarderAdditionalComment;
        this.supplier = supplier;
        this.lackID = lackID;
        this.forwarderSkypeID = forwarderSkypeID;
        this.lacksDateAndTime = lacksDateAndTime;
        this.status = status;
        this.orderedAmount = orderedAmount;
        this.expectedDeliveryDateAndTime = expectedDeliveryDateAndTime;
        this.purchaserAdditionalComment = purchaserAdditionalComment;
    }

    protected void setRequiredAmount(int requiredAmount) throws ZeroDataException {
        if (requiredAmount <= 0) {
            throw new ZeroDataException("requiredAmount can't be empty or less than 0");
        } else {
            this.requiredAmount = requiredAmount;
        }
    }

    public int getRequiredAmount() {
        return requiredAmount;
    }

    protected void setUnitOfMeasure(String unitOfMeasure) {
        if (unitOfMeasure == null || unitOfMeasure.isEmpty()) {
            throw new NullPointerException("unitOfMeasure can't be empty");
        } else {
            this.unitOfMeasure = unitOfMeasure;
        }
    }

    public String getUnitOfMeasure() {
        return unitOfMeasure;
    }

    protected void setForwarderAdditionalComment(String forwarderAdditionalComment) {
            this.forwarderAdditionalComment = forwarderAdditionalComment;
    }

    public String getForwarderAdditionalComment() {
        return forwarderAdditionalComment;
    }

    protected void setSupplier(Supplier supplier) {
        if (supplier == null) {
            throw new NullPointerException("supplier can't be empty");
        } else {
            this.supplier = supplier;
        }
    }

    protected Supplier getSupplier() {
        return supplier;
    }

    protected void setLackID(int lackID) throws ZeroDataException {
        if (lackID <= 0) {
            throw new ZeroDataException("lackID can't be empty or less than 0");
        } else {

            this.lackID = lackID;
        }
    }

    public int getLackID() {
        return lackID;
    }

    protected void setForwarderSkypeID(String forwarderSkypeID) {
        if (forwarderSkypeID == null || forwarderSkypeID.isEmpty()) {
            throw new NullPointerException("forwarderSkypeID can't be empty");
        } else {
            this.forwarderSkypeID = forwarderSkypeID;
        }
    }

    protected String getForwarderSkypeID() {
        return forwarderSkypeID;
    }

    protected void setLacksDateAndTime(String lacksDateAndTime) throws WrongDateFormatException {
        if (lacksDateAndTime == null || lacksDateAndTime.isEmpty()) {
            throw new NullPointerException("LacksDateAndTime can't be empty");
        }
        Pattern pattern = Pattern.compile("\\d{4}-\\d{2}-\\d{2}\\s\\d{2}:\\d{2}");
        Matcher matcher = pattern.matcher(lacksDateAndTime);
        if (!matcher.matches()) {
            throw new WrongDateFormatException("wrong date and time format");
        } else {
            this.lacksDateAndTime = lacksDateAndTime;
        }
    }

    protected String getLacksDateAndTime() {
        return lacksDateAndTime;
    }

    protected void setStatus(Boolean status) {
        if (status == null) {
            throw new NullPointerException("status can't be empty");
        } else {
            this.status = status;
        }
    }

    public Boolean getStatus() {
        return status;
    }

    protected void setOrderedAmount(int orderedAmount) throws LessThanZeroException {
        if (orderedAmount < 0) {
            throw new LessThanZeroException("orderedAmount can't be less than 0");
        } else {
            this.orderedAmount = orderedAmount;
        }
    }

    protected int getOrderedAmount() {
        return orderedAmount;
    }

    protected void setExpectedDeliveryDateAndTime(String expectedDeliveryDateAndTime) throws WrongDateFormatException {
        if (expectedDeliveryDateAndTime.isEmpty()) {
            throw new NullPointerException("ExpectedDeliveryDateAndTime can't be empty");
        }
        Pattern pattern = Pattern.compile("\\d{4}-\\d{2}-\\d{2}\\s\\d{2}:\\d{2}");
        Matcher matcher = pattern.matcher(expectedDeliveryDateAndTime);
        if (!matcher.matches()) {
            throw new WrongDateFormatException("wrong date and time format");
        } else {
            this.expectedDeliveryDateAndTime = expectedDeliveryDateAndTime;
        }
    }

    protected String getExpectedDeliveryDateAndTime() {
        return expectedDeliveryDateAndTime;
    }

    protected void setPurchaserAdditionalComment(String purchaserAdditionalComment) {
        this.purchaserAdditionalComment = purchaserAdditionalComment;
    }

    protected String getPurchaserAdditionalComment() {
        return purchaserAdditionalComment;
    }

    @Override
    public String toString() {
        return "Lack{" +
                "item=" + item +
                ", requiredAmount=" + requiredAmount +
                ", unitOfMeasure='" + unitOfMeasure + '\'' +
                ", forwarderAdditionalComment='" + forwarderAdditionalComment + '\'' +
                ", supplier=" + supplier +
                ", lackID=" + lackID +
                ", forwarderSkypeID='" + forwarderSkypeID + '\'' +
                ", lacksDateAndTime='" + lacksDateAndTime + '\'' +
                ", status=" + status +
                ", orderedAmount=" + orderedAmount +
                ", expectedDeliveryDateAndTime='" + expectedDeliveryDateAndTime + '\'' +
                ", purchaserAdditionalComment='" + purchaserAdditionalComment + '\'' +
                '}';
    }
}