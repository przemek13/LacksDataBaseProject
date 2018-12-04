package LacksDataBaseProject;

import java.util.List;

public interface CRUDRepository <T extends Object> {
    void add(T t);
    void delete(T t);
    List<T> getList();
}
