/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author huawei
 */
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class DBConnection {

    private static final String URL = "jdbc:mysql://localhost:3306/event management";
    private static final String User = "root";
    private static final String Password = "";

    public static Connection getConnection() {
        Connection connection = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

            connection = DriverManager.getConnection(URL, User, Password);
            System.out.println("connection succesfull");
        } catch (SQLException e) {
            System.out.println("Error Connecting to Database:" + e.getMessage());
        } catch (ClassNotFoundException e) {
            System.out.print("MYSQL JDBC DRIVER NOT FOUND:" + e.getMessage());
        }
        return connection;
    }

    public static void closeConnection(Connection connection) {
        if (connection != null) {
            try {
                connection.close();
                System.out.println("Connection Closed.");
            } catch (SQLException e) {
                System.out.println("Error closing the connection:" + e.getMessage());
            }
        }
    }

}
