package app.todo.repository;

import java.util.Collection;

/**
 * @author pollra
 * @description
 * @since 2020.03.14
 **********************************************************************************************************************/
public interface StorageRepository<Type> {
    Type    find  (Integer id);
    Collection<Type> list();

    Integer write (Type type);
    Integer modify(Type type);
    void    remove(Integer id);
}
