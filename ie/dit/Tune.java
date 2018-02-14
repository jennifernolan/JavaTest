package ie.dit;

public class Tune implements Player
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
		if(altTitle = null)
		{
			return x + ", " + title + ", " + notation;
		}
		else
		{
			return x + ", " + title + ", " + altTitle + ", " + notation;
		}
	}
	
	void play()
	{
		System.out.println(notation);
	}
}