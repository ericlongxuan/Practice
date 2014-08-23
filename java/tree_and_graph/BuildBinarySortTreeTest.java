public class BuildBinarySortTreeTest{
	public static void main(String[] args){
		int[] nums = {1,2,3,4,5,6,7,8,9,10};
		BinaryTreeNode root = build(nums, 0, nums.length -1);
		BinaryTreeNode.printInOrder(root);
		System.out.println();
		BinaryTreeNode.printPreOrder(root);
		System.out.println();
		BinaryTreeNode.printPostOrder(root);
	}

	public static BinaryTreeNode build(int[] nums,  int start, int end){

		if(start > end){
			return null;
		}
		else{
			int mid = (start + end)/2;
			BinaryTreeNode node = new BinaryTreeNode(nums[mid]);
			node.left = build(nums, start, mid-1);
			node.right = build(nums, mid+1, end);
			return node;
		}
	}
}