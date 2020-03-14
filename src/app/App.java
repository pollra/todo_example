package app;

import app.storage.MemoryRepository;
import app.todo.domain.Todo;
import app.todo.form.TodoForm.Request;
import app.todo.form.TodoForm.Response;
import app.todo.service.TodoService;

/**
 * @author pollra
 * @description
 * @since 2020.03.14
 **********************************************************************************************************************/
public class App {

    public static void main(String[] args) {
        TodoService todoService = new TodoService(new MemoryRepository<Todo>());

        Request.Add addTest = new Request.Add();
        addTest.setTitle("하이");
        addTest.setContent("하이염");

        Request.Modify modifyTest = new Request.Modify();
        modifyTest.setId(1);
        modifyTest.setTitle("title");
        modifyTest.setContent("content");

        Request.Remove removeTest = new Request.Remove();
        removeTest.setId(1);

        Request.find findTest = new Request.find();
        findTest.setId(1);

        try {
            System.out.println("add test: "+todoService.write(addTest));
            System.out.println("modify test: "+todoService.modify(modifyTest));
            System.out.println("list test: "+todoService.list());
            System.out.println("find test: "+todoService.find(findTest).toString());
            System.out.print("remove test: ");
            todoService.remove(removeTest);
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }
}
