import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Stack;

public class Solver 
{
	int iterativeDeepeningNodesGraph = 0;
	int iterativeDeepeningNodesTree = 0;
	public Solver()
	{
	}
	
	public ArrayList<State> HummingInterim(Board board)
	{
		int nodesNum = 0;
		ArrayList<State> solution = new ArrayList<State>();
		ArrayList<State> transitions = new ArrayList<State>();
		PriorityQueue<State> pq = new PriorityQueue<State>(new Comparator<State>(){
												    public int compare(State x, State y)
												    {
//												    	if (x.humming(board.goal) == y.humming(board.goal))
//												    		return x.distanceToMoves()-y.distanceToMoves();
//												    	else
												    		return x.humming(board.goal) - y.humming(board.goal);
												    }
												});
		pq.add(board.start);
		nodesNum++;
		while(!pq.isEmpty())
		{
			State a = new State(pq.poll());
			nodesNum++;
			boolean k=false;
			for(State t:transitions)
			{
				if(a.equals(t))
				{
					k=true;
					break;
				}
			}
			if(k == false)
			{
				transitions.add(a);
				if(a.humming(board.goal) == 0)
				{
					State q = new State(a);
					while(q.previouse!=null)
					{
						solution.add(0,q);
						q = new State(q.previouse);
						//depth++;
					}
					solution.add(0,q);
					//depth++;
					break;
				}
				else
				{
					for(State i:a.Neibourghs())
						pq.add(i);
				}	
			}
		}
		return solution;
	}
	
	public ArrayList<State> HummingHeuristic(Board board)
	{
		int nodesNum = 0;
		ArrayList<State> solution = new ArrayList<State>();
		ArrayList<State> transitions = new ArrayList<State>();
		PriorityQueue<State> pq = new PriorityQueue<State>(new Comparator<State>(){
												    public int compare(State x, State y)
												    {
//												    	if (x.humming(board.goal) == y.humming(board.goal))
//												    		return x.distanceToMoves()-y.distanceToMoves();
//												    	else
												    		return x.humming(board.goal) - y.humming(board.goal);
												    }
												});
		pq.add(board.start);
		nodesNum++;
		while(!pq.isEmpty())
		{
			State a = new State(pq.poll());
			nodesNum++;
			boolean k=false;
			for(State t:transitions)
			{
				if(a.equals(t))
				{
					k=true;
					break;
				}
			}
			if(k == false)
			{
				transitions.add(a);
				if(a.humming(board.goal) == 0)
				{
					State q = new State(a);
					while(q.previouse!=null)
					{
						solution.add(0,q);
						q = new State(q.previouse);
						//depth++;
					}
					solution.add(0,q);
					//depth++;
					break;
				}
				else
				{
					for(State i:a.Neibourghs())
						pq.add(i);
				}	
			}
		}
		writeMatrixList("humming.txt", solution);
		System.out.println("Humming " + nodesNum);
		return solution;
	}
	
	public ArrayList<State> HummingMinimal(Board board)
	{
		int nodesNum = 0;
		int depth = 0;
		ArrayList<State> solution = new ArrayList<State>();
		ArrayList<State> transitions = new ArrayList<State>();
		PriorityQueue<State> pq = new PriorityQueue<State>(new Comparator<State>(){
												    public int compare(State x, State y)
												    {
//												    	if (x.humming(board.goal) == y.humming(board.goal))
//												    		return x.distanceToMoves()-y.distanceToMoves();
//												    	else
												    		return x.hummingDepth(board.goal) - y.hummingDepth(board.goal);
												    }
												});
		pq.add(board.start);
		nodesNum++;
		while(!pq.isEmpty())
		{
			State a = new State(pq.poll());
			nodesNum++;
			boolean k=false;
			for(State t:transitions)
			{
				if(a.equals(t))
				{
					k=true;
					break;
				}
			}
			if(k == false)
			{
				transitions.add(a);
				if(a.humming(board.goal) == 0)
				{
					State q = new State(a);
					while(q.previouse!=null)
					{
						solution.add(0,q);
						q = new State(q.previouse);
						//depth++;
					}
					solution.add(0,q);
					//depth++;
					break;
				}
				else
				{
					for(State i:a.Neibourghs(depth))
						pq.add(i);
					depth ++;
				}	
			}
		}
		writeMatrixList("hummingMinimal.txt", solution);
		System.out.println("Humming minimal solution " + nodesNum);
		return solution;
	}
	
