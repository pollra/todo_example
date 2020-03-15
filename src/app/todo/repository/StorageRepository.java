package app.todo.repository;

import app.todo.domain.Todo;

import java.util.Collection;

/**
 * @author pollra
 * @description
 * @since 2020.03.14
 **********************************************************************************************************************/
public interface StorageRepository<T> {
    T    find  (Integer id);
    Collection<T> list();

    Integer write (T todo);
    Integer modify(T todo);
    void    remove(Integer id);
}
