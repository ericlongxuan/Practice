public class MergeSortTest{
	public static void main(String[] args){
		int[] a = new int[9];
		a[0]=1;a[1]=3;a[2]=4;a[3]=5;a[4]=9;
		int[] b = new int[]{2,6,7,8};
		merge(a, b, 5, 4);
		for(int x: a)
			System.out.println(x);
	}

	public static void merge(int[] a, int[] b, int m, int n){
		int k=m+n-1;
		int i = m-1;
		int j=n-1;

		while(k>=0){
			if(i<0){
				a[k--]=b[j--];
			}
			else if (j<0){
				a[k--]=a[i--];
			}
			else if(a[i]>b[j]){
				a[k--]=a[i--];
			}
			else{
				a[k--]=b[j--];
			}
		}
	}
}