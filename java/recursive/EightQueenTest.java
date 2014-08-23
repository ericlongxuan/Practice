
public class EightQueenTest{
	static int solutions = 0;
	public static void main(String[] args){
		putColumnNQueen(1, new int[8]);
		System.out.println(solutions);

	}


	public static void putColumnNQueen(int n, int[] positions){
		for(int i = 1;i<=8;i++){
			if(canPut(n,i,positions)){
				positions[n-1] = i;
				if(n==8){
					solutions ++;
					for(int x = 0; x<8;x++)
						System.out.println("x: "+(x+1)+", y: "+positions[x]);
					System.out.println();
				}
				else
					putColumnNQueen(n+1, positions);
			}			
		}
	}

	public static boolean canPut(int n, int wantPutRow, int[] hasPutPositions){
		for(int column=1; column<=n-1; column++){
			int row = hasPutPositions[column-1];
			if (row==wantPutRow||column+wantPutRow==n+row||column+row==n+wantPutRow)
				return false;
		}
		return true;
	}
}