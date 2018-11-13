package LacksDataBaseProject;

public class Item {
    private String itemID;
    private String itemName;

    public Item() {
    }


    public void setItemID(String itemID) {
        this.itemID = itemID;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    @Override
    public String toString() {
        return "Item{" +
                "itemID='" + itemID + '\'' +
                ", itemName='" + itemName + '\'' +
                '}';
    }
}
