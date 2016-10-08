package action;

import java.sql.ResultSet;

import dbcon.db;

public class UpdateAction {
	private String BKISBN;
	private String Authorname;
	private String Publisher;
	private String Publishdate;
	private String Price;
	private db mydb = new db();
	
	public String getBKISBN()
	{
		return this.BKISBN;
	}
	public void setBKISBN(String BKISBN)
	{
		this.BKISBN = BKISBN;
		
	}
	
	public String getAuthorname()
	{
		return this.Authorname;
	}
	public void setAuthorname(String Authorname)
	{
		this.Authorname = Authorname;
	}
	
	public String getPublisher()
	{
		return this.Publisher;
	}
	public void setPublisher(String Publisher)
	{
		this.Publisher = Publisher;
	}
	
	public String getPublishdate()
	{
		return this.Publishdate;
	}
	public void setPublishdate(String Publishdate)
	{
		this.Publishdate = Publishdate;
	}
	
	public String getPrice()
	{
		return this.Price;
	}
	public void setPrice(String Price)
	{
		this.Price = Price;
	}
	
	public String update() throws Exception
	{
		String sql = "select authorID from author where name='"+getAuthorname()+"'";
		ResultSet rs = mydb.executeQuery(sql);
		String arID="";
		boolean exist = false;
		
		while(rs.next())
		{
			arID = rs.getString("authorID");
			exist = true;
		}
		if(!exist)
		{
			return "UpdateFail";
		}
		
		sql = "update book set authorID="+arID+",publisher='"+getPublisher()+"',publishdate='"+getPublishdate()+"',price="+getPrice()+" where ISBN="+getBKISBN();
		int result = mydb.executeUpdate(sql);
		if(result >-1)
		{
			return "UpdateSuccess";
		}
		else
		{
			return "UpdateFail";
		}
		
	}
	
}
