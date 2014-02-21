package search;
import java.util.List;


public class Test {

	public static void main(String[] args) {
				
		Graph graph = new Graph();
		
		Node a = new Node("a");
		Node b = new Node("b");
		Node c = new Node("c");
		Node d = new Node("d");
		Node e = new Node("e");
		Node f = new Node("f");
		
		a.addSibling(b, 2);
		a.addSibling(c, 5);
		b.addSibling(d, 1);
		c.addSibling(d, 5);
		d.addSibling(e, 2);
		e.addSibling(f, 1);
		f.addSibling(c, 9);
		
		/**
		 * a [b:2, c:5]
		 * b [d:1, a:2]
		 * c [d:5, a:5, f:9]
		 * d [e:2, b:1, c:5]
		 * e [d:2, f:1]
		 * f [e:1, c:9]
		 */
		
		Node[] ns = {a, b, c, d, e, f};
		for (Node n : ns) {
			System.out.println(n.toDetailedString());
		}		

		List<Node> allBfs = graph.bfs(a);
		System.out.println("All nodes, breadth first: " + allBfs);
		
		List<Node> shortest = graph.getShortestPath(a, f);
		System.out.println("Shortest path from a to f: " + shortest);
		
		
		testBinaryGraph();
		

	}
	
	public static void testBinaryGraph() {
		
		Node a = new Node("a");
		Node b = new Node("b");
		Node c = new Node("c");
		Node d = new Node("d");
		Node e = new Node("e");
		Node f = new Node("f");
		Node g = new Node("g");
		
		a.addSibling(b);
		a.addSibling(c);
		
		b.addSibling(d);
		b.addSibling(e);
		
		c.addSibling(f);
		c.addSibling(g);

		Graph graph = new Graph();


		System.out.println("Binary graph, depth first: " + graph.dfs(a));
		System.out.println("Binary graph, depth first2: " + graph.dfs2(a));
		

//		System.out.println("Binary graph, breadth first: " + graph.bfs(a));
		
		
	}
		
}
