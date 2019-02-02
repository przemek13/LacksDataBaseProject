package LacksDataBaseProject;

public class UsersLocalRepository extends LocalRepository<User> {
    @Override
    public String getRepositoryName() {
        return "User's local repository";
    }
}
