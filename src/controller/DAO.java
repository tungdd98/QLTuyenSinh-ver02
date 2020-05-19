package controller;

import com.mysql.jdbc.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author tungdd
 */
public class DAO {
    public Connection conn;
    private final String DB_URL = "jdbc:mysql://localhost/java02";
    private final String USER_NAME = "root";
    private final String PASSWORD = "";

    public DAO() {
        try {
            conn = (Connection) DriverManager.getConnection(DB_URL, USER_NAME, PASSWORD);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
