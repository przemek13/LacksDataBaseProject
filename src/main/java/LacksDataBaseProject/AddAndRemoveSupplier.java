package LacksDataBaseProject;

import LacksDataBaseProject.Exceptions.AdminAccessException;

public class AddAndRemoveSupplier implements SuppliersServiceAPI {

    private final CRUDRepository<Supplier> crudRepository;

    public AddAndRemoveSupplier(CRUDRepository<Supplier> crudRepository) {
        this.crudRepository = crudRepository;
    }

    @Override
    public boolean checkUserRole(User user) throws AdminAccessException {
        if (user.getRole() == Role.ADMIN) {
            return true;
        } else
            throw new AdminAccessException("No authorization. Only Admin allowed to modify this data. ");
    }

    @Override
    public void addSupplier(User user, Supplier supplier) throws AdminAccessException {
        if (checkUserRole(user)) {
            crudRepository.add(supplier);
        }
    }

    @Override
    public void removeSupplier(User user, Supplier supplier) throws AdminAccessException {
        if (checkUserRole(user)) {
            crudRepository.delete(supplier);
        }
    }

    @Override
    public void showSuppliers() {
        for (Supplier supplier : crudRepository.getList()) {
            System.out.println(supplier);
        }
    }
}

