package student.examples.ggengine.services;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBService {
    private static Connection connection = null;

    private DBService() {

    }

    public static Connection getConnection() {

        try {
            if(connection==null || !connection.isValid(0)) {
                Class.forName("org.postgresql.Driver");
                connection = DriverManager.getConnection("jdbc:postgresql://localhost/ggengine?user=postgres&password=postgres");
            }
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return connection;
    }
}
