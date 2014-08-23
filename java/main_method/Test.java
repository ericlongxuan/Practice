
import java.util.*;

public class Test 
{
    public static void main(String [] args ) 
    {
        int[] a = new int[3];
        for(int i=0; i<2; i++){
        	System.out.println("before loop"+i+": "+Arrays.toString(a));
        	change(a);
        	System.out.println("after loop"+i+": "+Arrays.toString(a));
        }
    }

    static void change(int[] a){
    	a[1]=1;
    }
}