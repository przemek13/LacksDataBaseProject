package LacksDataBaseProject;

public class Lack extends Item {

    public Lack() {
    }

    private Item item;
    private int requiredAmount;
    private String unitOfMeasure;
    private String forwarderAdditionalComment;
    private Supplier supplier = new Supplier();
    // te pole powinno być wrzucone od razu w metodzie addLack, a nie osobno w choosesSupplier
    // wartość przypisana tylko na potrzeby sprawdzenia
    private int lackID;
    private String forwarderSkypeID;
    private String lacksDateAndTime; //zmieniłem na String
    private Boolean status;
    private int orderedAmount;
    private String expectedDeliveryDateAndTime; //zmieniłem na String
    private String purchaserAdditionalComment;

    protected Supplier getSupplier() {
        return supplier;
    }

    protected void setLackID(int lackID) {
        this.lackID = lackID;
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
                "forwarderSkypeID='" + forwarderSkypeID + '\'' +
                ", lacksDateAndTime='" + lacksDateAndTime + '\'' +
                ", status=" + status +
                ", lackID=" + lackID +
                '}';
    }
}
