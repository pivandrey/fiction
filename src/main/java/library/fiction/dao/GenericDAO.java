package library.fiction.dao;

import java.util.List;

public interface GenericDAO<T> {

    public void save(T obj);
    public void update(T obj);
    public void delete(T obj);
    public T findById(long id);
    public List<T> getAll(String query);
}
