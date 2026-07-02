import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Types; // 1. Import Types for the OUT parameter

import com.jdbcfactory.JdbcFactory;

public class CallableDemo {

    public static void main(String[] args) {
        try {
            Connection conn = JdbcFactory.getConnection();
            CallableStatement stmt = conn.prepareCall("{? = call getname(?)}");
            
            // 2. Register the first '?' as an OUT parameter (adjust the Type if it's not VARCHAR)
            stmt.registerOutParameter(1, Types.VARCHAR); 
            
            // 3. Set the second '?' as the input parameter
            stmt.setInt(2, 12);
            
            stmt.execute();
            
            // 4. Retrieve the result
            System.out.println("Name: " + stmt.getString(1));
            
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
