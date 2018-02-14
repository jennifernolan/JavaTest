package ie.dit;

import java.util.ArrayList;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class TuneBook
{
	ArrayList<String> tunes = new ArrayList<String>();
	
	public void TuneBook()
	{
		BufferedReader inputStream = null;
		try 
		{
			inputStream = new BufferedReader(new FileReader("hnj0.abc"));
			
			String l;
			while ((l = inputStream.readLine()) != null) 
			{
				if(l.startsWith("X:"))
				{
					l.getX();
					System.out.println(l);
				}
				
				if(l.startsWith("T:"))
				{
					for(int i = 0; i < 2; i++)
					{
						if(i == 0)
						{
							l.getTitle();
							System.out.println(l);
						}
						else if(i == 1)
						{
							l.getAltTitle();
							System.out.println(l);
						}
					}
				}
				else
				{
					l.getNotation();
					System.out.println(l);
				}
			}
		}
		catch (IOException e)
		{
			e.printStackTrace();
		} 
		finally 
		{
			if (inputStream != null) {
				try
				{
					inputStream.close();
				}
				catch(Exception e)
				{
					e.printStackTrace();
				}
			}
		}  
	}
	
	public String toString()
	{
		StringBuffer sb = new StringBuffer();
		
		for(String w:tunes)
		{
			sb.append(w + "\n");
		}
		
		return sb.toString();
	}
	
	public Tune findTune(String title)
	{
		int closest = Integer.MAX_VALUE;
		String closestWord = "";
		
		for (String w:tunes)
		{	
			int ed = EditDistance.MinimumEditDistance(title, w);;
			
			if(ed == 0)
			{
				return w;
			}
			if(ed < closest)
			{
				closest = ed;
				closestWord = w;
			}
		}
		return closestWord;
	}
	
	public static void main(String[] args)
    {
       TuneBook tb = new TuneBook();
       System.out.println(tb);

       Tune t = tb.findTune("Scotsman over the Border");
       t.play();
    }
}