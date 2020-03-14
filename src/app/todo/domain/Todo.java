package app.todo.domain;

import java.time.LocalDateTime;

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

    private Todo(Builder builder) {
        this.title = builder.title;
        this.content = builder.content;
        this.created_at = builder.created_at;
    }

    public static class Builder {
        private final String title;
        private final String content;

        private Integer id = 0;
        private LocalDateTime created_at = LocalDateTime.now();

        public Builder(String title, String content) {
            this.title = title;
            this.content = content;
        }

        public Builder id(Integer id) {
            this.id = id;
            return this;
        }

        public Builder content(LocalDateTime created_at) {
            this.created_at = created_at;
            return this;
        }

        public Todo build(){
            return new Todo(this);
        }
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
        this.id = todo.getId();
        this.title = todo.getTitle();
        this.content = todo.getContent();
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
