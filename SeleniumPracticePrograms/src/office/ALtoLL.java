package office;

import java.util.ArrayList;
import java.util.LinkedList;

public class ALtoLL {

	public static void main(String[] args) {
		ArrayList<Integer> list = new ArrayList<>();
		LinkedList<Integer> linkedList = new LinkedList<>(list);
		System.out.println(linkedList);
	}

}
