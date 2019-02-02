package LacksDataBaseProject;

public class SuppliersLocalRepository extends LocalRepository<Supplier> {
    @Override
    public String getRepositoryName() {
        return "Supplier's local repository";
    }
}
