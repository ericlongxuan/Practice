import java.lang.reflect.Field;
import java.util.Arrays;

public class FinalTest{
	public static void main(String[] args){
		/**
		final的真正含义: 
		        当含有final属性的类被加载进内存并且被实例化的时候，就会为这个final属性分配内存，
	            同时必须对该属性进行初始化，之后不可变。也就是说如果是基本类型的，那么它的值不能再改变；
	            如果是对象，则引用不可变，而对象本身还是可以改变的 
	            final int id = 1; // 基本类型，不可改变
	            final Object obj = new Object(); // 则引用不可改变，但 obj里面的属性可以改变！
	    如果一个对象，他组合的其他对象的状态是可以改变的，那么这个对象很可能不是不可变对象。
	    例如一个Car对象，它组合了一个Wheel对象，虽然这个Wheel对象声明成了private final 的，
	    但是这个Wheel对象内部的状态可以改变， 那么就不能很好的保证Car对象不可变。
	    */
		final char[] a = new char[]{'h','o','g','e'};
		System.out.println(Arrays.toString(a));
		a[3]='0';
		System.out.println(Arrays.toString(a));

		final char[] b = {'h','o','g','e'};
		System.out.println(Arrays.toString(b));
		b[3]='0';
		System.out.println(Arrays.toString(b));
	}
}
