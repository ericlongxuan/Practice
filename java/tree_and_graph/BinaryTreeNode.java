public class BinaryTreeNode{
	int data;
	BinaryTreeNode left;
	BinaryTreeNode right;

	public BinaryTreeNode(int data){
		this.data = data;
	}

	public static void printInOrder(BinaryTreeNode node){
		if(node!=null){
			printInOrder(node.left);
			System.out.println(node.data);
			printInOrder(node.right);
		}
	}

	public static void printPreOrder(BinaryTreeNode node){
		if(node!=null){
			System.out.println(node.data);
			printPreOrder(node.left);
			printPreOrder(node.right);
		}
	}

	public static void printPostOrder(BinaryTreeNode node){
		if(node!=null){
			printPostOrder(node.left);
			printPostOrder(node.right);
			System.out.println(node.data);
		}
	}
}