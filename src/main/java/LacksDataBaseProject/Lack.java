package LacksDataBaseProject;

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

    public Lack(String itemId, String itemName, Item item, int requiredAmount, String unitOfMeasure, String forwarderAdditionalComment, Supplier supplier, int lackID, String forwarderSkypeID, String lacksDateAndTime, Boolean status, int orderedAmount, String expectedDeliveryDateAndTime, String purchaserAdditionalComment) {
        super(itemId, itemName);
        this.item = item;
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

    protected void setRequiredAmount(int requiredAmount) {
        this.requiredAmount = requiredAmount;
    }

    protected void setUnitOfMeasure(String unitOfMeasure) {
        this.unitOfMeasure = unitOfMeasure;
    }

    protected void setForwarderAdditionalComment(String forwarderAdditionalComment) {
        this.forwarderAdditionalComment = forwarderAdditionalComment;
    }

    protected Supplier getSupplier() {
        return supplier;
    }

    protected void setSupplier(Supplier supplier) {
        this.supplier = supplier;
    }

    protected void setLackID(int lackID) {
        this.lackID = lackID;
    }

    public int getLackID() {
        return lackID;
    }

    protected String getForwarderSkypeID() {
        return forwarderSkypeID;
    }

    protected void setForwarderSkypeID(String forwarderSkypeID) {
        this.forwarderSkypeID = forwarderSkypeID;
    }

    protected String getLacksDateAndTime() {
        return lacksDateAndTime;
    }

    protected void setLacksDateAndTime(String lacksDateAndTime) {
        this.lacksDateAndTime = lacksDateAndTime;
    }

    protected void setStatus(Boolean status) {
        this.status = status;
    }

    protected int getOrderedAmount() {
        return orderedAmount;
    }

    protected void setOrderedAmount(int orderedAmount) {
        this.orderedAmount = orderedAmount;
    }

    protected String getExpectedDeliveryDateAndTime() {
        return expectedDeliveryDateAndTime;
    }

    protected void setExpectedDeliveryDateAndTime(String expectedDeliveryDateAndTime) {
        this.expectedDeliveryDateAndTime = expectedDeliveryDateAndTime;
    }

    protected String getPurchaserAdditionalComment() {
        return purchaserAdditionalComment;
    }

    protected void setPurchaserAdditionalComment(String purchaserAdditionalComment) {
        this.purchaserAdditionalComment = purchaserAdditionalComment;
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