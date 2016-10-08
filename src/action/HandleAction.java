package action;

import dbcon.db;

import java.sql.*;
import java.util.*;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;



import data.*;
public class HandleAction {
	private String Authorname;
	private String AuthorID = "";
	private db mydb = new db();
	
	public String getAuthorname()
	{
		return Authorname;
	}
	public void setAuthorname(String Authorname)
	{
		this.Authorname = Authorname;
	}
	
	
	public String getAuthorID()
	{
		return AuthorID;
	}
	public void setAuthorID(String AuthorID)
	{
		this.AuthorID = AuthorID;
	}
	
	public String addbk()
	{
		return "adbk";
	}
	
	public String addar()
	{
		return "adar";
	}
	
	public String search ()throws Exception
	{
		String authorID = "";
		String sql;
		ResultSet rS ;
		if(getAuthorID().equals(""))
		{
			sql = "select authorID from author where name='" + getAuthorname()+"'";
			rS = mydb.executeQuery(sql);
			
			boolean empty = true;
			while(rS.next())
			{
				authorID = rS.getString("authorID");
				empty = false;
			}
			if(empty)
			{
				return "SearchFail";
			}
		}
		
		else
		{
			authorID=getAuthorID();
			sql = "select name from author where authorID=" + authorID;
			rS = mydb.executeQuery(sql);
			while(rS.next())
			{
				setAuthorname(rS.getString("name"));
			}
		}
		
		
		sql = "select * from book where authorID=" + authorID;
		rS = mydb.executeQuery(sql);
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
		}
		 	
		HttpServletRequest request = ServletActionContext.getRequest();
		request.setAttribute("list", bklist);
        return "SearchSuccess";
       
	}

	
    public String display ()throws Exception
    {
    	String arID = ServletActionContext.getRequest().getParameter("arID");
    	String sql = "select * from author where authorID="+arID;
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
    	
    	
    	
    	String bkISBN = ServletActionContext.getRequest().getParameter("bkISBN");
    	String sql2 = "select * from book where ISBN=" + bkISBN;
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
    	String arID = ServletActionContext.getRequest().getParameter("arID");
    	/*
    	String sql = "select name from author where authorID="+arID;
    	String arname="";
    	ResultSet rs = mydb.executeQuery(sql);
    	while(rs.next())
    	{
    		arname = rs.getString("name");
    	}
    	
    	setAuthorname(arname);
    	System.out.println(getAuthorname());
    	*/
    	setAuthorID(arID);
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
    
    public String toupdate() throws Exception
    
    {
    	String ISBN = ServletActionContext.getRequest().getParameter("bkISBN");
    	String sql = "select * from book where ISBN=" + ISBN;
    	ResultSet rS = mydb.executeQuery(sql);
    	book nmybk = new book();
    	while(rS.next())
    	{
    		nmybk.setAuthorID(rS.getInt("authorID"));
    		nmybk.setDate(rS.getString("publishdate"));
    		nmybk.setISBN(rS.getInt("ISBN"));
    		nmybk.setPrice(rS.getInt("price"));
    		nmybk.setPublisher(rS.getString("publisher"));
    		nmybk.setTitle(rS.getString("title"));
    	}
    	HttpServletRequest request = ServletActionContext.getRequest();
    	request.setAttribute("book", nmybk);
    	
    	sql = "select name from author where authorID="+nmybk.getAuthorID();
    	rS = mydb.executeQuery(sql);
    	String authorname = "";
    	while(rS.next())
    	{
    		authorname = rS.getString("name");
    	}
    	HttpServletRequest request2 = ServletActionContext.getRequest();
    	request2.setAttribute("authorname", authorname);
    	return "ToUpdate";
    }
}
