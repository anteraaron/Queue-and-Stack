public class HeapPriorityQueueDriver {
	public static void main(String[] args) {
		PriorityQueue<Integer, String> queue = new HeapPriorityQueue<Integer, String>();
		queue.insert(0, "Zero");
		System.out.println("Key, Value:(Not in order, heapified order only)  " + queue.toString());//this outputs in (key,value) format
		queue.insert(10, "Ten");
		System.out.println("Key, Value:(Not in order, heapified order only)  " + queue.toString());//this outputs in (key,value) format
		queue.insert(1, "One");
		System.out.println("Key, Value:(Not in order, heapified order only)  " + queue.toString());//this outputs in (key,value) format
		queue.insert(5, "Five");
		System.out.println("Key, Value:(Not in order, heapified order only)  " + queue.toString());//this outputs in (key,value) format
		queue.insert(3, "Three");
		System.out.println("Key, Value:(Not in order, heapified order only)  " + queue.toString());//this outputs in (key,value) format
		queue.insert(7, "Seven");
		System.out.println("Key, Value:(Not in order, heapified order only)  " + queue.toString());//this outputs in (key,value) format
		queue.insert(9, "Nine");
		System.out.println("Key, Value:(Not in order, heapified order only)  " + queue.toString());//this outputs in (key,value) format
		System.out.println("Size of Queue: " + queue.size());//returns size of heap
		System.out.println("Maximum Priority: " + queue.max());//returns the highest priority queue
		System.out.println("Is the Queue Empty: " + queue.isEmpty());//returns true if empty otherwise false
		while (!queue.isEmpty()) {
			System.out.println(queue.extractMax()); //extracts and remove 
		} // end while
		
		
	} // end main
}