import java.sql.Connection;
import java.sql.DriverManager;

import javax.swing.JOptionPane;
public class DatabaseConnection {

      Connection conn = null;
      public static Connection ConnectDb() {

        // String databaseName = "userinfo";
        // String databaseUser = "root";
        // String databasePassword = "";
        // String url = "jdbc:mysql://localhost/" + databaseName;

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/userinfo","root","" );
            JOptionPane.showMessageDialog(null, "connection established");
            return conn;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
            return null;
        }
        
    }
    
}
 