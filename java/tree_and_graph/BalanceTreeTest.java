public class BalanceTreeTest{
	/**
	Implement a function to check if a tree is balanced. 
	For the purposes of this question, a balanced tree is defined 
	to be a tree such that no two leaf nodes differ 
	in distance from the root by more than one.
	*/
	public static void main(String[] args){
		BinaryTreeNode t1 = new BinaryTreeNode(1);
		BinaryTreeNode t1l = new BinaryTreeNode(2);
		BinaryTreeNode t1r = new BinaryTreeNode(3);
		t1.left = t1l;
		t1.right = t1r;
		System.out.println(isBinaryBalance(t1));

		t1l.left = new BinaryTreeNode(4);
		System.out.println(isBinaryBalance(t1));

		t1l.left.left = new BinaryTreeNode(5);
		System.out.println(isBinaryBalance(t1));

	}

	public static boolean isBinaryBalance(BinaryTreeNode node){
		if(maxDepth(node) - minDepth(node) <= 1)
			return true;
		else
			return false;

	}

	private static int maxDepth(BinaryTreeNode node){
		if(node==null){
			return 0;
		}
		return 1 + Math.max(maxDepth(node.left), maxDepth(node.right));
	}

	private static int minDepth(BinaryTreeNode node){
		if(node==null){
			return 0;
		}
		return 1 + Math.min(minDepth(node.left), minDepth(node.right));
	}


}