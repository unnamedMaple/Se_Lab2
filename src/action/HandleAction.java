package action;

import dbcon.db;

import java.sql.*;
import java.util.*;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;



import data.*;
public class HandleAction {
	private String Authorname;

	private db mydb = new db();
	
	public String getAuthorname()
	{
		return Authorname;
	}
	public void setAuthorname(String Authorname)
	{
		this.Authorname = Authorname;
	}
	
	
	public String search ()throws Exception
	{
		String sql = "select * from book where authorID=(select authorID from author where name='" + getAuthorname()+"')";
		ResultSet rS = mydb.executeQuery(sql);
		boolean empty = true;
		List<book> bklist = new ArrayList<book>();
		while(rS.next())
		{
			book mbk = new book();
			mbk.setISBN(rS.getInt("ISBN"));
			mbk.setAuthorID(rS.getInt("authorID"));
			mbk.setTitle(rS.getString("title"));
			mbk.setPublisher(rS.getString("publisher"));
			mbk.setDate(rS.getString("publishdate"));
			mbk.setPrice(rS.getInt("price"));
			bklist.add(mbk);
			empty = false;
		}
		if(empty)
		{
			return "SearchFail";
		}
		
		HttpServletRequest request = ServletActionContext.getRequest();
		request.setAttribute("list", bklist);
        return "SearchSuccess";
        
	}

	
    public String display ()throws Exception
    {
    	String arname = ServletActionContext.getRequest().getParameter("arname");
    	String sql = "select * from author where name='"+arname+"'";
    	author nar = new author();
    	ResultSet rS = mydb.executeQuery(sql);
    	while(rS.next())
    	{
    		
    		nar.setAuthorID(rS.getInt("authorID"));
    		nar.setAge(rS.getInt("age"));
    		nar.setName(rS.getString("name"));
    		nar.setCountry(rS.getString("country"));
  
    	}
    	HttpServletRequest request = ServletActionContext.getRequest();
    	request.setAttribute("author", nar);
    	
    	
    	
    	String bktitle = ServletActionContext.getRequest().getParameter("bktitle");
    	String sql2 = "select * from book where title='" + bktitle +"'";
    	ResultSet rS2 = mydb.executeQuery(sql2);
    	book nmybk = new book();
    	while(rS2.next())
    	{
    		nmybk.setAuthorID(rS2.getInt("authorID"));
    		nmybk.setDate(rS2.getString("publishdate"));
    		nmybk.setISBN(rS2.getInt("ISBN"));
    		nmybk.setPrice(rS2.getInt("price"));
    		nmybk.setPublisher(rS2.getString("publisher"));
    		nmybk.setTitle(rS2.getString("title"));
    	}	
    	HttpServletRequest request2 = ServletActionContext.getRequest();
    	request2.setAttribute("book", nmybk);
    	
    		//return "DisplayFail";
    	
    	return "DisplaySuccess";
    }
	
    public String delete() throws Exception
    {
    	String arname = ServletActionContext.getRequest().getParameter("arname");
    	setAuthorname(arname);
    	String ISBN = ServletActionContext.getRequest().getParameter("bkISBN");
    	String sql = "delete from book where ISBN="+ISBN;
    	int result = mydb.executeUpdate(sql);
    	
    	if(result>-1)
    	{
    		return "DeleteSuccess";
    	}
    	return "DeleteFail";
    	
    }
    
    public String retback() throws Exception
    {
    	return "RetSuccess";
    }
}
