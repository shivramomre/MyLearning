package coding.ds.Tree;

import org.junit.Test;

public class BinaryTreeTest {

	@Test
	public void testAddNode() {
		BinaryTree binaryTree = new BinaryTree();
		binaryTree.add(50);
		binaryTree.add(30);
		binaryTree.add(40);
		binaryTree.add(75);
		binaryTree.add(1);
		binaryTree.add(5);
		binaryTree.add(58);
		
		BTreePrinter.printNode(binaryTree.root);
		
		
//		
//		binaryTree.traverse(TRAVERSE.inorder);
//		System.out.println("\n\n\n");
//		binaryTree.traverse(TRAVERSE.preorder);
//		System.out.println("\n\n\n");
//		binaryTree.traverse(TRAVERSE.postorder);
	}

}
