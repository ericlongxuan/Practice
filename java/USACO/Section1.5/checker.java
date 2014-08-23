/*
ID: weichen3
LANG: JAVA
TASK: checker
*/

/*
Executing...
   Test 1: TEST OK [0.130 secs, 30540 KB]
   Test 2: TEST OK [0.086 secs, 30540 KB]
   Test 3: TEST OK [0.245 secs, 30540 KB]
   Test 4: TEST OK [0.252 secs, 30540 KB]
   Test 5: TEST OK [0.274 secs, 30540 KB]
   Test 6: TEST OK [0.353 secs, 30540 KB]
   Test 7: TEST OK [0.468 secs, 30540 KB]
   Test 8: TEST OK [0.958 secs, 30540 KB]
*/

import java.util.*;
import java.io.*;


public class checker{
	static int num;
	static int halfNum;
	static int solutions = 0;
	static PrintWriter out;

	public static void main(String[] args) throws IOException{
		//read
		StreamTokenizer cin = new StreamTokenizer(new BufferedReader(new FileReader("checker.in")));
		cin.nextToken();
		num = (int)cin.nval;
		halfNum = num/2;

		//initialize
		out = new PrintWriter(new BufferedWriter(new FileWriter("checker.out")));

		//do 
		putColumnNQueen(1, new int[13], 0);
		
		
		out.println(solutions);
		
		out.close();   // close the output file
    	System.exit(0);  
    }


    private static void putQueen(int n, int row, int[] positions, int occupiedBits){
    	if(canPut(n,row,positions, occupiedBits)){
			positions[n-1] = row;
			if(n==num){
				solutions ++;
				boolean firstColumn = true;
				if(solutions<=3){
					for(int x = 0; x<num;x++){
						if(firstColumn){
							out.print(positions[x]);
							firstColumn=false;
						}
						else
							out.print(" "+positions[x]);
					}
					out.println();
				}		
			}
			else if (n<num)
				putColumnNQueen(n+1, positions, occupiedBits|(1<<(row-1)));
		}
    }

	public static void putColumnNQueen(int n, int[] positions, int occupiedBits){
		//SYMMETRY
		if(n==1){
			if(num<=8){
				for(int i = 1;i<=num;i++){
					putQueen(n,i,positions, occupiedBits);
				}
			}
			else{
				for(int i = 1;i<=halfNum;i++){
					putQueen(n,i,positions, occupiedBits);
				}
				solutions*=2;
				if(num%2 != 0){
					putQueen(n,halfNum+1,positions, occupiedBits);
				}
			}
		}
		else
			for(int i = 1;i<=num;i++){
				putQueen(n,i,positions, occupiedBits);
			}
		
	}

	public static boolean canPut(int n, int wantPutRow, int[] hasPutPositions, int occupiedBits){
		//用一个位数字表示已经占用的行，避免了一次循环
		if(((1<<(wantPutRow-1))&occupiedBits)!=0){
			return false;
		}
					
		for(int column=1; column<=n-1; column++){
			int row = hasPutPositions[column-1];
			if (row==wantPutRow || column+wantPutRow==n+row||column+row==n+wantPutRow)
				return false;
		}

		return true;	
	}
}