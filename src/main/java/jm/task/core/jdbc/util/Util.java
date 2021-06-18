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

   /* private static Connection getMysqlConnection() {
        try {
            DriverManager.registerDriver((Driver) Class
                    .forName("com.mysql.jdbc.Driver").newInstance());

            StringBuilder url = new StringBuilder();

            url.
                    append("jdbc:mysql://").        //db type
                    append("localhost:").           //host name
                    append("3306/").                //port
                    append("myshema").          //db name
                    append("user=root&").          //login
                    append("password=root").       //password
                    append("&serverTimezone=UTC");

            System.out.println("URL: " + url + "\n");

            Connection connection = DriverManager.getConnection(url.toString());
            return connection;
        } catch (SQLException | InstantiationException | IllegalAccessException | ClassNotFoundException e) {
            e.printStackTrace();
            throw new IllegalStateException();
        }
    }*/

}
