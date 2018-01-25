import java.util.ArrayList;

public class Board 
{
	State goal;
	State start;
	
	public Board(State goal, State start)
	{
		this.goal = goal;
		this.start = start;
	}
	
////	public int humming(State y) //returns the number of blocks out of place
////	{
////		int k=0;
////		for (int i=0; i<size; i++)
////			for (int j=0; j<size; j++)
////				if(y.tiles[i][j] != goal.tiles[i][j])
////					k++;
////		System.out.println(k);
////		return k;
////	}
////	
////	public int manhattan(State y)
////	{
////		int value=0;
////		for(int i=0; i<size; i++)
////			for(int j=0; j<size; j++)
////			{
////				if(y.tiles[i][j] != goal.tiles[i][j])
////				{
////					boolean cont = true;
////					for(int p=0; p<size && cont==true; p++)
////						for(int k=0; k<size && cont==true; k++)
////							if(y.tiles[i][j] == goal.tiles[p][k])
////							{
////								value = value + Math.abs(i-p) + Math.abs(j-k);
////								cont = false;
////							}
////				}
////			}
////		System.out.println(value);
////		return value;
////	}
////	
////	public boolean equals(int[][] y)
////	{
////		for(int i=0; i<size; i++)
////			for (int j=0; j<size; j++)
////			{
////				if (tiles[i][j] != y[i][j])
////					return false;
////			}
////		return true;
////	}
//	
//	public int[][] Copy(int[][] original)
//	{
//		int[][] a = new int[size][size];
//		for (int m=0; m<size; m++)
//			for (int n=0; n<size; n++)
//				a[m][n]=original[m][n];
//		return a;
//	}
//	
//	public ArrayList<int[][]> Neibourghs(int[][] actual)
//	{
//		ArrayList<int[][]> neibourghs = new ArrayList<int[][]>();
//		for(int i=0; i<size; i++)
//		{
//			for(int j=0; j<size; j++)
//			{
//				if(actual[i][j] == 0)
//				{
////					if(i!=0 && i!=size-1 && j!=0 && j!=size-1 )
////					{
////						int[][] a = Copy(actual);
////						int[][] b = Copy(actual);
////						int[][] c = Copy(actual);
////						int[][] d = Copy(actual);
////
////						a[i][j] = actual[i-1][j];
////						a[i-1][j] = actual[i][j];
////						neibourghs.add(a);
////						
////						b[i][j] = actual[i+1][j];
////						b[i+1][j] = actual[i][j];
////						neibourghs.add(b);
////						
////						c[i][j] = actual[i][j-1];
////						c[i][j-1] = actual[i][j];
////						neibourghs.add(c);
////						
////						d[i][j] = actual[i][j+1];
////						d[i][j+1] = actual[i][j];
////						neibourghs.add(d);
////					}
//					if(i!=0 && i!=size-1)
//					{
//						int[][] a = Copy(actual);
//						int[][] b = Copy(actual);	
//							a[i+1][j] = actual[i][j];
//							a[i][j] = actual[i+1][j];
//							neibourghs.add(a);
//							
//							b[i-1][j] = actual[i][j];
//							b[i][j] = actual[i-1][j];
//							neibourghs.add(b);
//					} else if(i == 0)
//					{
//						int[][] a = Copy(actual);
//						a[0][j] = actual[1][j];
//						a[1][j] = actual[0][j];
//						neibourghs.add(a);
//					} else if(i == size-1)
//					{
//						int[][] a = Copy(actual);
//						a[size-1][j] = actual[size-2][j];
//						a[size-2][j] = actual[size-1][j];
//						neibourghs.add(a);
//					}
//					if(j!=0 && j!=size-1)
//					{
//						int[][] a = Copy(actual);
//						int[][] b = Copy(actual);	
//							a[i][j+1] = actual[i][j];
//							a[i][j] = actual[i][j+1];
//							neibourghs.add(a);
//							
//							b[i][j-1] = actual[i][j];
//							b[i][j] = actual[i][j-1];
//							neibourghs.add(b);
//					} else if(j == 0)
//					{
//						int[][] a = Copy(actual);
//						a[i][0] = actual[i][1];
//						a[i][1] = actual[i][0];
//						neibourghs.add(a);
//					} else if(j == size-1)
//						{
//						int[][] a = Copy(actual);
//							a[i][size-1] = actual[i][size-2];
//							a[i][size-2] = actual[i][size-1];
//							neibourghs.add(a);
//						}
//				}
//			}
//		}
//		return neibourghs;
//	}
}
