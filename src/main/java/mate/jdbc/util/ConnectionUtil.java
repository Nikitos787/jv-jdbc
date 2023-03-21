package mate.jdbc.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class ConnectionUtil {
    static {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException("Can't load JDBC driver fo MySQL ", e);
        }
    }

    public static Connection getConnection() {
        try {
            Properties dbProperties = new Properties();
            dbProperties.put("user", "root");
            dbProperties.put("password", "qwerty123456");
            return DriverManager.getConnection("jdbc:mysql://localhost:3306/manufacturer_db",
                    dbProperties);
        } catch (SQLException e) {
            throw new RuntimeException("Can't create connection to DataBase ", e);
        }
    }
}
