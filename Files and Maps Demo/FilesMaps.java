import java.util.*;
import java.io.*;
public class FilesMaps {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Map<String, Integer> mp = new HashMap<>();
		mp=ReadMap("India.txt");
		mp.forEach((key, value) -> System.out.println(key + " : " + value));
		//System.out.println(Arrays.asList(map));
		
	}

	public static Map<String, Integer> ReadMap(String filename) 
	{
		Scanner sc = null  ;
		Map<String, Integer> map = new HashMap<>();
		try {
			 sc= new Scanner(new File("India.txt"));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		while(sc.hasNext()) {
			String a=sc.next();
			int b=sc.nextInt();
			map.put(a, b);
			//System.out.printf("%s %d\n",a,b);
		}
		return map;
	}
}
