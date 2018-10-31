package LacksDataBaseProject;

import java.util.ArrayList;
import java.util.List;

public class Supplier {
    private String supplierName;
    private int supplierID;

    static List<User> listOfSuppliers = new ArrayList<>();

    public Supplier(String supplierName, int supplierID) {
        this.supplierName = supplierName;
        this.supplierID = supplierID;
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

    public static List<User> getListOfSuppliers() {
        return listOfSuppliers;
    }

    public static void setListOfSuppliers(List<User> listOfSuppliers) {
        Supplier.listOfSuppliers = listOfSuppliers;
    }
}
