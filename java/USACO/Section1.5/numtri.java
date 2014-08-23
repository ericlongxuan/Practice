/*
ID: weichen3
LANG: JAVA
TASK: numtri
*/

/*
Executing...
   Test 1: TEST OK [0.130 secs, 32240 KB]
   Test 2: TEST OK [0.151 secs, 32588 KB]
   Test 3: TEST OK [0.137 secs, 30540 KB]
   Test 4: TEST OK [0.137 secs, 30540 KB]
   Test 5: TEST OK [0.137 secs, 30540 KB]
   Test 6: TEST OK [0.266 secs, 32588 KB]
   Test 7: TEST OK [0.302 secs, 30540 KB]
   Test 8: TEST OK [0.238 secs, 30540 KB]
   Test 9: TEST OK [0.389 secs, 31564 KB]
*/
//本身题目并不难，基础的dp
//但涉及到java的快速 IO

import java.util.*;
import java.io.*;

class numtri{
	//define data stracture
	static int lineCount;
	static int[][] nums = new int[1000][1000];

	public static void main(String[] args) throws IOException{
		//read
		StreamTokenizer cin = new StreamTokenizer(new BufferedReader(new FileReader("numtri.in")));
		cin.nextToken();
		lineCount = (int)cin.nval;

		for (int i=0; i<lineCount; i++) {
			for(int j=0;j<=i;j++){
				cin.nextToken();
				nums[i][j]=(int)cin.nval;
			}
		}
		
		//initialize
		initialize();

		//do
		dp();

		//print
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("numtri.out")));
		int result = nums[lineCount-1][0];
		for (int j=0; j<lineCount; j++) {
			if(nums[lineCount-1][j]>result)
				result = nums[lineCount-1][j];
		}
		out.print(result);
		out.println();
		out.close();   // close the output file
    	System.exit(0);  
    }

    public static void initialize(){
	}

	public static void dp(){
		for(int i=1; i<lineCount; i++){
			for(int j=0; j<=i; j++){
				if(j==0){
					nums[i][j] = nums[i-1][j] + nums[i][j];
				}
				else if(j==lineCount-1){
					nums[i][j] = nums[i-1][j-1] + nums[i][j];
				}
				else{
					nums[i][j] = max(nums[i-1][j-1], nums[i-1][j]) + nums[i][j];
				}
				
			}
		}
	}

	public static int max(int a,int b)
	{
		return a>b ? a:b;
	}
}