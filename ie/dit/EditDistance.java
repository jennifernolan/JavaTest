package ie.dit;

public class EditDistance
{
	public static float min3(float a, float b, float c)
	{
		if((a < b) && (a < c))
		{
			return a;
		}
		else if((b < a) && (b < c))
		{
			return b;
		}
		else
		{
			return c;
		}
	}
	
	public static int MinimumEditDistance(String needle, String haystack)
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
		
		//System.out.println(m);
		return (int) m.getElement(rows - 1, cols - 1);
	}
}