package action;

import java.sql.ResultSet;

import dbcon.db;

public class AuthorAction {
	private String AuthorName;
	private String AuthorAge;
	private String AuthorCountry;
	private db mydb = new db();
	
	public String getAuthorName()
	{
		return AuthorName;
	}
	public void setAuthorName(String AuthorName)
	
	{
		this.AuthorName = AuthorName;
	}
	
	public String getAuthorAge()
	{
		return AuthorAge;
	}
	
	public void setAuthorAge(String AuthorAge)
	{
		this.AuthorAge = AuthorAge;
	}
	
	public String getAuthorCountry()
	{
		return AuthorCountry;
	}
	public void setAuthorCountry(String AuthorCountry)
	{
		this.AuthorCountry = AuthorCountry;
	}
	
	public String addauthor() throws Exception
	{
		
		String sql="select authorID from author where name='"+getAuthorName()+"'";
		ResultSet rs=mydb.executeQuery(sql);
		String ID="";
		boolean exist = false;
		while(rs.next())
		{
			ID = rs.getString("authorID");
			exist = true;
			
		}
		
		if(exist)
		{
			sql = "update author set name='" + getAuthorName() +"',age="+getAuthorAge()+",country='"+getAuthorCountry()+"' where authorID="+ID;
		}
		else
		{
			sql = "insert into author values(null,'"+getAuthorName()+"',"+getAuthorAge()+",'"+getAuthorCountry()+"')"; 
		}
		mydb.executeUpdate(sql);
		return "AdauSuccess";
	}
}
