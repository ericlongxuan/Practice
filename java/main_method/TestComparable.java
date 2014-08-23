import java.util.*;

public class TestComparable {

	/**
	 * @param args
	 */
	public void compare() {
		PersonBean[] p = { new PersonBean(20, "Tom"),
				new PersonBean(20, "Jeff"), 
				new PersonBean(30, "Mary"),
				new PersonBean(20, "Ada"), 
				new PersonBean(40, "Walton"),
				new PersonBean(61, "Peter"), 
				new PersonBean(20, "Bush") };
		Arrays.sort(p);
		System.out.println("after sort:\n" + Arrays.toString(p));
		AlphDesc ad = new AlphDesc();
		Arrays.sort(p, ad);
		System.out.println("after sort2:\n" + Arrays.toString(p));
	}

	public static void main(String[] args) {
		TestComparable tc = new TestComparable();
		tc.compare();
	}

}