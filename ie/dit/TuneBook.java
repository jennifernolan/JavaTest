package ie.dit;

import java.util.ArrayList;

public class TuneBook
{
	ArrayList<String> tune = new ArrayList<String>();
	
	public void TuneBook(String filename)
	{
		BufferedReader inputStream = null;
		try 
		{
			inputStream = new BufferedReader(new FileReader("abc.txt"));
			
			String l;
			while ((l = inputStream.readLine()) != null) 
			{
				abc.getX;
				abc.getTitle;
				abc.getAltTitle;
				abc.getNotation;
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
}