	public ArrayList<State> ManhattenHeuristic(Board board)
	{
		int nodesNum = 0;
		ArrayList<State> solution = new ArrayList<State>();
		ArrayList<State> transitions = new ArrayList<State>();
		PriorityQueue<State> pq = new PriorityQueue<State>(new Comparator<State>(){
												    public int compare(State x, State y)
												    {
//												    	if (x.manhattan(board.goal) == y.manhattan(board.goal))
//												    		return x.distanceToMoves()-y.distanceToMoves();
//												    	else
												        	return x.manhattan(board.goal) - y.manhattan(board.goal);
												    }
												});
		pq.add(board.start);
		nodesNum++;
		while(!pq.isEmpty())
		{
			State a = new State(pq.poll());
			nodesNum++;
			boolean k=false;
			for(State t:transitions)
			{
				if(a.equals(t))
				{
					k=true;
					break;
				}
			}
			if(k == false)
			{
				transitions.add(a);
				if(a.manhattan(board.goal) == 0)
				{
					State q = new State(a);
					while(q.previouse!=null)
					{
						solution.add(0,q);
						q = new State(q.previouse);
						//depth++;
					}
					//depth++;
					solution.add(0,q);
					break;
				}
				else
					for(State i:a.Neibourghs())
						pq.add(i);
			}
		}
		writeMatrixList("manhatten.txt", solution);
		//System.out.println("Manhatten distance depth " + depth);
		System.out.println("Manhatten distance " + nodesNum);
		//System.out.println((System.nanoTime() - time_prev) / 1000000000.0 + " Manhattaen (block distances)");
		return solution;
	}
	
	public ArrayList<State> ManhattenMinimal(Board board)
	{
		int nodesNum = 0;
		int depth = 0;
		ArrayList<State> solution = new ArrayList<State>();
		ArrayList<State> transitions = new ArrayList<State>();
		PriorityQueue<State> pq = new PriorityQueue<State>(new Comparator<State>(){
												    public int compare(State x, State y)
												    {
//												    	if (x.manhattan(board.goal) == y.manhattan(board.goal))
//												    		return x.distanceToMoves()-y.distanceToMoves();
//												    	else
												        	return x.manhattanDepth(board.goal) - y.manhattanDepth(board.goal);
												    }
												});
		pq.add(board.start);
		nodesNum++;
		while(!pq.isEmpty())
		{
			State a = new State(pq.poll());
			nodesNum++;
			boolean k=false;
			for(State t:transitions)
			{
				if(a.equals(t))
				{
					k=true;
					break;
				}
			}
			if(k == false)
			{
				transitions.add(a);
				if(a.manhattan(board.goal) == 0)
				{
					State q = new State(a);
					while(q.previouse!=null)
					{
						solution.add(0,q);
						q = new State(q.previouse);
						//depth++;
					}
					//depth++;
					solution.add(0,q);
					break;
				}
				else
				{
					for(State i:a.Neibourghs(depth))
						pq.add(i);
					depth++;
				}
			}
		}
		writeMatrixList("manhattenMinimal.txt", solution);
		//System.out.println("Manhatten distance depth " + depth);
		System.out.println("Manhatten distance minimal solution " + nodesNum);
		//System.out.println((System.nanoTime() - time_prev) / 1000000000.0 + " Manhattaen (block distances)");
		return solution;
	}
	
	public ArrayList<State> ManhattenOptimised(Board board)
	{
		int nodesNum = 0;
		int depth = 0;
		ArrayList<State> solution = new ArrayList<State>();
		ArrayList<State> transitions = new ArrayList<State>();
		PriorityQueue<State> pq = new PriorityQueue<State>(new Comparator<State>(){
												    public int compare(State x, State y)
												    {
												    	if (x.manhattan(board.goal) == y.manhattan(board.goal))
												    		return x.distanceToMoves()-y.distanceToMoves();
												    	else
												        	return x.manhattan(board.goal) - y.manhattan(board.goal);
												    }
												});
		pq.add(board.start);
		nodesNum++;
		while(!pq.isEmpty())
		{
			State a = new State(pq.poll());
			nodesNum++;
			boolean k=false;
			for(State t:transitions)
			{
				if(a.equals(t))
				{
					k=true;
					break;
				}
			}
			if(k == false)
			{
				transitions.add(a);
				if(a.manhattan(board.goal) == 0)
				{
					State q = new State(a);
					while(q.previouse!=null)
					{
						solution.add(0,q);
						q = new State(q.previouse);
						//depth++;
					}
					//depth++;
					solution.add(0,q);
					break;
				}
				else
				{
					for(State i:a.Neibourghs())
						pq.add(i);
				}
			}
		}
		ArrayList<State> solutionFinal = new ArrayList<State>(solution);
		solutionFinal.addAll(HummingInterim(new Board(board.goal, solution.get(solution.size()-1))));
		writeMatrixList("manhattenOprtimezed.txt", solutionFinal);
		//System.out.println("Manhatten distance depth " + depth);
		System.out.println("Manhatten optimized solution " + nodesNum);
		//System.out.println((System.nanoTime() - time_prev) / 1000000000.0 + " Manhattaen (block distances)");
		return solution;
	}
	
