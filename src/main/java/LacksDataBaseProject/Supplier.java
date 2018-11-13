package LacksDataBaseProject;

import java.util.ArrayList;
import java.util.List;

public class Supplier {
    protected String supplierName;
    protected int supplierID;
    protected User user;

    protected List<Supplier> listOfSuppliers = new ArrayList<>();

    public Supplier() {
    }

    public void setSupplierID(int supplierID) {
        this.supplierID = supplierID;
    }

    public int getSupplierID() {
        return supplierID;
    }

    public void setSupplierName(String supplierName) {
        this.supplierName = supplierName;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public User getUser() { return user; }

    @Override
    public String toString() {
        return "Supplier{" +
                "supplierName='" + supplierName + '\'' +
                ", supplierID=" + supplierID +
                ", user=" + user +
                '}';
    }
}
