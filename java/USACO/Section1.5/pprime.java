/*
ID: weichen3
LANG: JAVA
TASK: pprime
*/

/*
Executing...
   Test 1: TEST OK [0.180 secs, 30540 KB]
   Test 2: TEST OK [0.223 secs, 30540 KB]
   Test 3: TEST OK [0.209 secs, 30540 KB]
   Test 4: TEST OK [0.209 secs, 30540 KB]
   Test 5: TEST OK [0.187 secs, 30540 KB]
   Test 6: TEST OK [0.194 secs, 32588 KB]
   Test 7: TEST OK [0.187 secs, 31564 KB]
   Test 8: TEST OK [0.223 secs, 30540 KB]
   Test 9: TEST OK [0.223 secs, 30540 KB]

   Here are the test data inputs:

------- test 1 ----
5 500
------- test 2 ----
750 14000
------- test 3 ----
123456 1123456
------- test 4 ----
97000 1299000
------- test 5 ----
9878210 9978210
------- test 6 ----
9902099 9902100
------- test 7 ----
7 10000000
------- test 8 ----
1333331 9743479
------- test 9 ----
5 100000000
*/

import java.util.*;
import java.io.*;

class pprime{
	//define data stracture
	static int from;
	static int to;
	static SortedSet<Integer> candidates = new TreeSet<Integer>();

	public static void main(String[] args) throws IOException{
		//read
		StreamTokenizer cin = new StreamTokenizer(new BufferedReader(new FileReader("pprime.in")));
		cin.nextToken();
		from = (int)cin.nval;
		cin.nextToken();
		to = (int)cin.nval;

		//initialize
		initialize();

		//print
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("pprime.out")));
		for (Iterator<Integer> it = candidates.iterator(); it.hasNext();) {
			int c = it.next();
			if(c>=from && c<=to)
				if(isPrime(c))
					out.println(c);
		}
		out.close();   // close the output file
    	System.exit(0);  
    }

	public static void initialize(){
		for(int d0 = 0; d0<=9; d0++){
			for(int d1 = 0; d1<=9; d1++){
				for(int d2 = 0; d2<=9; d2++){
					for(int d3 = 0; d3<=9; d3++){
						int c1 = d0 + 10 * d1 + 100 * d2 + 1000 * d3 + 10000 * d3 + 100000 * d2 + 1000000 * d1 + 10000000 * d0;
						while(c1!=0 && c1%10==0)
							c1/=10;
						candidates.add(c1);
						int c2 = d0 + 10 * d1 + 100 * d2 + 1000 * d3 + 10000 * d2 + 100000 * d1 + 1000000 * d0;
						while(c2!=0 && c2%10==0)
							c2/=10;
						candidates.add(c2);
					}
				}
			}
		}
	}

	public static boolean isPrime(int c){
		if(c%2==0)
			return false;
		for(int i= 3; i<=Math.sqrt(c); i+=2){
			if(c%i==0)
				return false;
		}
		return true;
	} 

}



