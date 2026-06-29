import java.util.HashMap;

public class MapDemo {

	public static void main(String[] args) {
		HashMap<String,String>map=new HashMap<>();
		map.put("Scott","tiger");
		map.put("jack","jill");
		map.put("polo","lili");

		map.put("jack1","rose");
		
		System.out.println("Scott:"+map.get("scott"));
		System.out.println("polo:"+map.get("polo"));
		System.out.println("jack:"+map.get("jack"));
		
		//print wihput manualy 
		System.out.println("-----------------------------");

		System.out.println("print without manually print | ");

		System.out.println("-----------------------------");
		for (String key : map.keySet()) {
		    System.out.println( key + "- " + map.get(key));
		}
		System.out.println("-----------------------------");
		map.forEach((key,value)->System.out.println(key+":"+value));

	}

}
