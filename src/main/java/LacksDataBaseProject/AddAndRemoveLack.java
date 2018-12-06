package LacksDataBaseProject;

import LacksDataBaseProject.Exceptions.*;

public class AddAndRemoveLack implements LacksServiceAPI {

    private final CRUDRepository<Lack> crudRepository;

    public AddAndRemoveLack(CRUDRepository<Lack> crudRepository) {
        this.crudRepository = crudRepository;
    }

    @Override
    public boolean checkUserRole(User user) throws ForwarderAccessException {
        if (user.getRole() == Role.FORWARDER) {
            return true;
        } else
            throw new ForwarderAccessException("No authorization. Only Forwarders allowed to modify this data. ");
    }

    @Override
    public void addLack(User user, Lack lack, LacksOperations lacksOperations) throws ZeroDataException, WrongDateFormatException, LessThanZeroException, ForwarderAccessException, UserLackException {
        if (checkUserRole(user)) {
            lacksOperations.createMissingLackData(lack, user);
            crudRepository.add(lack);
        }
    }

    @Override
    public void removeLack(User user, Lack lack) throws ForwarderAccessException {
        if (checkUserRole(user)) {
            crudRepository.add(lack);
        }
    }

    @Override
    public void changeStatus(User user, Lack lack) throws ForwarderAccessException {
        if (checkUserRole(user)) {
            lack.setStatus(false);
        }
    }

    @Override
    public void showLacks() {
        for (Lack lack : crudRepository.getList()) {
            System.out.println(lack);
        }
    }
}
