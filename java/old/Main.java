import java.io.*;
import java.util.*;
public class Main
{
	public static void main(String[] args) throws Exception{
		Scanner s = new Scanner(System.in);
		double a;
		double b;
		double c=0;
		for (int i = 0;i<5 ;i++ ) {
			a=s.nextDouble();
			b=s.nextDouble();

			String aString = new Double(a).toSting();
			String bString = new Double(b).toSting();
			aString = aString.replace('.', '');
			bString = bString.replace('.', '');

			int s_a = calShift(a);
			int s_b = calShift(b);
			int shift = s_b+s_a;

			int r[] = new int[100];
			int tempR[] = new int[100];
			for (int i = 0;i<r.length() ;i++ ) {
				r[i]=0;
			}

			int base_pos = 0;
			for (int i = bString.length-1; i>=0; i-- ) {
				for (int j=aString.length-1; j>=0; j-- ) {
					int temp = aString[j]*bString[i];
					base_pos=tempR.length-1 - (bString.length()-1+aString.length()-1-i-j);
					tempR[base_pos]+=temp%10;
					tempR[base_pos-1]+=temp/10;
				}
			}


			System.out.println(c);
		}
	}


	public static int calShift(double a)
	{
		String aString = new Double(a).toSting();
		int pos = aString.length()-1-aString.indexOf(".");.
	}
}