/*
ID: weichen3
LANG: JAVA
TASK: sprime
*/

/*
Executing...
   Test 1: TEST OK [0.108 secs, 31852 KB]
   Test 2: TEST OK [0.115 secs, 30540 KB]
   Test 3: TEST OK [0.130 secs, 30540 KB]
   Test 4: TEST OK [0.108 secs, 32588 KB]
   Test 5: TEST OK [0.108 secs, 31564 KB]
*/

import java.util.*;
import java.io.*;

class sprime{
	//define data stracture
	static int digit;
	static int to;
	static SortedSet<Integer>[] candidates = new TreeSet[8];

	public static void main(String[] args) throws IOException{
		//read
		StreamTokenizer cin = new StreamTokenizer(new BufferedReader(new FileReader("sprime.in")));
		cin.nextToken();
		digit = (int)cin.nval;

		//initialize
		initialize();

		//print
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("sprime.out")));
		for (Iterator<Integer> it = candidates[digit-1].iterator(); it.hasNext();) {
			int c = it.next();
			out.println(c);
		}
		out.close();   // close the output file
    	System.exit(0);  
    }

	public static void initialize(){
		candidates[0] = new TreeSet<Integer>();
		candidates[0].add(2);
		candidates[0].add(3);
		candidates[0].add(5);
		candidates[0].add(7);

		for (int i=1; i<8; i++){
			candidates[i] = new TreeSet<Integer>();
			for (Iterator<Integer> it = candidates[i-1].iterator(); it.hasNext();) {
				int c = it.next();
				int d = c*10+1;
				if(isPrime(d))
					candidates[i].add(d);
				d = c*10+3;
				if(isPrime(d))
					candidates[i].add(d);
				d = c*10+5;
				if(isPrime(d))
					candidates[i].add(d);
				d = c*10+7;
				if(isPrime(d))
					candidates[i].add(d);
				d = c*10+9;
				if(isPrime(d))
					candidates[i].add(d);
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



