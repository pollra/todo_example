package app.storage;

import app.todo.domain.Todo;
import app.todo.repository.StorageRepository;

import java.util.ArrayList;
import java.util.List;

/**
 * @author pollra
 * @description
 * @since 2020.03.14
 **********************************************************************************************************************/
public class MemoryRepository<T> implements StorageRepository<Todo> {

    @Override
    public List<Todo> list() {
        return new ArrayList<>();
    }

    @Override
    public Integer write(Todo todo) {
        return 1;
    }

    @Override
    public Integer modify(Todo todo) {
        return 1;
    }

    @Override
    public void remove(Integer id) {
        System.out.println("삭제됨 ㅅㄱ");
    }

    @Override
    public Todo find(Integer integer) {
        return new Todo.Builder("title", "content").build();
    }
}
