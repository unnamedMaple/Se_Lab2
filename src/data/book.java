package data;
public class book {
	private int ISBN;
	private String title;
	private int authorID;
	private String publisher;
	private String publishdate;
	private int price;
	
	
	public int getISBN()
	{
		return ISBN;
	}
	public String getTitle()
	{
		return title;
	}
	
	public int getAuthorID()
	{
		return authorID;
	}
	
	public String getPublisher()
	{
		return publisher;
	}
	public String getPublishdate()
	{
		return publishdate;
	}
	
	public int getPrice()
	{
		return price;
	}
	
	
	
	
	
	
	public void setISBN(int ISBN)
	{
		this.ISBN = ISBN;
	}
	public void setTitle(String title)
	{
		this.title = title;
	}
	public void setAuthorID(int authorID)
	{
		this.authorID = authorID;
	}
	public void setPublisher(String publisher)
	{
		this.publisher = publisher;
	}
	public void setDate(String publishdate)
	{
		this.publishdate = publishdate;
	}
	public void setPrice(int price)
	{
		this.price = price;
	}
	
}
