
package hotelmanagementsystem;
import java.sql.*;

public class conn {
    Connection c;
    Statement s;
    public conn(){
        try{
            Class.forName("com.mysql.jdbc.Driver");
                    c= DriverManager.getConnection("jdbc:mysql:///projecthms","root","5657883");
                    s = c.createStatement();
        }catch(Exception e){
                e.printStackTrace();
                }
    }
    
}
