import java.lang.reflect.Field;

public class ReflectionTest{
	public static void main(String[] args){
		PersonBean pb = new PersonBean(10,"dd");
		String s = new String("asdf");

		System.out.println(s.getClass() + "@" + s.hashCode());

		// JAVA reflection 获取未知类内部结构
		/**
		Field = private final char[] java.lang.String.value
			value = [C@f7e6a96
		Field = private final int java.lang.String.offset
			value = 0
		Field = private final int java.lang.String.count
			value = 4
		Field = private int java.lang.String.hash
			value = 3003444
		*/
		Field[] fields = s.getClass().getDeclaredFields();

		try{
	        for(int i = 0; i < fields.length; i++) {
	           System.out.println("Field = " + fields[i].toString());

	           	fields[i].setAccessible(true);
	           	System.out.println("value = " + fields[i].get(s));
	        }

	        //我们试着改变里面的值 突破private和final
	        Field value = s.getClass().getDeclaredField("value"); 
	        value.setAccessible(true);
	        value.set(s, new char[]{'h','o','g','e','h','o','g','e'});	      
	        System.out.println(s);  // hoge
	        Field count = s.getClass().getDeclaredField("count");
	        count.setAccessible(true);
	        count.set(s, 8);
	        System.out.println(s);  //hogehoge
		           
	    }
        catch(java.lang.IllegalAccessException e)
        {}
        catch(java.lang.NoSuchFieldException e)
        {}



        // JAVA reflection 深层突破
		fields = pb.getClass().getDeclaredFields();
        for(int i = 0; i < fields.length; i++) {
           System.out.println("Field = " + fields[i].toString());
           try{
           	//突破private的限制，将private的field强制为可访问
           	fields[i].setAccessible(true);
           	System.out.println("value = " + fields[i].get(pb));

           	//getType()可取得field的类, 类的比较使用.equals, 其他的类使用类名.class取得类
           	if (fields[i].getType().equals(Integer.class)) {
           		//field的set方法可以直接给对象赋值
           		fields[i].set(pb, 8);
           	}
           	else if(fields[i].getType().equals(String.class)) {
           		fields[i].set(pb, "8");
           	}
           	System.out.println("value = " + fields[i].get(pb));
           }
           catch(java.lang.IllegalAccessException e)
           {}
        }


	}
}