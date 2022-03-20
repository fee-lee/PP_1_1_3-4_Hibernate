package jm.task.core.jdbc;

import jm.task.core.jdbc.model.User;
import jm.task.core.jdbc.service.UserService;
import jm.task.core.jdbc.service.UserServiceImpl;

import java.sql.SQLException;
import java.util.List;

public class Main {
    public static void main(String[] args) throws SQLException {
        UserService userService = new UserServiceImpl();


        userService.createUsersTable();

        userService.saveUser("Enoh", "Root", 38);
        System.out.println("User с именем – "+ userService.getAllUsers().get(0).getName() +" добавлен в базу данных ");
        userService.saveUser("Daniel", "Waterhouse", 42);
        System.out.println("User с именем – "+ userService.getAllUsers().get(1).getName() +" добавлен в базу данных ");
        userService.saveUser("Jack", "Scanty", 25);
        System.out.println("User с именем – "+ userService.getAllUsers().get(2).getName() +" добавлен в базу данных ");
        userService.saveUser("Robert", "Hooke", 45);
        System.out.println("User с именем – "+ userService.getAllUsers().get(3).getName() +" добавлен в базу данных ");


        System.out.println("Таблица пользователей:");
        List<User> allUsers = userService.getAllUsers();
        allUsers.forEach(System.out::println);

        userService.cleanUsersTable();

        userService.dropUsersTable();
    }
}
