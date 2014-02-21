package search;
import java.util.LinkedHashMap;
import java.util.Map;

public class Node {

	private String label;
	private Map<Node, Integer> siblings; 
	
	public Node(String label) {
		this.label = label;
		// node and how many steps away it is
		this.siblings = new LinkedHashMap<Node, Integer>();	
	}
	
	public String getLabel() {
		return this.label;
	}
	
	public Map<Node, Integer> getSiblings() {
		return this.siblings;
	}
	
	public void addSibling(Node node) {
		this.addSibling(node, 1);
	}
	public void addSibling(Node node, int edge) {
		if (!this.siblings.containsKey(node)) {
			this.siblings.put(node, edge);
		}
		if (!node.hasSibling(this)){
			node.addSibling(this, edge);
		}
		
	}
	public void removeSibling(Node node) {
		if (this.siblings.containsKey(node)) {
			this.siblings.remove(node);
		}
		if (node.hasSibling(this)){
			node.removeSibling(this);
		}
	}
	public boolean hasSibling(Node node) {
		return this.siblings.containsKey(node);
	}
	
	
	public String toString() {
		String theString =  this.label;
		return theString;
	}
	
	public String toDetailedString(){
		String theString =  this.label + " ";
		theString += this.siblings.toString();
		return theString;
	}
}
