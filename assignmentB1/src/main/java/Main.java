import java.util.List;


import DAO.Dao;
import DAO.PollDAO;
import DAO.UserDAO;
import DAO.VoteDAO;
import com.google.gson.Gson;
import model.Poll;
import model.User;
import model.Vote;

import static spark.Spark.*;


public class Main {

    static PollDAO polldao = new PollDAO();
    static VoteDAO votedao = new VoteDAO();
    static UserDAO userdao = new UserDAO();


    public static void main(String[] args) {

        if (args.length > 0) {
            port(Integer.parseInt(args[0]));
        } else {
            port(8080);
        }

        after((request, response) -> {
            response.type("application/json");
        });

        get("/users/", (request, response) ->
        {
            List<User> users = userdao.find();
            Gson gson = new Gson();
            return gson.toJson(users.toArray());
        });

        get("/users/:id", (request, response) -> {
            User user = userdao.find(Integer.parseInt(request.params(":id")));
            return user.toJson();
        });

        put("/users/update/", (request,response) -> {
            Gson gson = new Gson();
            User user = gson.fromJson(request.body(), User.class);
            userdao.update(user);
            return user.toJson();
        });

        delete("/users/delete/:id", (request, response) -> {
            userdao.delete(Integer.parseInt(request.params(":id")));
            return "Deleted id: "+(Integer.parseInt(request.params(":id")));
        });

        post("/users/", (request, response) -> {
            Gson gson = new Gson();
            User user = gson.fromJson(request.body(), User.class);
            userdao.create(user);
            return user.toJson();
        });

        /*post("/polls/:id", (request, response) -> {
            Gson gson = new Gson();
            Poll poll = gson.fromJson(request.body(), Poll.class);
            User user = userdao.find(Integer.parseInt(request.params(":id")));
            poll.setUser(user);
            polldao.create(poll);
            return poll.toJson();
        }); */
        post("/polls/", (request, response) -> {
            Gson gson = new Gson();
            Poll poll = gson.fromJson(request.body(), Poll.class);
            polldao.create(poll);
            return poll.toJson();
        });

        get("/polls/", (request, response) ->
        {
            List<Poll> polls = polldao.find();
            Gson gson = new Gson();
            return gson.toJson(polls.toArray());
        });

        get("/polls/:id", (request, response) -> {
            Poll poll = polldao.find(Integer.parseInt(request.params(":id")));
            return poll.toJson();
        });

        put("/polls/update/", (request,response) -> {
            Gson gson = new Gson();
            Poll poll = gson.fromJson(request.body(), Poll.class);
            polldao.update(poll);
            return poll.toJson();
        });

        delete("/polls/delete/:id", (request, response) -> {
            polldao.delete(Integer.parseInt(request.params(":id")));
            return "Deleted id: "+(Integer.parseInt(request.params(":id")));
        });

        post("/votes/", (request, response) -> {
            Gson gson = new Gson();
            Vote vote = gson.fromJson(request.body(), Vote.class);
            votedao.create(vote);
            return vote.toJson();
        });

        get("/votes/", (request, response) ->
        {
            List<Vote> votes = votedao.find();
            Gson gson = new Gson();
            return gson.toJson(votes.toArray());
        });

        get("/votes/:id", (request, response) -> {
            Vote vote = votedao.find(Integer.parseInt(request.params(":id")));
            return vote.toJson();
        });

        put("/votes/update/", (request,response) -> {
            Gson gson = new Gson();
            Vote vote = gson.fromJson(request.body(), Vote.class);
            votedao.update(vote);
            return vote.toJson();
        });

        delete("/votes/delete/:id", (request, response) -> {
            votedao.delete(Integer.parseInt(request.params(":id")));
            return "Deleted id: "+(Integer.parseInt(request.params(":id")));
        });


    }
}
