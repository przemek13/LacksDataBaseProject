package LacksDataBaseProject;

public class Supplier {
    protected String supplierID;
    protected String supplierName;
    protected User user;

    public static final Supplier NULL_SUPPLIER = new Supplier("not found");

    public Supplier(String supplierID, String supplierName, User user) {
        this.supplierID = supplierID;
        this.supplierName = supplierName;
        this.user = user;
    }

    public Supplier(String supplierName) {
        this.supplierName = supplierName;
    }

    public String getSupplierID() {
        return supplierID;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public User getUser() {
        return user;
    }

    @Override
    public String toString() {
        return "Supplier{" +
                "supplierName='" + supplierName + '\'' +
                ", supplierID=" + supplierID +
                ", user=" + user +
                '}';
    }
}
