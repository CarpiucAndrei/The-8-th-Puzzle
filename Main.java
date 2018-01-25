import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;

public class Main 
{
	public static void main(String args[])
	{
		
//		int goal[][] = new int[3][3];
//		goal[0][0] = 0;
//		goal[0][1] = 1;
//		goal[0][2] = 2;
//		goal[1][0] = 3;
//		goal[1][1] = 4;
//		goal[1][2] = 5;
//		goal[2][0] = 6;
//		goal[2][1] = 7;
//		goal[2][2] = 8;
//		
//		int tile[][] = new int[3][3];
//		tile[0][0] = 1;
//		tile[0][1] = 0;
//		tile[0][2] = 7;
//		tile[1][0] = 6;
//		tile[1][1] = 5;
//		tile[1][2] = 3;
//		tile[2][0] = 4;
//		tile[2][1] = 2;
//		tile[2][2] = 8;
//		
//		int tile[][] = new int[3][3];
//		tile[0][0] = 8;
//		tile[0][1] = 7;
//		tile[0][2] = 5;
//		tile[1][0] = 2;
//		tile[1][1] = 3;
//		tile[1][2] = 4;
//		tile[2][0] = 1;
//		tile[2][1] = 6;
//		tile[2][2] = 0;
		
//		int goal[][] = new int[4][4];
//		goal[0][0] = 0;
//		goal[0][1] = 1;
//		goal[0][2] = 2;
//		goal[0][3] = 3;
//		goal[1][0] = -1;
//		goal[1][1] = 5;
//		goal[1][2] = 6;
//		goal[1][3] = 7;
//		goal[2][0] = 8;
//		goal[2][1] = 9;
//		goal[2][2] = 10;
//		goal[2][3] = 11;
//		goal[3][0] = -1;
//		goal[3][1] = 13;
//		goal[3][2] = 14;
//		goal[3][3] = -1;
//		
//		int tile[][] = new int[4][4];
//		tile[0][0] = 0;
//		tile[0][1] = -1;
//		tile[0][2] = 7;
//		tile[0][3] = 13;
//		tile[1][0] = 11;
//		tile[1][1] = 14;
//		tile[1][2] = 5;
//		tile[1][3] = 8;
//		tile[2][0] = -1;
//		tile[2][1] = 6;
//		tile[2][2] = 4;
//		tile[2][3] = 3;
//		tile[3][0] = 1;
//		tile[3][1] = 9;
//		tile[3][2] = -1;
//		tile[3][3] = 2;
//		
//		int goal[][] = new int[5][5];
//		goal[0][0] = -1;
//		goal[0][1] = 1;
//		goal[0][2] = -1;
//		goal[0][3] = -1;
//		goal[0][4] = -1;
//		goal[1][0] = -1;
//		goal[1][1] = 2;
//		goal[1][2] = 6;
//		goal[1][3] = -1;
//		goal[1][4] = -1;
//		goal[2][0] = -1;
//		goal[2][1] = 3;
//		goal[2][2] = -1;
//		goal[2][3] = -1;
//		goal[2][4] = -1;
//		goal[3][0] = -1;
//		goal[3][1] = 4;
//		goal[3][2] = -1;
//		goal[3][3] = 0;
//		goal[3][4] = -1;
//		goal[4][0] = -1;
//		goal[4][1] = 5;
//		goal[4][2] = -1;
//		goal[4][3] = -1;
//		goal[4][4] = 7;
//		
//		int tile[][] = new int[5][5];
//		tile[0][0] = -1;
//		tile[0][1] = -1;
//		tile[0][2] = -1;
//		tile[0][3] = -1;
//		tile[0][4] = 0;
//		tile[1][0] = -1;
//		tile[1][1] = 7;
//		tile[1][2] = -1;
//		tile[1][3] = -1;
//		tile[1][4] = 4;
//		tile[2][0] = -1;
//		tile[2][1] = -1;
//		tile[2][2] = -1;
//		tile[2][3] = -1;
//		tile[2][4] = -1;
//		tile[3][0] = 1;
//		tile[3][1] = 2;
//		tile[3][2] = 3;
//		tile[3][3] = -1;
//		tile[3][4] = -1;
//		tile[4][0] = -1;
//		tile[4][1] = 5;
//		tile[4][2] = -1;
//		tile[4][3] = -1;
//		tile[4][4] = 6;

		int goal[][] = new int[3][3];
		goal[0][0] = 2;
		goal[0][1] = 0;
		goal[0][2] = -1;
		goal[1][0] = 3;
		goal[1][1] = -1;
		goal[1][2] = -1;
		goal[2][0] = 8;
		goal[2][1] = -1;
		goal[2][2] = 7;

		
		int tile[][] = new int[3][3];
		tile[0][0] = 0;
		tile[0][1] = 2;
		tile[0][2] = -1;
		tile[1][0] = -1;
		tile[1][1] = 3;
		tile[1][2] = -1;
		tile[2][0] = 7;
		tile[2][1] = -1;
		tile[2][2] = 8;
		
//		int goal[][] = new int[4][4];
//		goal[0][0] = -1;
//		goal[0][1] = -1;
//		goal[0][2] = -1;
//		goal[0][3] = -1;
//		goal[1][0] = -1;
//		goal[1][1] = 1;
//		goal[1][2] = -1;
//		goal[1][3] = -1;
//		goal[2][0] = -1;
//		goal[2][1] = 2;
//		goal[2][2] = -1;
//		goal[2][3] = -1;
//		goal[3][0] = -1;
//		goal[3][1] = 3;
//		goal[3][2] = -1;
//		goal[3][3] = 0;
//		
//		int tile[][] = new int[4][4];
//		tile[0][0] = -1;
//		tile[0][1] = -1;
//		tile[0][2] = -1;
//		tile[0][3] = -1;
//		tile[1][0] = -1;
//		tile[1][1] = -1;
//		tile[1][2] = -1;
//		tile[1][3] = -1;
//		tile[2][0] = -1;
//		tile[2][1] = -1;
//		tile[2][2] = -1;
//		tile[2][3] = -1;
//		tile[3][0] = 1;
//		tile[3][1] = 2;
//		tile[3][2] = 3;
//		tile[3][3] = 0;
		
		Board board = new Board(new State(goal), new State(tile) );
//		for(int i=0; i<3; i++)
//		{
//			for(int j=0; j<3; j++)
//			{
//				System.out.print(tile[i][j] + " ");
//			}
//			System.out.println();
//		}
//		State pula = new State(tile);
//		for(State matrix : pula.Neibourghs(pula))
//		{
//		for(int i=0; i<matrix.tiles.length; i++)
//		{
//			for(int j=0; j<matrix.tiles[0].length; j++)
//			{
//				System.out.print(matrix.tiles[i][j] + " ");
//			}
//			System.out.println();
//		}
//		System.out.println();
//		}
//
//		System.out.println(pula.manhattan(new State(goal), new State(tile) ));		
		Solver s = new Solver();

//		new Thread(new Runnable(){
//			public void run()
//			{
//				ArrayList<State> solution2 = s.ManhattenHeuristicAdapted(board);
//			}
//		}).start();
				
//		new Thread(new Runnable(){
//			public void run()
//			{
//				ArrayList<State> solution1 = s.bfsGraph(board);
//			}
//		}).start();
//		
//		new Thread(new Runnable(){
//			public void run()
//			{
//				ArrayList<State> solution2 = s.bfsTree(board);
//			}
//		}).start();
		
		new Thread(new Runnable(){
			public void run()
			{
				ArrayList<State> solution3 = s.dfs(board);
			}
		}).start();
		
//		new Thread(new Runnable(){
//			public void run()
//			{
//				ArrayList<State> solution4 = s.dfsTree(board);
//			}
//		}).start();
		
		new Thread(new Runnable(){
			public void run()
			{
				ArrayList<State> solution5 = s.iterativeDeepening(board);
			}
		}).start();
		
		new Thread(new Runnable(){
			public void run()
			{
				ArrayList<State> solution6 = s.iterativeDeepeningTree(board);
			}
		}).start();
		
//		new Thread(new Runnable(){
//			public void run()
//			{
//				ArrayList<State> solution7 = s.HummingHeuristic(board);
//			}
//		}).start();

//		new Thread(new Runnable(){
//			public void run()
//			{
//				ArrayList<State> solution8 = s.HummingMinimal(board);
//			}
//		}).start();
		
//		new Thread(new Runnable(){
//			public void run()
//			{
//				ArrayList<State> solution9 = s.ManhattenHeuristic(board);
//			}
//		}).start();
//		
//		new Thread(new Runnable(){
//			public void run()
//			{
//				ArrayList<State> solution10 = s.ManhattenMinimal(board);
//			}
//		}).start();
//		
//		new Thread(new Runnable(){
//			public void run()
//			{
//				ArrayList<State> solution11 = s.ManhattenOptimised(board);
//			}
//		}).start();
		
//		new Thread(new Runnable(){
//			public void run()
//			{
//				ArrayList<State> solution2 = s.bfsTree(board);
//			}
//		}).start();
//		ArrayList<State> solution1 = s.HummingHeuristic(board);
//		ArrayList<State> solution2 = s.ManhattenHeuristic(board);
//		ArrayList<State> solution3 = s.bfs(board);

//		for(State element : solution)
//		{
//			for(int i=0; i<element.tiles.length; i++)
//			{
//				for(int j=0; j<element.tiles.length; j++)
//				{
//					System.out.print(element.tiles[i][j] + " ");
//				}
//				System.out.println();
//			}
//			System.out.println();
//		}
	}
}
