import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

import com.jdbcfactory.JdbcFactory;

public class TransactionDemo {

	public static void main(String[] args) throws SQLException {
		// TODO Auto-generated method stub
 String sql1="insert into cust value(18,'nik','noida')";
 String sql2="update cust set city='madurai' where cid=11";
 String sql3="delete from cust where cid=15";
 Connection conn = null;
 try {
	 conn=JdbcFactory.getConnection();
	 conn.setAutoCommit(false);
	 
	 Statement stmt=conn.createStatement();
	 
	 stmt.addBatch(sql1);
	 stmt.addBatch(sql2);
	 stmt.addBatch(sql3);
	 
	 stmt.executeBatch();
	 conn.commit();
	 System.out.println("Tranaction success ");
} catch (SQLException e) {
	// TODO Auto-generated catch block
	
	System.out.println("Tranaction faild ");
	
	
		conn.rollback();

	
	
	e.printStackTrace();
}
 
 
	}

}
