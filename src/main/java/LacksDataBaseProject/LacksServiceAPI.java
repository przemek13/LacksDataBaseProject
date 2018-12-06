package LacksDataBaseProject;

import LacksDataBaseProject.Exceptions.*;

public interface LacksServiceAPI extends CheckUserRole {
    void addLack(User user, Lack lack, LacksOperations lacksOperations) throws AdminAccessException, ZeroDataException, WrongDateFormatException, LessThanZeroException, ForwarderAccessException, UserLackException;

    void removeLack(User user, Lack lack) throws AdminAccessException, ForwarderAccessException;

    void showLacks();

    void changeStatus(User user, Lack lack) throws ForwarderAccessException;

    @Override
    boolean checkUserRole(User user) throws AdminAccessException, ForwarderAccessException;
}
