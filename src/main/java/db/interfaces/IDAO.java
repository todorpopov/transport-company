package db.interfaces;

import java.util.List;

public interface IDAO<T> {
    void save(T entity);

    T getById(Long id);

    List<T> getAll();

    void update(T entity);

    void deleteById(Long id);
}
