import java.util.*;
public class mod4 {
	public static void main(String[] args) {
		// Store 500000 integers in a linked list
		List<Integer> arrayList = new ArrayList<>();
		for (int i = 0; i < 500000; i++) {
			arrayList.add(i);
		}
		LinkedList<Integer> linkedList = new LinkedList<>(arrayList);

		// Time to traversing the list using an iterator 
		long iteratorTimerStart = System.currentTimeMillis();
		ListIterator<Integer> listIterator = linkedList.listIterator();
		while (listIterator.hasNext()) {
			listIterator.next();
		}
		long iteratorTimerEnd = System.currentTimeMillis();

		// Display results of traversing the list using an iterator 
		System.out.println("Time to traverse the list using an iterator: "
			 + (iteratorTimerEnd - iteratorTimerStart) + " millis");

		// Time to traversing the list using the get(index) method 
		long getTimerStart = System.currentTimeMillis();
		for (int i = 0; i < 500000; i++) {
			linkedList.get(i);
		}
		long getTimerEnd = System.currentTimeMillis();

		// Display results of traversing the list using the get(index) method 
		System.out.println("Time to traverse the list using the get(index) method: "
			+ (getTimerEnd - getTimerStart) + " millis");
	}
}