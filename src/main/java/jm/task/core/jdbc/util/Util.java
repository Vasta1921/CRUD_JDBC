package jm.task.core.jdbc.util;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Util extends Config {

    public static Connection getConnection() throws SQLException, ClassNotFoundException {
        String connectionString = "jdbc:mysql://"+ uHost + ":" + uPort + "/" + uName;
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection connection = DriverManager.getConnection(connectionString,uUser,uPass);
        return connection;
    }



}
