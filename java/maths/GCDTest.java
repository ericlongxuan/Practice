public class GCDTest{
	public static void main(String[] args){
		System.out.print(getGcd(45,30));
		System.out.print(getLcm(45,30));
	}

	public static int getGcd(int a, int b){
		if (a==b)
			return a;
		else if (a<b) {
			int temp = a;
			a = b;
			b = a;
		}
		int temp;
		while(b>=1){
			if((temp = a%b)!=0){
				b = temp;
				a = b;
			}
			else return b;
		}

		return 1;
	}

	public static int getLcm(int a, int b){
		return a * b / (getGcd(a, b));
	}
}