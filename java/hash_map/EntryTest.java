import java.util.*;
import java.util.Map.Entry;

public class EntryTest {  
	public static void main(String[] args) {
		//create a kind of map   
		//HashMap的hash函数是对key对像的hashCode进行hash,并把Null keys always map to hash 0.
		//So 基本类型(int之类) 不能做KEY值。if it is a int, use Integer Object
		Map<Integer,String> iiMap = new HashMap<Integer,String>();   
		for(int i=0;i<10;i++)   {
			iiMap.put(i, "String"+i); 
		}   
		//Map是java中的接口，HashMap uses this interface
		//Map.Entry是Map的一个内部接口。java.util.Map.Entry接口主要就是在遍历map的时候用到
		//Every map can use .keySet() to get the set of keys in Map。
		//Every map can use .entryMap() to get a set of Map.Entry。
		//thus we can use the getKey(),getValue in Entry<K,V> to fetch the values.

		//遍历法1，使用entrySet()返回set, foreach遍历, entry.getKey() getValue()取键值
		for( Entry<Integer, String> e : iiMap.entrySet()) {
			System.out.println("key:"+e.getKey());
			System.out.println("value:"+e.getValue());   
		}   
		//遍历法2，使用entrySet()返回set, iterator遍历
		for( Iterator<Entry<Integer, String>> i = iiMap.entrySet().iterator(); i.hasNext(); ){    
			Entry<Integer, String> e = i.next();
			System.out.println("key:"+e.getKey());
			System.out.println("value:"+e.getValue());
		}
		
        //遍历法3，使用keySet()返回Key的set, iterator遍历Key, map.get(key)取value
        Set<Integer> keySet= iiMap.keySet();
        for (Iterator<Integer> i = keySet.iterator(); i.hasNext(); ){
        	Integer k = i.next();
        	System.out.println("key:"+k);
        	System.out.println("value:"+iiMap.get(k));
        }

        //遍历法4，如果只要value, 使用map.values()返回value的Collection集合
        Collection<String> c = iiMap.values();
        for (Iterator<String> i = c.iterator(); i.hasNext(); ) {
        	//iterator 的next返回里面的值
        	String value = i.next();
        	System.out.println("value:"+value);
        }
	}
}
