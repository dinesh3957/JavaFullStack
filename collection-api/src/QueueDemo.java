import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

public class QueueDemo {

	public static void main(String[] args) {
		Queue<String> que = new LinkedList<String>();
		que.offer("Apple");
        que.offer("Banana");
        que.offer("Cherry");
        
        System.out.println(que.peek());//fetch value but not remove 
        while(!que.isEmpty()) {
        	   System.out.println(que.poll()); //fetch value and remove from queue
        }
        // write code to implement Dequeue in this example 
        
        Deque<String>dq=new LinkedList<String>();
        dq.offerLast("Apple");   // Adds to the tail (same as offer)
		dq.offerFirst("Banana");  // Adds to the head
		dq.offerLast("Cherry");  // Adds to the tail
		
		System.out.println("First element: " + dq.peekFirst()); 
		System.out.println("Last element: " + dq.peekLast());  
		System.out.println("--- Processing ---");
		
		
		while(!dq.isEmpty()) {
			// Alternating: remove from front, then remove from back if not empty
			System.out.println("Removed from front: " + dq.pollFirst()); 
			
			if(!dq.isEmpty()) {
				System.out.println("Removed from back: " + dq.pollLast());
			}
		}
        
	}

}
