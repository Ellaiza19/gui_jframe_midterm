
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
        
