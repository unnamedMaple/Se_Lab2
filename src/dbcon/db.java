package dbcon;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class db {
	Connection con = null;
	Statement stat = null;
	ResultSet rs = null;
	public db()
	{
		try
		{
			Class.forName("com.mysql.jdbc.Driver");
		}
		catch (Exception e) 
		{
		  con = null;
	      e.printStackTrace();
		}
		
		try 
		{
		      con = DriverManager.getConnection(
		          "jdbc:mysql://localhost:3306/bookdb","root","qazwsx123");
		}
		catch (Exception e) 
		{
		      System.out.print("get data error!");
		      e.printStackTrace();
		}

	}
	
	public ResultSet executeQuery(String sql) 
	{
		try 
		{
			stat = con.createStatement();
			rs = stat.executeQuery(sql);
		} 
		catch (Exception e) 
		{
			rs = null;
		}
		return rs;
	}
	
	public int executeUpdate(String sql) 
	{
		try 
		{
			stat = con.createStatement();
			stat.executeUpdate(sql);
			return 0;
		} catch (Exception e) 
		{

		}
		return -1;
	}
	
	
}
