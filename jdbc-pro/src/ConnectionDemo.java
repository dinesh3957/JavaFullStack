import java.sql.Connection;
import java.sql.DatabaseMetaData;

import com.mysql.cj.jdbc.Driver;
import java.sql.DriverManager;

public class ConnectionDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		String url="jdbc:mysql://localhost:3306/mmcoe";
//		
		try {
//			DriverManager.registerDriver(new Driver());
			Connection conn=JdbcFactory.getConnection();
			System.out.println("connection sucesssfull");
			
			DatabaseMetaData meta =conn.getMetaData();
			
			System.out.println("DB name"+meta.getDatabaseProductName());
			System.out.println("Db version"+ meta.getDatabaseProductVersion());
			System.out.println("Driver name"+meta.getDriverName());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println("Coonection Failed");
			e.printStackTrace();
		}

	}

}
