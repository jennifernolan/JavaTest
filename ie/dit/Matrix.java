package ie.dit;

public class Matrix
{
	private int rows;
	private int cols;
	
	private float[][] elements;
	
	//Accessor methods
	public int getRows()
	{
		return rows;
	}
	public int getCols()
	{
		return cols;
	}
	
	public void setElement(int row, int col, float val)
	{
		elements[row][col] = val;
	}
	
	public float getElement(int row, int col)
	{
		return elements[row][col];
	}
	
	public Matrix(int rows, int cols)
	{
		this.rows = rows;
		this.cols = cols;
		elements = new float[rows][cols];
	}
	
	public void identity()
	{
		for(int row = 0; row < rows; row ++)
		{
			for(int col = 0; col < cols; col ++)
			{
				elements[row][col] = (row == col) ? 1 : 0; 
				// in line if statement
			}
		}
	}
}