package LacksDataBaseProject;

import LacksDataBaseProject.Exceptions.AdminAccessException;

public interface UsersServiceAPI extends CheckUserRole {
    void addUser(User addingUser, User addedUser) throws AdminAccessException;

    void removeUser(User removingUser, User removedUser) throws AdminAccessException;

    void showUsers();

    @Override
    boolean checkUserRole(User user) throws AdminAccessException;
}
