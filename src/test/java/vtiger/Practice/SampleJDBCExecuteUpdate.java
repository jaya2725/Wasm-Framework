package vtiger.Practice;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.cj.jdbc.Driver;

public class SampleJDBCExecuteUpdate {

	public static void main(String[] args) throws SQLException {
		Driver driverRef=new Driver();
		Connection con=null;
		try {
		DriverManager.registerDriver(driverRef);
		 con = DriverManager.getConnection("jdbc:mysql://localhost:3306/customerdb", "root", "root");
		Statement state = con.createStatement();
	String	query="insert into customerinfo values('Raj',67,'Pune')";
		int result = state.executeUpdate(query);
		if(result==1) {
			System.out.println("If data is inserted");
			
			
		}
		else {
			System.out.println("if data is not inserted");
		}
		}
		catch(Exception e) {
		

	}
		finally {
			con.close();
			System.out.println("database closed");
		}
		}

}
