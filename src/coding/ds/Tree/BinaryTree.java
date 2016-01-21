package coding.ds.Tree;


public class BinaryTree {

	Node root;

	public BinaryTree()
	{
		root = null;
	}

	public Node getRoot() {
		return root;
	}

	public void setRoot(Node root) {
		this.root = root;
	}

	//To add a node to the Binary Search Tree
	public void add(int data)
	{
		Node nodeToAdd = new Node(data);

		if(root == null)
			root = nodeToAdd;
		else
		{
			traverseAndAddNode(root, nodeToAdd);
		}	
	}

	private void traverseAndAddNode(Node traverseNode, Node nodeToAdd) {
		if(nodeToAdd.key < traverseNode.key)
		{
			if(traverseNode.leftChild == null)
			{
				traverseNode.leftChild = nodeToAdd;
			}
			else
			{
				traverseAndAddNode(traverseNode.leftChild, nodeToAdd);	
			}
		}
		else
		{
			if(traverseNode.rightChild == null)
			{
				traverseNode.rightChild = nodeToAdd;
			}
			else
			{
				traverseAndAddNode(traverseNode.rightChild, nodeToAdd);	
			}
		}
	}

	/*
	 * Unlike linear data structures (Array, Linked List, Queues, Stacks, etc) which have only one logical way to traverse 
	 * them, trees can be traversed in different ways. Following are the generally used ways for traversing trees.
	 * 
	 * Depth First Traversals:
		(a) Inorder
		(b) Preorder
		(c) Postorder
	 *
	 *
	 * */
	public void traverse( TRAVERSE type)
	{
		/*
		Algorithm Inorder(tree) (depth-first)
   				1. Traverse the left subtree, i.e., call Inorder(left-subtree)
   				2. Visit the root.
   				3. Traverse the right subtree, i.e., call Inorder(right-subtree)

   		Uses of Inorder
		In case of binary search trees (BST), Inorder traversal gives nodes in non-decreasing order.
		To get nodes of BST in non-increasing order, a variation of Inorder traversal where Inorder itraversal s reversed,
		can be used.

		Algorithm Preorder(tree) (depth-first)
   				1. Visit the root.
   				2. Traverse the left subtree, i.e., call Preorder(left-subtree)
   				3. Traverse the right subtree, i.e., call Preorder(right-subtree)
		Uses of Preorder
		Preorder traversal is used to create a copy of the tree. 
		Preorder traversal is also used to get prefix expression on of an expression tree. 
		Please see http://en.wikipedia.org/wiki/Polish_notation to know why prefix expressions are useful.

		Algorithm Postorder(tree) (depth-first)
   				1. Traverse the left subtree, i.e., call Postorder(left-subtree)
   				2. Traverse the right subtree, i.e., call Postorder(right-subtree)
   				3. Visit the root.
		Uses of Postorder
		Postorder traversal is used to delete the tree. 
		Please see the question for deletion of tree for details. 
		Postorder traversal is also useful to get the postfix expression of an expression tree. 
		Please see http://en.wikipedia.org/wiki/Reverse_Polish_notation to for the usage of postfix expression.
		 */
		{
			Node nodeToTraverse = root;
			if(nodeToTraverse != null)
			{
				if(nodeToTraverse.leftChild == null && nodeToTraverse.rightChild == null)
					System.out.println(nodeToTraverse.key);
				else
				{
					if(type == TRAVERSE.inorder)
						traverseInorder(nodeToTraverse);
					else if(type == TRAVERSE.preorder)
						traversePreOrder(nodeToTraverse);
					else if(type == TRAVERSE.postorder)
						traversePostOrder(nodeToTraverse);
				}
			}
		}
	}


	private void traverseInorder(Node nodeToTraverse) {
		if(nodeToTraverse.leftChild != null)
		{
			traverseInorder(nodeToTraverse.leftChild);
		}

		System.out.println(nodeToTraverse.key);

		if(nodeToTraverse.rightChild != null)
		{
			traverseInorder(nodeToTraverse.rightChild);
		}
	}

	private void traversePreOrder(Node nodeToTraverse) {
		System.out.println(nodeToTraverse.key);

		if(nodeToTraverse.leftChild != null)
		{
			traversePreOrder(nodeToTraverse.leftChild);
		}

		if(nodeToTraverse.rightChild != null)
		{
			traversePreOrder(nodeToTraverse.rightChild);
		}
	}

