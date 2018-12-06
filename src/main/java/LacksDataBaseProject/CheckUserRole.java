package LacksDataBaseProject;

import LacksDataBaseProject.Exceptions.AdminAccessException;
import LacksDataBaseProject.Exceptions.ForwarderAccessException;
import LacksDataBaseProject.Exceptions.PurchaserAccessException;

public interface CheckUserRole {
    boolean checkUserRole(User user) throws ForwarderAccessException, AdminAccessException, PurchaserAccessException;
}
