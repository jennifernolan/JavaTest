package ie.dit;

public class Tune
{
	private int x;
	private String title;
	private String altTitle;
	private String notation;
	
	public int getX()
	{
		return x;
	}
	
	public String getTitle()
	{
		return title;
	}
	
	public String getAltTitle()
	{
		return altTitle;
	}
	
	public String getNotation()
	{
		return notation;
	}
	
	public String toString()
	{
		StringBuffer sb = new StringBuffer();
		
		for(String w:abc)
		{
			sb.append(w + ", ");
		}
		return sb.toString();
	}
}