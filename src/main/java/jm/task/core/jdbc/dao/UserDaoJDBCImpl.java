package jm.task.core.jdbc.dao;

import jm.task.core.jdbc.model.User;
import jm.task.core.jdbc.util.Util;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserDaoJDBCImpl implements UserDao {



    public UserDaoJDBCImpl() {

    }

    public void createUsersTable() {

        String createUsersTable = "CREATE TABLE `myshema`.`user` (\n" +
                "  `id` INT NOT NULL AUTO_INCREMENT,\n" +
                "  `name` VARCHAR(45) NULL,\n" +
                "  `lastname` VARCHAR(45) NULL,\n" +
                "  `age` INT NULL,\n" +
                "  PRIMARY KEY (`id`));";
        try {
            PreparedStatement prst = Util.getConnection().prepareStatement(createUsersTable);
            prst.executeUpdate();
        } catch ( SQLException throwables) {
            throwables.printStackTrace();
        }
        catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public void dropUsersTable() {
        String dropUsersTable = "DROP TABLE USER;";

        try {
            PreparedStatement prst = Util.getConnection().prepareStatement(dropUsersTable);
            prst.executeUpdate();
        } catch (SQLException | ClassNotFoundException throwables) {
            throwables.printStackTrace();
        }
    }

    public void saveUser(String name, String lastName, byte age) {
        String insert = "INSERT INTO USER (NAME, LASTNAME, AGE) VALUES (?,?,?)";

        try {
            PreparedStatement prst = Util.getConnection().prepareStatement(insert);
            prst.setString(1, name);
            prst.setString(2, lastName);
            prst.setByte(3, age);
            prst.executeUpdate();
        }
         catch (SQLException | ClassNotFoundException throwables) {
            throwables.printStackTrace();
        }


    }

    public void removeUserById(long id) {
        String removeUserById = "DELETE FROM USER WHERE ID = ?";

        try {
            PreparedStatement prst = Util.getConnection().prepareStatement(removeUserById);
            prst.setLong(1, id);
            prst.executeUpdate();
        } catch (SQLException | ClassNotFoundException throwables) {
            throwables.printStackTrace();
        }
    }


    public List<User> getAllUsers() {
        List<User> userList = new ArrayList<>();
        String query = "SELECT * FROM USER";
        try (Statement statement = Util.getConnection().createStatement();
             ResultSet rs = statement.executeQuery(query)) {
            while (rs.next()) {
                String name = rs.getString("name");
                String lastName = rs.getString("lastName");
                byte age = rs.getByte("age");
                userList.add(new User(name, lastName, age));
            }
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return userList;
    }

    public void cleanUsersTable() {
        String clearUsersTable = "TRUNCATE TABLE USER";

        try {
            PreparedStatement prst = Util.getConnection().prepareStatement(clearUsersTable);
            prst.executeUpdate();
        } catch (SQLException | ClassNotFoundException throwables) {
            throwables.printStackTrace();
        }


    }
}
