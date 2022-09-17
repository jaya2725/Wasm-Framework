package vtiger.GenericUtility;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.mysql.cj.jdbc.Driver;

public class DatabaseUtility {
	Driver driverref;
	
	Connection con=null;
	public void connectToDB() throws SQLException {
		driverref=new Driver();
		DriverManager.registerDriver(driverref);
		con=DriverManager.getConnection(ConstantsUtility.DBUrl,ConstantsUtility.DBUsername,ConstantsUtility.DBPassword);
		
		
	}
	public void closeDB() throws SQLException {
		con.close();
	}
	public String executeQueryAndVerifyTheData(String query, int colIndex, String expData) throws SQLException {
		
		boolean flag = false;
		ResultSet result = con.createStatement().executeQuery(query);
		while(result.next())
		{
			String actData = result.getString(colIndex);
			if(actData.equals(expData)) {
				flag=true;
				break;
				
				
			}
		}
		if(flag) {
			System.out.println("data present" +expData);
			return expData;
		}
		else
		{
			System.out.println("data not present");
			return " ";
		}
	}

}
