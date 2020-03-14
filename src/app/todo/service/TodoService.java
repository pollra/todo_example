package app.todo.service;

import app.storage.MemoryRepository;
import app.todo.domain.Todo;
import app.todo.exception.DataNotFoundException;
import app.todo.exception.InvalidParameterException;
import app.todo.form.TodoForm.Response;
import app.todo.form.TodoForm.Request;
import app.todo.repository.StorageRepository;

import java.util.Collection;
import java.util.List;
import java.util.stream.Stream;

/**
 * @author pollra
 * @description
 * @since 2020.03.14
 **********************************************************************************************************************/
public class TodoService {

    private StorageRepository repository;

    public TodoService(StorageRepository<Todo> repository) {
        this.repository = repository;
    }

    public Collection<Response.FindAll> list() {
        return(Collection<Response.FindAll>) repository.list();
    }

    public Todo find(Request.find form) throws InvalidParameterException {
        form.validate();
        final Todo todo = (Todo) repository.find(form.getId());
        return todo;
    }

    public Integer write(Request.Add form) throws InvalidParameterException {
        form.validate();
        final Todo todo = new Todo
                .Builder(form.getTitle(), form.getContent())
                .build();
        return repository.write(todo);
    }

    public Integer modify(Request.Modify form) throws InvalidParameterException {
        form.validate();
        final Todo todo = (Todo) repository.find(form.getId());
        todo.update(new Todo.Builder(form.getTitle(), form.getContent()).build());
        return repository.modify(todo);
    }

    public void remove(Request.Remove form) throws InvalidParameterException {
        form.validate();
        repository.remove(form.getId());
    }
}
