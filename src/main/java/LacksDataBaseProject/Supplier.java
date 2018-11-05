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

    public Supplier(String supplierName, User user) {
        this.supplierName = supplierName;
        this.user = user;
        supplierID = ++supplierID;
    }

    public int getSupplierID() {
        return supplierID;
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
