
package pharmease.system;
import java.sql.*;

public class DBConnection {
    
    public static Connection getCon() {
        Connection con= null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con= DriverManager.getConnection("jdbc:mysql://localhost:3306/Pharmacy", "root", "");
            //return con;
        } catch (Exception e) {
            System.out.println("There were errors while connecting to db..");
            e.printStackTrace();
            
        }
        return con;
    }
}
