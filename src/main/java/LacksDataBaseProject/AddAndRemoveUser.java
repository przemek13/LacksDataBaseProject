package LacksDataBaseProject;

import LacksDataBaseProject.Exceptions.AdminAccessException;

public class AddAndRemoveUser implements UsersServiceAPI {

    private final CRUDRepository<User> crudRepository;

    public AddAndRemoveUser(CRUDRepository<User> crudRepository) {
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
    public void addUser(User addingUser, User addedUser) throws AdminAccessException {
        if (checkUserRole(addingUser)) {
            crudRepository.add(addedUser);
        }
    }

    @Override
    public void removeUser(User removingUser, User removedUser) throws AdminAccessException {
        if (checkUserRole(removingUser)) {
            crudRepository.delete(removedUser);
        }
    }

    @Override
    public void showUsers() {
        for (User user : crudRepository.getList()) {
            System.out.println(user);
        }
    }
}


