import java.util.Arrays;
import java.lang.ref.Reference;
import java.lang.ref.SoftReference;
import java.lang.ref.WeakReference;
import java.lang.ref.PhantomReference;
import java.lang.ref.ReferenceQueue;
import java.lang.reflect.Field;

public class ReferenceTest{
	public static void main(String[] args){
		testStackString();
		testHeapString();
		testSoft();
		testWeak();
		testPhantom();
	}

	private static void testStackString()
	{
		//stack中内容相同的string放在一个地方
		String s = "dsg";
		String ss = s;
		System.out.println(ss==s);  //true
		s = null;
		System.out.println(ss==s);  //false
		s="dsg";
		System.out.println(ss==s);  //true
	}


	private static void testHeapString()
	{
		String s = new String("adsf");
		String ss = s;
		System.out.println(ss==s);  //true
		s = null;
		System.out.println(ss==s);  //false
		s="adsf";
		System.out.println(ss==s);  //false
		s = new String("adsf");
		System.out.println(ss==s);  //false
		System.out.println(ss.equals(s));  //true
	}

	private static void testSoft()
	{
		String s = new String("adsf");
		SoftReference<String> sSoft = new SoftReference<String>(s);
		System.out.println(sSoft.get()==s);  //true
		System.out.println(sSoft.get().equals(s));  //true
		s = null;
		//when s is set to null, ss is still referenced to the array abject
		System.out.println(s);  //null
		System.out.println(sSoft.get());  //adsf
		System.gc();
		System.out.println(sSoft.get());  //still: adsf, memory is enough, not be cleaned

		//this aSoft is not a strong ref and will be cleaned if there is not enough memory
	}


	private static void testWeak()
	{
		String s = new String("adsf");
		WeakReference<String> sWeak = new WeakReference<String>(s);
		System.out.println(sWeak.get()==s);  //true
		System.out.println(sWeak.get().equals(s));  //true
		s = null;
		//when s is set to null, ss is still referenced to the array abject
		System.out.println(s);  //null
		System.out.println(sWeak.get());  //adsf
		System.gc();
		System.out.println(sWeak.get());  //null, be cleaned even the memory is enough
		/**
		So, 如果你希望能随时取得某对象的信息，但又不想影响此对象的垃圾收集，
		那么你应该用 Weak Reference 来记住此对象，而不是用一般的 reference。
		这个ref可以用来观察对象什么时候被清除哦。
		*/

		//this aSoft is not a strong ref and will be cleaned if there is not enough memory
	}

	public static void testPhantom()
	{
		PersonBean pb = new PersonBean(10,"dd");
		String s = new String("asdf");
		System.out.println(s.getClass() + "@" + s.hashCode());
		final ReferenceQueue rq = new ReferenceQueue<String>();

		// JAVA reflection
		Field[] fields = s.getClass().getDeclaredFields();
        for(int i = 0; i < fields.length; i++) {
           System.out.println("Field = " + fields[i].toString());
           try{
           	fields[i].setAccessible(true);
           	System.out.println("value = " + fields[i].get(s));
           }
           catch(java.lang.IllegalAccessException e)
           {}
        }

        // JAVA reflection
		fields = pb.getClass().getDeclaredFields();
        for(int i = 0; i < fields.length; i++) {
           System.out.println("Field = " + fields[i].toString());
           try{
           	fields[i].setAccessible(true);
           	System.out.println("value = " + fields[i].get(pb));
           }
           catch(java.lang.IllegalAccessException e)
           {}
        }

		// new Thread(){
		// 	public void run()
		// 	{
		// 		while(true)
		// 		{
		// 			Object o = rq.poll();
		// 			if (o!=null) {
		// 				try{
		// 					Field field = Reference.class.getDeclaredField("referent");
		// 					re
		// 				}
		// 			}
		// 		}
		// 	}
		// }
	}
}