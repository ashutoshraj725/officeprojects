package collection_programs;

import java.util.TreeMap;

public class P25SearchValueInTreeMap {

	public static void main(String[] args) {
		TreeMap<Integer, String> tm = new TreeMap<>();
		tm.put(1, "India");
		tm.put(3, "Australia");
		tm.put(2, "Canada");
		tm.put(4, "China");
		tm.put(5, "Brazil");		
		System.out.println("Original TreeMap : "+tm);
		
		System.out.println("Contains Value ? : "+tm.containsValue("India"));
		System.out.println("Contains Value ? : "+tm.containsValue("Pakistan"));
	}

}
