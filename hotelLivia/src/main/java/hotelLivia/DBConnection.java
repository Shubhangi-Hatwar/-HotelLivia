package hotelLivia;

import java.sql.*;

public class DBConnection 
{
	private static Connection con;
	public DBConnection()
	{
	}
	static
	{
		try
		{
			Class.forName("oracle.jdbc.driver.OracleDriver");
			con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","c##ora","tharun");
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	public static Connection DBgetConnection()
	{
		return con;
	}
}
