public class BinarySearchTest{
	public static void main(String[] args){
		int[] nums = new int[]{1,2,4,6,8,9,10,22,44,55,62,75};
		int index = search(nums, 0, nums.length-1, 8);
		System.out.println(index);

	}

	public static int search(int[] nums, int start, int end, int value){
		if(start > end)
			return -1;

		int mid = (start+end)/2;
		if(nums[mid] == value)
			return mid;
		else if (nums[mid] > value){
			int rLeft = search(nums, start, mid-1, value);
			if(rLeft != -1)
				return rLeft;
		}
		else{
			int rRight = search(nums, mid+1, end, value);
			if(rRight != -1)
				return rRight;
		}
		return -1;
	}
}