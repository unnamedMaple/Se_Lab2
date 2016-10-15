package action;

import java.sql.ResultSet;

import dbcon.db;

public class AddAction {
	private String ISBN;
	private String Title;
	private String Authorname;
	private String Publisher;
	private String Publishdate;
	private String Price;
	private db mydb = new db();
	
	public String getISBN()
	{
		return ISBN;
	}
	public void setISBN(String ISBN)
	{
		this.ISBN = ISBN;
	}
	
	public String getTitle()
	{
		return Title;
	}
	public void setTitle(String Title)
	{
		this.Title = Title;
	}

	public String getAuthorname()
	{
		return Authorname;
	}
	public void setAuthorname(String Authorname)
	
	{
		this.Authorname = Authorname;
	}

	public String getPublisher()
	{
		return Publisher;
	}
	public void setPublisher(String Publisher)
	{
		this.Publisher = Publisher;
	}

	public String getPublishdate()
	{
		return Publishdate;
	}
	public void setPublishdate(String Publishdate)
	{
		this.Publishdate = Publishdate;
	}

	public String getPrice()
	{
		return Price;
	}
	public void setPrice(String Price)
	{
		this.Price = Price;
	}
	
	public String addbook() throws Exception
	{
		String sql="select authorID from author where name='"+getAuthorname()+"'";
		ResultSet rs = mydb.executeQuery(sql);
		String ID = "";
		boolean exist = false;
		while(rs.next())
		{
			ID = rs.getString("authorID");
			exist = true;
		}
		if(!exist)
		{
			sql = "insert into author values(null,'"+getAuthorname()+"',"+"1,"+"'cn')";
			mydb.executeUpdate(sql);
			sql="select authorID from author where name='"+getAuthorname()+"'";
			ResultSet rs2 = mydb.executeQuery(sql);
			while(rs2.next())
			{
				ID = rs2.getString("authorID");
			}
			
		}
		
		sql = "insert into book values(" + getISBN() + ",'" + getTitle() + "'," + ID + ",'" + getPublisher() + "','" + getPublishdate() + "'," + getPrice() + ")";
		mydb.executeUpdate(sql);
		if(exist)
		{
			return "AddSuccess";
		}
		
		return "AddAuthor";
	}

}
//ÐÞ¸Ä1