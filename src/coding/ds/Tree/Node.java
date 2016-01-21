package coding.ds.Tree;

public class Node {
	int key;
	Node leftChild;
	Node rightChild;

	public Node()
	{

	}

	public Node(int key)
	{
		this.key = key;
		leftChild = null;
		rightChild = null;
	}

	public int getKey() {
		return key;
	}

	public void setKey(int key) {
		this.key = key;
	}

	public Node getLeftTree() {
		return leftChild;
	}

	public void setLeftTree(Node leftTree) {
		this.leftChild = leftTree;
	}

	public Node getRightTree() {
		return rightChild;
	}

	public void setRightTree(Node rightTree) {
		this.rightChild = rightTree;
	}
}
