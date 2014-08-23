public class FibonacciTest{
	static int[] nums = new int[100];

	public static void main(String[] args){
		int n =Integer.parseInt(args[0]);
		int nf = getFibonacci(n);
		System.out.println(nf);

		nf = getFibonacciDP(n);
		System.out.println(nf);
	}

	public static int getFibonacci(int n){
		if (n==1)
			return 1;
		else if (n==2)
			return 1;
		else
			return getFibonacci(n-1) + getFibonacci(n-2);
	}

	public static int getFibonacciDP(int n){
		if (n==1 || n==2){
			System.out.println("n"+n+"=1");
			return 1;
		}
		else{
			if(nums[n-1]!=0)
				return nums[n-1];

			int a = nums[n-3];
			int b = nums[n-2];
			if(a!=0&&b!=0){
				System.out.println("n"+n+"="+a+"+"+b);
				nums[n-1]=a+b;
				System.out.println(nums[n-1]);
				return nums[n-1];
			}
			else if (a!=0){
				System.out.println("n"+n+"="+a+"+n"+(n-1));
				nums[n-1]=a+getFibonacciDP(n-1);
				System.out.println(nums[n-1]);
				return nums[n-1];
			}
			else if (b!=0){
				System.out.println("n"+n+"=n"+(n-2)+"+"+b);
				nums[n-1]=getFibonacciDP(n-2) + b;
				System.out.println(nums[n-1]);
				return nums[n-1];
			}
			else{
				System.out.println("n"+n+"=n"+(n-1)+"+n"+(n-2));
				nums[n-1]=getFibonacciDP(n-2) + getFibonacciDP(n-1);
				System.out.println(nums[n-1]);
				return nums[n-1];
			}

		}
			
	}
}