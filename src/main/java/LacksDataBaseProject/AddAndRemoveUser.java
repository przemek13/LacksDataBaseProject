package LacksDataBaseProject;

import LacksDataBaseProject.Exceptions.AdminAccessException;

import java.io.PrintStream;

public class AddAndRemoveUser implements UserServiceAPI {

    protected CRUDRepository<User> crudRepository;
    private PrintStream out;

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
            System.out.println(addedUser + " was added to the database.");
        }
    }

    @Override
    public void removeUser(User removingUser, User removedUser) throws AdminAccessException {
        if (checkUserRole(removingUser)) {
            crudRepository.delete(removedUser);
            System.out.println(removedUser + " was removed from the data base.");
        }
    }

    @Override
    public void showServiceUser() {
        for (User user : crudRepository.getList()) {
            System.out.println(user);
        }
    }
}


