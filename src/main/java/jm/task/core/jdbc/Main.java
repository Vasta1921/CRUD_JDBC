package jm.task.core.jdbc;

import jm.task.core.jdbc.dao.UserDao;
import jm.task.core.jdbc.dao.UserDaoHibernateImpl;
import jm.task.core.jdbc.dao.UserDaoJDBCImpl;
import jm.task.core.jdbc.model.User;
import jm.task.core.jdbc.service.UserService;
import jm.task.core.jdbc.service.UserServiceImpl;

public class Main {

    private final static UserServiceImpl userService = new UserServiceImpl();
    public static void main(String[] args) {
        userService.createUsersTable();


        userService.saveUser("Лео", "Черепах", (byte) 78);
        userService.saveUser("Раф", "Черепах", (byte) 74);
        userService.saveUser("Мики", "Черепах", (byte) 59);
        userService.saveUser("Дон", "Черепах", (byte) 74);

        userService.removeUserById(2);

        userService.getAllUsers();

        userService.cleanUsersTable();

        userService.dropUsersTable();
    }
}