	public ArrayList<State> bfsGraph(Board board)
	{
		int nodesNum = 0;
		int depth=0;
		ArrayList<State> solution = new ArrayList<State>();
		ArrayList<State> transitions = new ArrayList<State>();
		Queue<State> queue = new LinkedList<State>();
		
		queue.add(board.start);
		nodesNum++;
		
		while(!queue.isEmpty())
		{
			State a = queue.poll();
			boolean k=false;
			for(State t:transitions)
			{
				if(a.equals(t))
				{
					k=true;
					break;
				}
			}
			if(k == false)
			{
				transitions.add(a);
				if(a.equals(board.goal))
				{
					State q = new State(a);
					while(q.previouse!=null)
					{
					solution.add(0,q);
					q = new State(q.previouse);
					}
					solution.add(0,q);
					break;
				}
				else
				{
					for(State i:a.Neibourghs())
					{
						queue.add(i);
						nodesNum++;
					}
					depth++;
				}
			}
		}
		//System.out.println("BFS graph depth " + depth);
		writeMatrixList("bfsGraph.txt", solution);
		System.out.println("BFS graph " + nodesNum);
		return solution;
	}
	
	public ArrayList<State> bfsTree(Board board)
	{
		int nodesNum = 0;
		int depth=0;
		ArrayList<State> solution = new ArrayList<State>();
		Queue<State> queue = new LinkedList<State>();
		
		queue.add(board.start);
		nodesNum++;
		
		while(!queue.isEmpty())
		{
			State a = queue.poll();
				if(a.equals(board.goal))
				{
					State q = new State(a);
					while(q.previouse!=null)
					{
					solution.add(0,q);
					q = new State(q.previouse);
					}
					solution.add(0,q);
					break;
				}
				else
				{
					for(State i:a.Neibourghs())
					{
						queue.add(i);
						nodesNum++;
					}
					depth++;
				}
			}
		//System.out.println("BFS tree depth " + depth);
		writeMatrixList("bfsTree.txt", solution);
		System.out.println("BFS tree " + nodesNum);
		return solution;
	}
	
	public ArrayList<State> dfs(Board board)
	{
		int nodesNum = 0;
		ArrayList<State> solution = new ArrayList<State>();
		ArrayList<State> transitions = new ArrayList<State>();
		Stack<State> stack = new Stack<State>();
		
		stack.push(board.start);
		nodesNum++;
		
		while(!stack.isEmpty())
		{
			State a = stack.pop();
			boolean visited=false;
			
			for(State t:transitions)
			{
				if(a.equals(t))
				{
					visited=true;
					break;
				}
			}
			
			if(visited == false)
			{
				transitions.add(a);
				if(a.equals(board.goal))
				{
					State q = new State(a);
					while(q.previouse!=null)
					{
					solution.add(0,q);
					q = new State(q.previouse);
					}
					solution.add(0,q);
					break;
				}
				else
				{
//					ArrayList<State> ar = new ArrayList<State>(a.Neibourghs());
//					Collections.shuffle(ar);
					for(State i:a.Neibourghs())
					{
						stack.push(i);
						nodesNum++;
					}
				}
			}
		}
		writeMatrixList("dfsGraph.txt", solution);
		System.out.println("DFS graph " + nodesNum);
		return solution;
	} 
	
	public ArrayList<State> dfsTree(Board board)
	{
		int nodesNum = 0;
		ArrayList<State> solution = new ArrayList<State>();
		Stack<State> stack = new Stack<State>();
		
		stack.push(board.start);
		nodesNum++;
		
		while(!stack.isEmpty())
		{
			State a = stack.pop();		
				if(a.equals(board.goal))
				{
					State q = new State(a);
					while(q.previouse!=null)
					{
					solution.add(0,q);
					q = new State(q.previouse);
					}
					solution.add(0,q);
					break;
				}
				else
				{
					ArrayList<State> ar = new ArrayList<State>(a.Neibourghs());
					Collections.shuffle(ar);
					for(State i:ar)
					{
						stack.push(i);
						nodesNum++;
					}
				}
				//System.out.println(0);
		}
		writeMatrixList("dfsTree.txt", solution);
		System.out.println("DFS tree " + nodesNum);
		return solution;
	} 
	
