package jdbc.world;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBHelper {
    private String DBURL = "jdbc:mysql://localhost:3306/world?useSSL=false&serverTimezone=UTC";
    private String username = "root";
    private String password = "12345";

    public Connection getConnection() throws SQLException {
        return DriverManager.getConnection(DBURL, username, password);
    }

    public void showErrorMessage(SQLException sqlException){
        System.out.println("Error message : " + sqlException.getMessage());
        System.out.println("Error code : " + sqlException.getErrorCode());
    }
}
