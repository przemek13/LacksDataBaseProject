package LacksDataBaseProject;

import java.util.ArrayList;
import java.util.List;

public class Supplier {
    private String supplierName;
    private int supplierID;
    private User user;

    static List<Supplier> listOfSuppliers = new ArrayList<>();

    public Supplier() {
    }

    public Supplier(String supplierName, User user) {
        this.supplierName = supplierName;
        this.user = user;
        supplierID = ++supplierID;
    }

    public String getSupplierName() {
        return supplierName;
    }

    public void setSupplierName(String supplierName) {
        this.supplierName = supplierName;
    }

    public int getSupplierID() {
        return supplierID;
    }

    public void setSupplierID(int supplierID) {
        this.supplierID = supplierID;
    }

    public static List<Supplier> getListOfSuppliers() {
        return listOfSuppliers;
    }

    public static void setListOfSuppliers(List<Supplier> listOfSuppliers) {
        Supplier.listOfSuppliers = listOfSuppliers;
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
