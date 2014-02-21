package search;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Stack;


public class Graph {


	public Graph() {
		
	}
	
	
	/**
	 * Return the shorts path from start to end
	 * Dijkstra's algorithm
	 * @param start
	 * @param end
	 * @return
	 */
	public List<Node> getShortestPath(Node start, Node end) {
		
		// keep track of all the nodes that we've visited (added to the queue) already
		List<Node> visited = new ArrayList<Node>();
		
		// Queue to keep track of what nodes we need to explore their siblings
		Queue<Node> q = new LinkedList<Node>();
		
		// for each node, keep track of the shortest amount of steps it takes to get from start this node
		Map<Node, Integer> steps = new HashMap<Node, Integer>();
		
		// add the start node initially
		q.add(start);
		visited.add(start);
		steps.put(start, 0);
		
		// while we still have some nodes in the queue to visit...
		while (!q.isEmpty()) {

			// get the first node in the queue and how many steps are currently recorded for that node 
			Node current = q.remove();
			int currentSteps = steps.get(current);
			
			// walk through the siblings of the current node
			for (Map.Entry<Node, Integer> bro: current.getSiblings().entrySet()) {
				
				// get distance from start to this bro node
				Node node = bro.getKey();
				int nodeSteps = currentSteps + bro.getValue(); 

				// if we haven't recorded that value yet, record it
				if (!steps.containsKey(node)) {
					steps.put(node, nodeSteps);
				}
				// otherwise, record it only if it's less than what is already there
				else {
					int oldSteps = steps.get(node);
					steps.put(node, Math.min(oldSteps, nodeSteps));
				}
				
				// if we haven't visited this sibling yet, make it as visited and add it to the queue
				if (!visited.contains(node)) {
					q.add(node);
					visited.add(node);
				}			
			}
		
		}
		
		// Ordered list to hold the final shortest path
		List<Node> path = new LinkedList<Node>();
		
		// add end node to the path
		Node current = end;
		path.add(0, end);
		
		// walk back until we hit the start node
		while (current != start){
			
			// the shortest amount of steps to get to the current node
			int currentStep = steps.get(current);
			
			// walk through siblings and find the one where the steps value + the distance to that node 
			// is equal to the step value of the current node.
			for (Map.Entry<Node, Integer> bro: current.getSiblings().entrySet()) {
				
				Node thisNode = bro.getKey();
				int thisDistance = bro.getValue();
				
				if ((currentStep - thisDistance) == steps.get(thisNode)){
					path.add(0, thisNode); // add to the beginning, because we're walking back backward
					current = thisNode;
					break;
				}
			
			}
			
		}
		System.out.println("steps: "+ steps);
		return path;
	}
	
	
	
	/**
	 * walk through a graph breadth first from a start node
	 * @param start
	 * @return
	 */
	public List<Node> bfs(Node start) {
		
		// keep track of all the nodes that we've visited (added to the queue) already
		List<Node> visited = new ArrayList<Node>();
		
		// Queue to keep track of what nodes we need to explore their siblings
		Queue<Node> q = new LinkedList<Node>();
		
		// add the start node initially
		q.add(start);
		visited.add(start);
		
		// while we still have some nodes in the queue to visit...
		while (!q.isEmpty()) {

			// get the first node in the queue
			Node current = q.remove();

			// walk through the siblings of the current node
			for (Node sibling: current.getSiblings().keySet()) {
				
				// if we haven't visited this sibling yet, mark it as visited and add it to the queue
				if (!visited.contains(sibling)) {
					q.add(sibling);
					visited.add(sibling);
				}			
			}
		
		}

		return visited;
	}
	
	/**
	 * Method 1: fully explores all children and adds to stack
	 * @param start
	 * @return
	 */
	public List<Node> dfs(Node start) {
		
		// keep track of all the nodes that we've visited (popped from the stack) already
		List<Node> visited = new LinkedList<Node>();
		
		// Stack to keep track of what nodes we need to explore their siblings
		Stack<Node> s = new Stack<Node>();
		
		// add the start node to the stack initially
		s.push(start);
		
		while (!s.isEmpty()) {
			System.out.println("s: " + s);
			
			// get the top node from the stack, and add it to the visited array
			Node current = s.pop();
			visited.add(current);
			
			// walk through the siblings of the current node
			for (Node bro : current.getSiblings().keySet()) {

				// if it's not visited yet, add it to the stack
				if (!visited.contains(bro)) {
					s.push(bro);
				}
				
			}
	
		}
		
		return visited;
	}
	
	/**
	 * Method 2:  Stops after if it finds 1 unvisited child, keeps current node 
	 * in stack, will revisit later
	 * @param start
	 * @return
	 */
	public List<Node> dfs2(Node start) {
		
		// keep track of all the nodes that we've visited (popped from the stack) already
		List<Node> visited = new LinkedList<Node>();
		
		// Stack to keep track of what nodes we need to explore their siblings
		Stack<Node> s = new Stack<Node>();
		
		// add the start node to the stack initially
		s.push(start);
		visited.add(start);
		Node current = start;
		
		stackEmpty: while (!s.isEmpty()) {
			System.out.println("s: " + s);
			
			current = s.peek();

			// walk through the siblings of the current node
			for (Node bro : current.getSiblings().keySet()) {
				
				// if it's not visited yet, add it to the stack
				if (!visited.contains(bro)) {
					s.push(bro);
					visited.add(bro);
					continue stackEmpty;
				}				
			}

			// if the current node has no unvisited children
			s.pop();

		}
		
		return visited;
	}
	
	
	
}
