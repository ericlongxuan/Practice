import java.io.*;
import java.util.*;

//haha
class Shift
{
	public static void main (String[] args) throws Exception
	{
		Scanner cin=new Scanner(System.in);
                    int a=cin.nextInt(),b=cin.nextInt();
                    System.out.println(a+b);

		int test[]=new int[10];
		for (int i =0;i<10 ;i++ ) {
		 	test[i]=i+1;
		 } 
		



		for (int i =0;i<10 ;i++ ) {
		 	System.out.print(test[i]);
		 }
		
	}


	public static void doShift(int[] a, int count)
	{
		count%=a.length;
	}

	public static void reverse(int[] a)
	{
		for (int i=0,j=a.length; i<j; i++,j--) {
			int temp = a[i];
			a[i]=a[j];
			a[j]=temp;
		}
	}
}