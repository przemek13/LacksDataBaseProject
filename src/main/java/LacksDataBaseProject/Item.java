package LacksDataBaseProject;

public class Item {
    protected String itemID;
    protected String itemName;

    Item(String itemID, String itemName) {
        if (itemID == null || itemID.isEmpty()) {
            throw new NullPointerException("itemID can't be empty");
        } else {
            this.itemID = itemID;
        }
        if (itemName == null || itemName.isEmpty()) {
            throw new NullPointerException("itemName can't be empty");
        }
        this.itemName = itemName;
    }

    public void setItemID(String itemID) {
        if (itemID == null || itemID.isEmpty()) {
            throw new NullPointerException("itemID can't be empty");
        } else {
            this.itemID = itemID;
        }
    }

    public String getItemID() {
        return itemID;
    }

    public void setItemName(String itemName) {
        if (itemName == null || itemName.isEmpty()) {
            throw new NullPointerException("itemName can't be empty");
        } else {
            this.itemName = itemName;
        }
    }

    public String getItemName() {
        return itemName;
    }

    @Override
    public String toString() {
        return "Item{" +
                "itemID='" + itemID + '\'' +
                ", itemName='" + itemName + '\'' +
                '}';
    }
}