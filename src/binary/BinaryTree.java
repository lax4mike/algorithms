package binary;

public class BinaryTree {

	Node root = null;
	
	public BinaryTree() {
		
	}
	
	public void addNode(int value) {
		
		Node newNode = new Node(value);
		
		if (this.root == null) {
			this.root = newNode;
			return;
		}
		else {
			Node focusNode = this.root;
			
			while (true) {
				
				if (value < focusNode.value) {
					
					if (focusNode.left == null){
						focusNode.left = newNode;
						return;
					} else {
						focusNode = focusNode.left;
						continue;
					}
					
				}
				else {
					
					if (focusNode.right == null){
						focusNode.right = newNode;
						return;
					} else {
						focusNode = focusNode.right;
						continue;
					}
					
				}
			}
		}
		
	}
	
	public Node findNode (int value) {
		
		Node focusNode = this.root;
		
		while (focusNode.value != value) {
			
			if (value < focusNode.value) {
				focusNode = focusNode.left;
			}
			else {
				focusNode = focusNode.right;
			}
			
			if (focusNode == null) {
				return null;
			}
		}
		
		
		return focusNode;
	}
	
	
	public void removeNode(int value) {
		
		Node focusNode = root;
		Node parent = root;
		
		while (focusNode.value != value) {
			
			parent = focusNode;
			
			if (value < focusNode.value) {
				focusNode = focusNode.left;
			}
			else {
				focusNode = focusNode.right;
			}
			
			if (focusNode == null) {
				return;
			}
		}
		
		if (focusNode.left == null && focusNode.right == null){
			
		}
		if (parent.left == focusNode) {
			parent.left = focusNode.right;
			

		} else if (parent.right == focusNode) {
			parent.right = focusNode.left;
		}
		
		// MORE STUFF, maybe later
		// write case for each (no children, just left child, just right child, both children)
		
	}
	
	public void inOrderTraversal(Node focusNode) {
		
		if (focusNode != null) {
			this.inOrderTraversal(focusNode.left);
			System.out.println(focusNode + ": " + focusNode.left + " : " + focusNode.right);
			this.inOrderTraversal(focusNode.right);
		}
	}
	
	public void preOrderTraversal(Node focusNode) {
		
		if (focusNode != null) {
			System.out.println(focusNode);
			this.preOrderTraversal(focusNode.left);
			this.preOrderTraversal(focusNode.right);
		}
	}
	
	
	
}

class Node {
	
	public int value;
	public Node left;
	public Node right;
	
	public Node (int value){
		this.value = value;
	}
	
	public void setLeft(Node left) {
		this.left = left;
	}
	
	public void setRight(Node right) {
		this.right = right;
	}
	
	public String toString() {
		return Integer.toString(this.value);
	}
	
}
