import java.util.ArrayList;

public class State 
{
	int[][] tiles;
	int depth = 0;
	State previouse = null;
	
	public State(int[][] tiles, State previouse, int depth)
	{
		this.previouse = previouse;
		this.tiles=tiles;
		this.depth = depth;
	}
	public State(int[][] tiles, State previouse)
	{
		this.previouse = previouse;
		this.tiles=tiles;
	}
	public State(int[][] tiles)
	{
		this.tiles=tiles;
	}
	public State(State a)
	{

		this.tiles=a.tiles;
		this.previouse = a.previouse;
	}
	
	public int distanceToMoves()
	{
		int value=0;
		boolean cont = true;
		for(int i=0; i<tiles.length && cont==true; i++)
		{
			for(int j=0; j<tiles[0].length && cont==true; j++)
			{
				if(tiles[i][j] == 0)
				{
					for(int p=0; p<tiles.length; p++)
						for(int k=0; k<tiles[0].length; k++)
							if(tiles[p][k] > 0)
							{
								value = value + Math.abs(i-p) + Math.abs(j-k);
							}
					cont = false;
				}
			}
		}
		//System.out.println(value);
		return value;
	}
	
	public int distanceToMovesDepth()
	{
		return distanceToMoves() + depth;
	}
	
	public int humming(State goal) //returns the number of blocks out of place
	{
//		int k=0;
//		for (int i=0; i<tiles.length; i++)
//		{
//			for (int j=0; j<tiles[0].length; j++)
//			{
//				if(tiles[i][j] != goal.tiles[i][j] && tiles[i][j] != 0)
//					k++;
//			}
//		}
//		//System.out.println(k);
//		return k;
		
		int k=0;
		for (int i=0; i<tiles.length; i++)
		{
			for (int j=0; j<tiles[0].length; j++)
			{
				if(tiles[i][j] != goal.tiles[i][j] && tiles[i][j] != -1)
					k++;
			}
		}
		//System.out.println(k);
		return k;
	}
	
	public int hummingDepth(State goal)
	{
		return humming(goal) + depth;
	}
	
	public int manhattan(State goal)
	{
//		int value=0;
//		for(int i=0; i<tiles.length; i++)
//			for(int j=0; j<tiles[0].length; j++)
//				if(tiles[i][j] != goal.tiles[i][j] && tiles[i][j] != 0)
//				{
//					boolean cont = true;
//					for(int p=0; p<goal.tiles.length && cont==true; p++)
//						for(int k=0; k<goal.tiles[0].length && cont==true; k++)
//							if(tiles[i][j] == goal.tiles[p][k])
//							{
//								value = value + Math.abs(i-p) + Math.abs(j-k);
//								cont = false;
//							}
//				}
//		//System.out.println(value);
//		return value;
		
		int value=0;
		for(int i=0; i<tiles.length; i++)
		{
			for(int j=0; j<tiles[0].length; j++)
			{
				if(tiles[i][j] != goal.tiles[i][j] && tiles[i][j] != -1 && tiles[i][j] != 0)
				{
					boolean cont = true;
					for(int p=0; p<goal.tiles.length && cont==true; p++)
						for(int k=0; k<goal.tiles[0].length && cont==true; k++)
							if(tiles[i][j] == goal.tiles[p][k])
							{
								value = value + Math.abs(i-p) + Math.abs(j-k);
								cont = false;
							}
				}
			}
		}
		//System.out.println(value);
		return value;
	}
	
	public int manhattanDepth(State goal)
	{
		return manhattan(goal) + depth;
	}
	
	public boolean equals(State y)
	{
		boolean k = true;
		for(int i=0; i<tiles.length && k==true; i++)
			for (int j=0; j<tiles[0].length && k==true; j++)
			{
				if (tiles[i][j] != y.tiles[i][j])
					k=false;
			}
		return k;
	}
	
	public int[][] Copy(int[][] original)
	{
		int[][] a = new int[tiles.length][tiles.length];
		for (int m=0; m<tiles.length; m++)
			for (int n=0; n<tiles[0].length; n++)
				a[m][n]=original[m][n];
		return a;
	}
	
