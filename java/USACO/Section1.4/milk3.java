/*
ID: weichen3
LANG: JAVA
TASK: milk3
*/

/**
Executing...
   Test 1: TEST OK [0.072 secs, 30540 KB]
   Test 2: TEST OK [0.072 secs, 30540 KB]
   Test 3: TEST OK [0.072 secs, 30540 KB]
   Test 4: TEST OK [0.072 secs, 30540 KB]
   Test 5: TEST OK [0.065 secs, 30540 KB]
   Test 6: TEST OK [0.072 secs, 30540 KB]
   Test 7: TEST OK [0.137 secs, 30540 KB]
   Test 8: TEST OK [0.130 secs, 30540 KB]
   Test 9: TEST OK [0.101 secs, 30540 KB]
   Test 10: TEST OK [0.122 secs, 30540 KB]
**/

import java.util.*;
import java.io.*;

class milk3{
	//define data stracture
	static int[] capacity = new int[3];
	static Queue<Integer> q = new LinkedList<Integer>();
	static HashSet<Integer> visited = new HashSet<Integer>();

	public static void main(String[] args) throws IOException{
		BufferedReader bf = new BufferedReader(new FileReader("milk3.in"));
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("milk3.out")));

		//read in file
		StringTokenizer st = new StringTokenizer(bf.readLine());
		for(int i=0; i<3; i++){
			capacity[i] = Integer.parseInt(st.nextToken());
//			System.out.println(capacity[i]);
		}
		
		//initialize
		initialize();


		//start processing
		while(!q.isEmpty()){
			int current = q.poll();
//			System.out.println("poll: "+Arrays.toString(toAmounts(current)));
			pour(toAmounts(current));
		}

		//print
		SortedSet<Integer> results = new TreeSet<Integer>();
		for(Iterator<Integer> it=visited.iterator(); it.hasNext();){
			int bits = it.next();
//			System.out.println("result: "+Arrays.toString(toAmounts(bits)));
			int[] amounts = toAmounts(bits);
			if(amounts[0] == 0)
				results.add(amounts[2]);
		}
		boolean first = true;
		for(Iterator<Integer> it=results.iterator(); it.hasNext();){
			if(first){
				out.print(it.next());
				first = false;
			}	
			else{
				out.print(" " + it.next());
			}
		}
		out.println();
		out.close();                                  // close the output file
    	System.exit(0);                               // don't omit this!
	}


	public static void initialize(){
		int[] amount = new int[3];
		amount[2] = capacity[2];
		amount[0] = 0;
		amount[1] = 0;
		q.offer(toBits(amount));
		visited.add(toBits(amount));
	}


	public static void pour(int[] amount){
		tryPour(amount.clone(), 0, 1);
		tryPour(amount.clone(), 0, 2);
		tryPour(amount.clone(), 1, 0);
		tryPour(amount.clone(), 1, 2);
		tryPour(amount.clone(), 2, 0);
		tryPour(amount.clone(), 2, 1);
	}

	public static void tryPour(int[] amount, int from, int to){
//		System.out.println("from " + from + " to "+ to);
		int diff = Math.min(amount[from], capacity[to] - amount[to]);
//		System.out.println("diff: "+ diff);
		if(diff>0){
			amount[from] -= diff;
			amount[to] += diff;
			int bits = toBits(amount);
			if(validate(bits)){
				q.offer(bits);
				visited.add(bits);
			}	
		}	
	}

	public static boolean validate(int newAmountHash){
		if(!visited.contains(newAmountHash)){
			visited.add(newAmountHash);
			return true;
		}
		return false;
	}

	public static int toBits(int[] amount){
		return ((amount[0] << 5 | amount[1]) << 5) | amount[2];
	}

	public static int[] toAmounts(int bits){
		int mask = 31;
		int[] amount = new int[3];
		amount[0] = bits >> 10;
		amount[1] = (bits>>5)&mask;
		amount[2] = bits&mask;
		return amount;
	}
}