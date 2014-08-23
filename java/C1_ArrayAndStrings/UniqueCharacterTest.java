public class UniqueCharacterTest{
	public static void main(String[] args){
		String s = "asdfa";
		System.out.println(isUnique(s));
		s = "asdfhtgj";
		System.out.println(isUnique(s));
	}

	public static boolean isUnique(String s){
		boolean[] alphabet = new boolean[26];
		for(char c: s.toCharArray()){
			if (alphabet[c-'a']){
				return true;
			}
			alphabet[c-'a']=true;
		}
		return false;
	}
}