	public ArrayList<State> Neibourghs()
	{
		ArrayList<State> neibourghs = new ArrayList<State>();
		for(int i=0; i<tiles.length; i++)
		{
			for(int j=0; j<tiles[0].length; j++)
			{
				if(tiles[i][j] == 0)
				{
					if(i!=0 && i!=tiles.length-1)
					{
						int[][] a = Copy(tiles);
						int[][] b = Copy(tiles);	
							a[i+1][j] = tiles[i][j];
							a[i][j] = tiles[i+1][j];
							neibourghs.add(new State(a, this) );
							
							b[i-1][j] = tiles[i][j];
							b[i][j] = tiles[i-1][j];
							neibourghs.add(new State(b, this));
					} else if(i == 0)
					{
						int[][] a = Copy(tiles);
						a[0][j] = tiles[1][j];
						a[1][j] = tiles[0][j];
						neibourghs.add(new State(a, this));
					} else if(i == tiles.length-1)
					{
						int[][] a = Copy(tiles);
						a[tiles.length-1][j] = tiles[tiles.length-2][j];
						a[tiles.length-2][j] = tiles[tiles.length-1][j];
						neibourghs.add(new State(a, this));
					}
					if(j!=0 && j!=tiles.length-1)
					{
						int[][] a = Copy(tiles);
						int[][] b = Copy(tiles);	
							a[i][j+1] = tiles[i][j];
							a[i][j] = tiles[i][j+1];
							neibourghs.add(new State(a, this));
							
							b[i][j-1] = tiles[i][j];
							b[i][j] = tiles[i][j-1];
							neibourghs.add(new State(b, this));
					} else if(j == 0)
					{
						int[][] a = Copy(tiles);
						a[i][0] = tiles[i][1];
						a[i][1] = tiles[i][0];
						neibourghs.add(new State(a, this));
					} else if(j == tiles.length-1)
						{
						int[][] a = Copy(tiles);
							a[i][tiles.length-1] = tiles[i][tiles.length-2];
							a[i][tiles.length-2] = tiles[i][tiles.length-1];
							neibourghs.add(new State(a, this));
						}
				}
			}
		}
		return neibourghs;
	}
	
	public ArrayList<State> Neibourghs(int depth)
	{
		ArrayList<State> neibourghs = new ArrayList<State>();
		for(int i=0; i<tiles.length; i++)
		{
			for(int j=0; j<tiles[0].length; j++)
			{
				if(tiles[i][j] == 0)
				{
					if(i!=0 && i!=tiles.length-1)
					{
						int[][] a = Copy(tiles);
						int[][] b = Copy(tiles);	
							a[i+1][j] = tiles[i][j];
							a[i][j] = tiles[i+1][j];
							neibourghs.add(new State(a, this, depth) );
							
							b[i-1][j] = tiles[i][j];
							b[i][j] = tiles[i-1][j];
							neibourghs.add(new State(b, this, depth));
					} else if(i == 0)
					{
						int[][] a = Copy(tiles);
						a[0][j] = tiles[1][j];
						a[1][j] = tiles[0][j];
						neibourghs.add(new State(a, this, depth));
					} else if(i == tiles.length-1)
					{
						int[][] a = Copy(tiles);
						a[tiles.length-1][j] = tiles[tiles.length-2][j];
						a[tiles.length-2][j] = tiles[tiles.length-1][j];
						neibourghs.add(new State(a, this, depth));
					}
					if(j!=0 && j!=tiles.length-1)
					{
						int[][] a = Copy(tiles);
						int[][] b = Copy(tiles);	
							a[i][j+1] = tiles[i][j];
							a[i][j] = tiles[i][j+1];
							neibourghs.add(new State(a, this, depth));
							
							b[i][j-1] = tiles[i][j];
							b[i][j] = tiles[i][j-1];
							neibourghs.add(new State(b, this, depth));
					} else if(j == 0)
					{
						int[][] a = Copy(tiles);
						a[i][0] = tiles[i][1];
						a[i][1] = tiles[i][0];
						neibourghs.add(new State(a, this, depth));
					} else if(j == tiles.length-1)
						{
						int[][] a = Copy(tiles);
							a[i][tiles.length-1] = tiles[i][tiles.length-2];
							a[i][tiles.length-2] = tiles[i][tiles.length-1];
							neibourghs.add(new State(a, this, depth));
						}
				}
			}
		}
		return neibourghs;
	}
}
