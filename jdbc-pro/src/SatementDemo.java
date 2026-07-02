import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

import com.jdbcfactory.JdbcFactory;

public class SatementDemo {
public static void main(String[] args) {
	String sql="insert into cust values(13,'Rohit','Mohol')";
	
	
	try {
		Connection conn=JdbcFactory.getConnection();
		
		Statement stmt=conn.createStatement();
		stmt.executeUpdate(sql);
		System.out.println("Record Inserted");
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
}
}
