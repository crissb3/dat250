import com.google.gson.Gson;

import java.util.List;

import static spark.Spark.*;

public class App {

    static TodoDAO todoDAO = new TodoDAO();

    public static void main(String[] args) {

        if (args.length > 0) {
            port(Integer.parseInt(args[0]));
        } else {
            port(8080);
        }

        after((request, response) -> {
            response.type("application/json");
        });

        get("/todos/", (request, response) ->
        {
            List<Todo> todo = todoDAO.find();
            Gson gson = new Gson();
            return gson.toJson(todo.toArray());
        });

        get("/todos/:id", (request, response) -> {
            Todo todo = todoDAO.find(Integer.parseInt(request.params(":id")));
            return todo.toJson();
        });

        put("/todos/update/", (request,response) -> {
            Gson gson = new Gson();
            Todo todo = gson.fromJson(request.body(), Todo.class);
            todoDAO.update(todo);
            return todo.toJson();
        });

        delete("/todos/delete/:id", (request, response) -> {
            todoDAO.delete(Integer.parseInt(request.params(":id")));
            return "Deleted id: "+(Integer.parseInt(request.params(":id")));
        });

        post("/todos/", (request, response) -> {
            Gson gson = new Gson();
            Todo todo = gson.fromJson(request.body(), Todo.class);
            todoDAO.create(todo);
            return todo.toJson();
        });
    }
}
