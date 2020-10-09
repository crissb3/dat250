package main;

import java.util.List;


import DAO.Dao;
import DAO.UserDAO;
import model.User;


public class Main {



    public static void main(String[] args) {

        Dao<User> userDAO = new UserDAO();
        List<User> users = userDAO.find();
        users.forEach(System.out::println);

       /* User user = new User();
        User user1 = new User();
        User user2 = new User();
        user.setUsername("Cristoffer");
        user.setPassword("pw1");
        user1.setUsername("Erlend");
        user1.setPassword("password123");
        user2.setUsername("Tor");
        user2.setPassword("pwpw321");

        userDAO.create(user2);
        userDAO.create(user1);
        userDAO.create(user);*/





    }
}
