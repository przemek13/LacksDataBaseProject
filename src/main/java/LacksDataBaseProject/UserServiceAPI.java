package LacksDataBaseProject;

import LacksDataBaseProject.Exceptions.AdminAccessException;

public interface UserServiceAPI extends CheckUserRole {
    void addUser (User addingUser, User addedUser) throws AdminAccessException;
    void removeUser (User removingUser, User removedUser) throws AdminAccessException;
    void showServiceUser();
    @Override
    boolean checkUserRole(User user) throws AdminAccessException;
}
