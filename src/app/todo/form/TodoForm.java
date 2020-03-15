package app.todo.form;

import app.todo.domain.Todo;
import app.todo.exception.InvalidParameterException;

import java.time.LocalDateTime;
import java.util.Objects;

/**
 * @since       2020.03.14
 * @author      pollra
 * @description todoForm
 **********************************************************************************************************************/
public class TodoForm {
    public static class Request {
        public static class find {
            private Integer id;

            public Integer getId() {
                return id;
            }

            public void setId(Integer id) {
                this.id = id;
            }

            public void validate() throws InvalidParameterException {
                try{
                    Objects.requireNonNull(id);
                } catch(NullPointerException e) {
                    throw new InvalidParameterException("찾을 수 없는 값입니다");
                }
            }
        }
        public static class Add {

            private String title;
            private String content;

            public String getTitle() {
                return title;
            }

            public String getContent() {
                return content;
            }

            public void setTitle(String title) {
                this.title = title;
            }

            public void setContent(String content) {
                this.content = content;
            }

            public void validate() throws InvalidParameterException {
                try{
                    Objects.requireNonNull(title);
                    Objects.requireNonNull(content);
                } catch(NullPointerException e){
                    throw new InvalidParameterException("입력된 값을 다시 확인해 주세요");
                }
            }
        }

        public static class Modify {
            private Integer id;
            private String title;
            private String content;

            public Integer getId() {
                return id;
            }

            public String getTitle() {
                return title;
            }

            public String getContent() {
                return content;
            }

            public void setId(Integer id) {
                this.id = id;
            }

            public void setTitle(String title) {
                this.title = title;
            }

            public void setContent(String content) {
                this.content = content;
            }

            public void validate() throws InvalidParameterException{
                try {
                    Objects.requireNonNull(id);
                    Objects.requireNonNull(title);
                    Objects.requireNonNull(content);
                } catch(NullPointerException e) {
                    throw new InvalidParameterException("데이터를 확인할 수 없습니다");
                }
            }
        }

        public static class Remove {
            private Integer id;

            public Integer getId() {
                return id;
            }

            public void setId(Integer id) {
                this.id = id;
            }

            public void validate() throws InvalidParameterException {
                try {
                    Objects.requireNonNull(id);
                } catch (NullPointerException e) {
                    throw new InvalidParameterException("id 값을 확인할 수 없습니다");
                }
            }
        }
    }

    public static class Response {

        public static class FindAll {

            private Integer id;
            private String title;
            private String content;
            private LocalDateTime created_at;

            public FindAll(Todo todo) {
                this.id = todo.getId();
                this.title = todo.getTitle();
                this.content = todo.getContent();
                this.created_at = todo.getCreated_at();
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

            public void setId(Integer id) {
                this.id = id;
            }

            public void setTitle(String title) {
                this.title = title;
            }

            public void setContent(String content) {
                this.content = content;
            }

            public void setCreated_at(LocalDateTime created_at) {
                this.created_at = created_at;
            }

        }
    }
}
