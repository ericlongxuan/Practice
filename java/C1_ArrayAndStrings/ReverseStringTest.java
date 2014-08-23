public class ReverseStringTest{
	public static void main(String[] args){
		char[] cs= new char[5];
		for(int i = 0; i<cs.length-1; i++){
			cs[i] = (char)('a'+i);	
			System.out.println(cs[i]);		
		}
		cs[cs.length-1] = '\0';
		System.out.println(cs[cs.length-1] );
		
		reverse(cs);

		for(int i = 0; i<cs.length; i++){	
			System.out.println(cs[i]);		
		}

		cs= new char[6];
		for(int i = 0; i<cs.length-1; i++){
			cs[i] = (char)('a'+i);	
			System.out.println(cs[i]);		
		}
		cs[cs.length-1] = '\0';
		System.out.println(cs[cs.length-1] );
		
		reverse(cs);

		for(int i = 0; i<cs.length; i++){	
			System.out.println(cs[i]);
		}
	}

	public static void reverse(char[] cs){
		for(int i=0, end=cs.length-2; i<end; i++, end--){
			char temp = cs[i];
			cs[i] = cs[end];
			cs[end] = temp;
		}
	}
}