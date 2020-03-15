package app.storage;

import app.storage.exception.SqlDataNotFoundException;
import app.storage.exception.SqlException;
import app.storage.exception.SqlExistingKeyException;
import app.todo.domain.Todo;

import java.util.*;

/**
 * @author pollra
 * @description
 * @since 2020.03.14
 **********************************************************************************************************************/
public class Storage {

    private Map<Integer, Todo> todoStorage;

    public Storage() {
        this.todoStorage = new LinkedHashMap<>();
    }

    public Integer saveQuery(Todo todo) throws SqlException {
        if(Objects.nonNull(todoStorage.get(todo.getId())))
            throw new SqlExistingKeyException("해당 키를 가진 데이터가 이미 존재합니다");
        todoStorage.put(todo.getId(), todo);
        return todo.getId();
    }

    public Todo findQuery(Integer id) throws SqlException {
        Todo queryResult = todoStorage.get(id);
        if(Objects.isNull(queryResult))
            throw new SqlDataNotFoundException("해당 키의 데이터가 존재하지 않습니다");
        return queryResult;
    }

    public Boolean deleteQuery(Integer id) throws SqlException{
        Todo queryResult = todoStorage.get(id);
        if(queryResult == null)
            throw new SqlDataNotFoundException("해당 키의 데이터가 존재하지 않습니다");
        return todoStorage.remove(id) != null;
    }
}
