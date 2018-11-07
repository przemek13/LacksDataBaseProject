package LacksDataBaseProject;

public interface CheckUser {
    boolean checkIfAdmin(User user);
    boolean checkIfForwarder(User user);
    boolean checkIfPurcharser(User user);

}
