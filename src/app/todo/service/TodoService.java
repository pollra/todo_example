package app.todo.service;

import app.storage.MemoryService;
import app.todo.domain.Todo;
import app.todo.exception.InvalidParameterException;
import app.todo.form.TodoForm.Request;
import app.todo.form.TodoForm.Response.FindAll;
import app.todo.repository.StorageRepository;

import java.util.Collection;

/**
 * @author pollra
 * @description
 * @since 2020.03.14
 **********************************************************************************************************************/
public class TodoService {

    private StorageRepository<Todo> repository;

    public TodoService(MemoryService repository) {
        this.repository = repository;
    }

    public Collection<FindAll> list() {
        return Todo.toListFindAll(repository.list());
    }

    public Todo find(Request.find form) throws InvalidParameterException {
        form.validate();
        return repository.find(form.getId());
    }

    public Integer write(Request.Add form) throws InvalidParameterException {
        form.validate();
        final Todo todo = new Todo(form.getTitle(), form.getContent());
        return repository.write(todo);
    }

    public Integer modify(Request.Modify form) throws InvalidParameterException {
        form.validate();
        final Todo todo = repository.find(form.getId());
        todo.update(new Todo(form.getTitle(), form.getContent()));
        return repository.modify(todo);
    }

    public void remove(Request.Remove form) throws InvalidParameterException {
        form.validate();
        repository.remove(form.getId());
    }
}
