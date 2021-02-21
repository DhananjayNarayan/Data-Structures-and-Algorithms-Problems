import java.util.*;
import java.io.*;
public class FilesMaps {

	public static void main(String[] args) {
		
		showMap("India.txt");
		
		
	}
 
	public static void showMap(String filename) {
		Map<String, Integer> mp = new HashMap<>();
		mp=ReadMap(filename);
		mp.forEach((key, value) -> System.out.println(key + " : " + value));
		//System.out.println(Arrays.asList(mp)+"\n");
	}
	
	
	public static Map<String, Integer> ReadMap(String filename) 
	{
		Scanner sc = null  ;
		Map<String, Integer> map = new HashMap<>();
		try {
			 sc= new Scanner(new File(filename));
		} catch (FileNotFoundException e) {
			System.out.println("Invalid filename or the file does not exist");
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
