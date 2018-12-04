package LacksDataBaseProject;

import java.util.ArrayList;
import java.util.List;

public abstract class LocalRepository<T extends Object> implements CRUDRepository <T> {

    private List<T> list = new ArrayList<>();

    @Override
    public void add(T t) {
        System.out.println(String.format("Add %s in: %s", t, getRepositoryName()));
        list.add(t);
    }
    @Override
    public void delete(T t) {
        System.out.println(String.format("Delete %s in: %s", t, getRepositoryName()));
        list.remove(t);
    }
    @Override
    public List<T> getList() {
        System.out.println(String.format("Get list in: %s", getRepositoryName()));
        return list;
    }

    public abstract String getRepositoryName();
}
