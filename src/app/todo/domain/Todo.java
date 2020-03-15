package app.todo.domain;

import app.todo.form.TodoForm.Response;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collection;

/**
 * @since       2020.03.14
 * @author      pollra
 * @description todoEntity
 **********************************************************************************************************************/
public class Todo {

    private Integer id;
    private String title;
    private String content;
    private LocalDateTime created_at;

    public Todo(String title, String content) {
        this.title = title;
        this.content = content;
        this.created_at = LocalDateTime.now();
    }

    public Todo(Integer id, String title, String content) {
        this.id = id;
        this.title = title;
        this.content = content;
    }

    public Integer getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getContent() {
        return content;
    }

    public LocalDateTime getCreated_at() {
        return created_at;
    }

    public void update(Todo todo) {
        this.title = todo.getTitle();
        this.content = todo.getContent();
    }

    public static Collection<Response.FindAll> toListFindAll (Collection<Todo> todoList) {
        Collection<Response.FindAll> findAlls = new ArrayList<>();
        for (Todo todo : todoList){
            findAlls.add(new Response.FindAll(todo));
        }
        return findAlls;
    }

    @Override
    public String toString() {
        return "Todo{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", content='" + content + '\'' +
                ", created_at=" + created_at +
                '}';
    }
}
