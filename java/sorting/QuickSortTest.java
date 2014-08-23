import java.util.Arrays;

public class QuickSortTest{
	public static void main(String[] args){
		int [] nums = new int[]{2,4,6,3,1,5,7,8,4,2,5,6,11,5,2,3,5,33,55,322,11,1,3};
		sort(nums, 0, nums.length-1);
		System.out.print(Arrays.toString(nums));

		nums = new int[]{9,8,7,6,5,4,3,2,1};
		sort(nums, 0, nums.length-1);
		System.out.print(Arrays.toString(nums));

		nums = new int[]{1,2,3,4,5,6,7,8,9};
		sort(nums, 0, nums.length-1);
		System.out.print(Arrays.toString(nums));
	}

	public static void swap(int[] nums, int m, int n){
		if(m==n)
			return;
		int temp = nums[m];
		nums[m] = nums[n];
		nums[n] = temp;
	}

	public static void sort(int[] nums, int start, int end){
		if(start>=end)
			return;
		else{
			int c = start; //the position of main element
			int m = start + 1; 
			int n = end;

			while(m <= n){
				if(nums[m] < nums[c])
					m++;
				else if(nums[n] > nums[c])
					n--;
				else {
					if(m < n)
						swap(nums, m, n);
					m++;
					n--;
				}
			}

			swap(nums, c, n);
			sort(nums, start, n-1);
			sort(nums, n+1, end);
		}
	}
}