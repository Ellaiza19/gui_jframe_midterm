
package mid;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class connectiondb {
    
      private static final String URL = "jdbc:mysql://localhost:3306/hello_shop";
    private static final String User = "root";
    private static final String Password = "";
    
    public static Connection getConnection() {
        Connection conn = null;
        
        try {
            conn = DriverManager.getConnection(URL,User,Password);
            System.out.println("Database Connected Successfully!");
            
        } catch (SQLException e) {
            System.out.println("Connection Failed!");
            e.printStackTrace();
            
        }
        return conn;
    }
    
}
