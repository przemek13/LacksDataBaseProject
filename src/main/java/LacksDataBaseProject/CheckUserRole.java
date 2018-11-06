package LacksDataBaseProject;

public abstract class  CheckUserRole implements CheckUser {

    @Override
    public boolean checkIfAdmin(User user) {
        boolean userAdmin = true;
        if (user.getRole() != Role.ADMIN) {
            System.out.println("no authorization..");
            userAdmin = false;
        }
        return userAdmin;
    }

    @Override
    public boolean checkIfForwarder(User user) {
        boolean userForwarder = true;
        if (user.getRole() != Role.FORWARDER) {
            System.out.println("no authorization..");
            userForwarder = false;
        }
        return userForwarder;
    }

    @Override
    public boolean checkIfPurcharser(User user) {
        boolean userPurchaser = true;
        if (user.getRole() != Role.PURCHASER) {
            System.out.println("no authorization..");
            userPurchaser = false;
        }
        return userPurchaser;
    }
}

