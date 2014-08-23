import java.util.Comparator;
import java.util.Arrays;

class AnagramComparator implements Comparator<String>{
	public int compare(String s1, String s2){
		char[] cs1 = s1.toCharArray();
		char[] cs2 = s2.toCharArray();
		Arrays.sort(cs1);
		Arrays.sort(cs2);
		String sortedS1 = new String(cs1);
		String sortedS2 = new String(cs2);
		return sortedS1.compareTo(sortedS2);
	}
}

public class ComparatorTest{
	public static void main(String[] args){
		AnagramComparator ac = new AnagramComparator();
		String[] ss = new String[]{"qwas", "gwgzvz", "swaq", "gsgd", "ihodsa", "swqa", "aqsw"};
		Arrays.sort(ss, ac);
		for(String s: ss)
			System.out.println(s);
	}
}