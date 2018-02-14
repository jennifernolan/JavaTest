package ie.dit;

import java.util.ArrayList;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

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
				if(l.startsWith("X:"))
				{
					l.getX();
					System.out.println(l);
				}
				
				if(l.startsWith("T:"))
				{
					for(int i = 0; i < 2; i++)
					{
						if(i = 0)
						{
							l.getTitle();
							System.out.println(l);
						}
						else if(i = 1)
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
		
		for(String w:abc)
		{
			sb.append(w + "\n");
		}
		
		return sb.toString();
	}
	
	public Tune findTune(String title)
	{
		int closest = Integer.MAX_VALUE;
		String closestWord = "";
		
		for (String w:abc)
		{
			int rows = needle.length() + 1;
			int cols = haystack.length() + 1;
			
			Matrix m = new Matrix(rows, cols);
			
			//Set row 0 and column 0 in new matrix m
			for(int i = 0; i < rows; i ++)
			{
				m.setElement(i, 0, i);
			}
			
			for(int j = 0; j < cols; j ++)
			{
				m.setElement(0, j, j);
			}
			
			//Levenstein distance code
			for(int row = 1; row < rows; row ++)
			{
				for(int col = 1; col < cols; col ++)
				{
					if(needle.charAt(row - 1) == haystack.charAt(col - 1))
					{
						m.setElement(row, col, m.getElement(row - 1, col -1));
					}
					else
					{
						float min = min3(m.getElement(row - 1, col), m.getElement(row, col - 1), m.getElement(row - 1, col - 1));
						m.setElement(row, col, min + 1);
					}
				}
			}
			
			int ed = (int)m.getElement(rows - 1, cols - 1);
			
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
        TuneBook tb = new TuneBook("hnj0.abc");
        System.out.println(tb);

        Tune t = tb.findTune("Scotsman over the Border");
        t.play();
    }
}