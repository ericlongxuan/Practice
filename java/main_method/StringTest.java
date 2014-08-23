import java.lang.reflect.Field;

public class StringTest{
	public static void main(String[] args){
		String s1 = "aad";
		String s2 = "aad";
		String s4 = new String("aad");

		modify(s1);
		System.out.println(s1);
		System.out.println(s2);

		String s4c=(String) s4.clone();
		modify(s4c);
		System.out.println(s4);

	}

	public static void modify(String s){
		try{
			String s3 = "aad";
			System.out.println(s3==s);

			Field value = s.getClass().getDeclaredField("value"); 
		    value.setAccessible(true);
		    value.set(s, new char[]{'h','o','g','e','h','o','g','e'});	      
	        Field count = s.getClass().getDeclaredField("count");
	        count.setAccessible(true);
	        count.set(s, 8);
	        System.out.println(s);  //hogehoge
	        System.out.println("s3:"+s3);
	    }
	    catch(java.lang.IllegalAccessException e){

	    }
	    catch(java.lang.NoSuchFieldException e)
	    {

	    }
	}

}