	public ArrayList<State> dfsLimited(int maxDepth, Board board)
	{
		ArrayList<State> solution = new ArrayList<State>();
		ArrayList<State> transitions = new ArrayList<State>();
		Stack<State> stack = new Stack<State>();
		stack.push(board.start);
		int depth = 0;
		
		while(!stack.isEmpty())
		{
			State a = stack.peek();
			boolean visited=false;
			for(State t:transitions)
			{
				if(a.equals(t))
				{
					visited=true;
					break;
				}
			}
			if(visited == false)
			{
				if(depth < maxDepth)
				{
					transitions.add(a);
					if(a.equals(board.goal))
					{
						State q = new State(a);
						while(q.previouse!=null)
						{
						solution.add(0,q);
						q = new State(q.previouse);
						}
						solution.add(0,q);
						break;
					}
					else
					{
						ArrayList<State> ar = new ArrayList<State>(a.Neibourghs());
						Collections.shuffle(ar);
						for(State i:ar)
						{
							stack.push(i);
							iterativeDeepeningNodesGraph++;
						}
						depth++;
					}
				}
				else
				{
					break;
				}
			 }
			stack.pop();
			depth--;
		}
		return solution;
	} 
	
	public ArrayList<State> iterativeDeepening(Board board)
	{
		//int nodesNum = 0;
		ArrayList<State> solution = new ArrayList<State>();
		int maxDepth = 1;
		while(solution.isEmpty())
		{
			solution = dfsLimited(maxDepth, board);
			maxDepth++;
		}
		writeMatrixList("pula.txt", solution);
		System.out.println("Iterative Deepening graph " + iterativeDeepeningNodesGraph);
		//System.out.println(solution);
		return solution;
	} 
	
	public ArrayList<State> dfsLimitedTree(int maxDepth, Board board)
	{
		ArrayList<State> solution = new ArrayList<State>();
		Stack<State> stack = new Stack<State>();
		stack.push(board.start);
		int depth = 0;
		
		while(!stack.isEmpty())
		{
			State a = stack.peek();
			boolean visited=false;

				if(depth < maxDepth)
				{
					if(a.equals(board.goal))
					{
						State q = new State(a);
						while(q.previouse!=null)
						{
						solution.add(0,q);
						q = new State(q.previouse);
						}
						solution.add(0,q);
						break;
					}
					else
					{
						ArrayList<State> ar = new ArrayList<State>(a.Neibourghs());
						Collections.shuffle(ar);
						for(State i:ar)
						{
							stack.push(i);
							iterativeDeepeningNodesTree++;
						}
						depth++;
					}
				} else
					break;
			stack.pop();
			depth--;
		}
		return solution;
	} 
	
	public ArrayList<State> iterativeDeepeningTree(Board board)
	{
		//int nodesNum = 0;
		ArrayList<State> solution =  new ArrayList<State>();
		int maxDepth = 1;
		while(solution.isEmpty())
		{
			solution = dfsLimitedTree(maxDepth, board);
			maxDepth++;
		}
		writeMatrixList("iterativeDFSTree.txt", solution);
		System.out.println("Iterative Deepening tree " + iterativeDeepeningNodesTree);
		return solution;
	} 
	
	void writeMatrixList(String filename, ArrayList<State> ar)
	{
		for(int i=0; i<ar.size(); i++)
		{
			if(i==0)
				try{
					PrintWriter out1 = new PrintWriter(new BufferedWriter(new FileWriter(filename, false)) );
					for(int l=0; l<ar.get(0).tiles.length; l++)
					{
						for(int j=0; j<ar.get(0).tiles[0].length; j++)
						{
							out1.print(ar.get(0).tiles[l][j] + " ");
						}
						out1.println();
					}
					out1.println();
				    out1.close();
				}catch(Exception e)
					{
						System.out.println(e);
					}
			else
				writeMatrix(filename, ar.get(i));
		}
	}
	
	void writeMatrix(String filename, State matrix) {	
			try{
			PrintWriter out1 = new PrintWriter(new BufferedWriter(new FileWriter(filename, true)) );
			for(int i=0; i<matrix.tiles.length; i++)
			{
				for(int j=0; j<matrix.tiles[0].length; j++)
				{
					if(matrix.tiles[i][j]>=0)
						out1.print(" " + matrix.tiles[i][j] + " ");
					else
						out1.print(matrix.tiles[i][j] + " ");
				}
				out1.println();
			}
			out1.println();
		    out1.close();
		}catch(Exception e)
			{
				System.out.println(e);
			}
	}
}
