class StaticNestedOuter {
	static class StaticNestedInner {
		void go() {
			System.out.println("Inner class reference is: " + this);
		}
	}
}
 
public class StaticNested {
	public static void main(String[] args) {
		StaticNestedOuter.StaticNestedInner n = new StaticNestedOuter.StaticNestedInner();
		n.go();
	}
}