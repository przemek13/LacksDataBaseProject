package LacksDataBaseProject;

import LacksDataBaseProject.Exceptions.AdminAccessException;

public interface SuppliersServiceAPI extends CheckUserRole {
    void addSupplier(User user, Supplier supplier) throws AdminAccessException;

    void removeSupplier(User user, Supplier supplier) throws AdminAccessException;

    void showSuppliers();

    @Override
    boolean checkUserRole(User user) throws AdminAccessException;
}

