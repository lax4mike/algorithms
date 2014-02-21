package binary;

public class Test {

	
	public static void main (String[] args) {
		
		BinaryTree b = new BinaryTree();
		
		b.addNode(6);	
		b.addNode(3);
		b.addNode(2);
		b.addNode(10);
		b.addNode(5);
		
		b.inOrderTraversal(b.root);
		
		System.out.println();
		b.preOrderTraversal(b.root);
		
		System.out.println(b.findNode(19));
		
	}
}
