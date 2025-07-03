package prog01_introduction;

public class Main {
	public static void main(String[] args) {
		Graph g = new Graph(7);
		g.addEdge(0, 1);
		g.addEdge(0, 2);
		g.addEdge(0, 3);
		g.addEdge(0, 4);
		g.addEdge(1, 5);
		g.addEdge(2, 5);
		g.addEdge(3, 6);
		g.addEdge(4,6);
		g.addEdge(5,6);
		
//		g.acceptGraph();
		g.printGraph();
		System.out.println();
		
		g.dfs(0);
		System.out.println();
		g.dfs(1);
		System.out.println();
		g.dfs(2);
		System.out.println();
		g.dfs(3);
		System.out.println();
		g.dfs(4);
		System.out.println();
		g.dfs(5);
		System.out.println();
		g.dfs(6);
		
		System.out.println();
		System.out.println("No of Sink Nodes are "+g.noOfSink());
		System.out.println("No of Source Nodes are "+g.noOfSource());
	}
}