	private void traversePostOrder(Node nodeToTraverse) {
		if(nodeToTraverse.leftChild != null)
		{
			traversePostOrder(nodeToTraverse.leftChild);
		}

		if(nodeToTraverse.rightChild != null)
		{
			traversePostOrder(nodeToTraverse.rightChild);
		}
		System.out.println(nodeToTraverse.key);
	}

	public boolean equals(Node root1, Node root2) {
		boolean rootEqual = false;
		boolean lEqual = false;
		boolean rEqual = false;    

		if (root1 != null && root2 != null) {
			rootEqual = root1.getKey() == root2.getKey();

			if (root1.getLeftTree() !=null && root2.getLeftTree() != null) {
				lEqual = equals(root1.getLeftTree(), root2.getLeftTree());
			}
			else if (root1.getLeftTree() == null && root2.getLeftTree() == null) {
				lEqual = true;
			}

			if (root1.getRightTree() != null && root2.getRightTree() != null) {
				rEqual = equals(root1.getRightTree(), root2.getRightTree());
			}
			else if (root1.getRightTree() == null && root2.getRightTree() == null) {
				rEqual = true;
			}

			return (rootEqual && lEqual && rEqual);
		}
		return false;
	} 

	public static  int getLeafCount(Node node)  
	{  
		if(node == null)        
			return 0;  
		if(node.getLeftTree() == null && node.getRightTree() == null)       
			return 1;             
		else  
			return getLeafCount(node.getLeftTree())+ getLeafCount(node.getRightTree());       
	}  

	public boolean isValidBST(Node root) {
		return isValidBST(root, Double.NEGATIVE_INFINITY, Double.POSITIVE_INFINITY);    
	}

	public boolean isValidBST(Node p, double min, double max){
		if(p==null) 
			return true;

		if(p.getKey() <= min || p.getKey() >= max)
			return false;

		return isValidBST(p.getLeftTree(), min, p.getKey()) && isValidBST(p.getRightTree(), p.getKey(), max);
	}

	public static Node mirrorOf(Node rootNode) {
		if (rootNode == null) {
			return rootNode;
		} else {
			Node temp = rootNode.rightChild;
			rootNode.rightChild = rootNode.leftChild;
			rootNode.leftChild = temp;
			mirrorOf(rootNode.rightChild);
			mirrorOf(rootNode.leftChild);
		}
		return rootNode;
	}

	//http://www.geeksforgeeks.org/print-nodes-top-view-binary-tree/
	public void topview(Node root)
	{
		if(root==null)
			return;
		traverse_left(root.leftChild);
		System.out.print(root.key+" ");
		traverse_right(root.rightChild);
	}

	public void traverse_left(Node x)
	{
		if(x==null)
			return;
		traverse_left(x.leftChild);
		System.out.print(x.key+"  ");
	}

	public void traverse_right(Node x)
	{
		if(x==null)
			return;
		System.out.print(x.key+"  ");
		traverse_right(x.rightChild);     
	} 

	//http://www.geeksforgeeks.org/level-order-traversal-in-spiral-form/
	/*
	  Function to print spiral traversal of a tree
void printSpiral(struct node* root)
{
    int h = height(root);
    int i;

    //ltr -> Left to Right. If this variable is set,
      //then the given level is traverseed from left to right.
    bool ltr = false;
    for(i=1; i<=h; i++)
    {
        printGivenLevel(root, i, ltr);

        //Revert ltr to traverse next level in oppposite order
        ltr = !ltr;
    }
}

// Print nodes at a given level
void printGivenLevel(struct node* root, int level, int ltr)
{
    if(root == NULL)
        return;
    if(level == 1)
        printf("%d ", root->data);
    else if (level > 1)
    {
        if(ltr)
        {
            printGivenLevel(root->left, level-1, ltr);
            printGivenLevel(root->right, level-1, ltr);
        }
        else
        {
            printGivenLevel(root->right, level-1, ltr);
            printGivenLevel(root->left, level-1, ltr);
        }
    }
}

int height(struct node* node)
{
    if (node==NULL)
        return 0;
    else
    {
        //compute the height of each subtree
        int lheight = height(node->left);
        int rheight = height(node->right);
 
        // use the larger one
        if (lheight > rheight)
            return(lheight+1);
        else return(rheight+1);
    }
}
	 */
	enum TRAVERSE
	{
		preorder,
		inorder,
		postorder
	}


}
