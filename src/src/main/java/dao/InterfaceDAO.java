package dao;

import java.util.List;

public interface InterfaceDAO<T> {
    void add(T item);

    List<T> getAll();
}
