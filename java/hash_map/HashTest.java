import java.util.HashMap;

public class HashTest{
	public static void main(String[] args){
		HashMap<String , Double> map = new HashMap<String , Double>();   
		map.put("Chinese" , 80.0);   
		map.put("Maths" , 89.0);   
		map.put("English" , 78.2);   
		System.out.print(map);
	}
}
