import java.util.ArrayList;

/**
 *Creating HeapPriorityQueue class that implements the PriorityQueue interface using binary heap.
 *
 * @author Anter Aaron M. Custodio(Student#:2011-42733) && Carl Zachery S. Viernes(Student#:2011-29912)
 *B.S. Comsci
 *UP Manila
 *ComSci 123 - Data Structures
 * @param <V> Generic. The data type of Value
 * @param <K> Generic. The data type of key
 *
 */
//@SuppressWarnings("rawtypes")
public class HeapPriorityQueue<K extends Comparable<K>,V> implements PriorityQueue<K,V>{

	public ArrayList<Entry<K,V>> heap;
	/**
	 * This is the InnerClass for the Heap Entries
	 *
	 * @param <K> Generic. The data type of key
	 * @param <V> Generic. The data type of value
	 */
	public static class MyEntry<K extends Comparable<K>,V> implements Entry<K,V> {
		  public K key;
		  public V value;
		  public MyEntry(K key, V value){ 
			  this.key = key; 
			  this.value = value; 
		  }
		  public K getKey(){
			  return key; 
		  }
		  public V getValue(){ 
			  return value;
		  }
		  public String toString(){ 
			  return "(" + key  + "," + value + ")"; 
		  }
		  
	}
	/**
	 * Initialize the heap
	 */
	public HeapPriorityQueue(){
		heap = new ArrayList<Entry<K,V>>();
	}
	
	public static void main(String[] args) {
		
	}
	/**
	 * Returns the size of this heap starting from index 1 to n.
	 * @return int heap.size()
	 */
	@Override
	public int size() {
		return heap.size();
	}
	/**
	 * Returns true if the size of the heap is equals to zero otherwise, false.
	 * @return boolean True if empty otherwise false
	 */
	@Override
	public boolean isEmpty() {
		if(heap.isEmpty())
			return true;
		else
			return false;
	}
/**
 * 
 * @return Entry that has the highest priority key
 * @throws EmptyPriorityQueueException throw if the Queue is empty
 */
	@Override
	public Entry<K,V> max() throws EmptyPriorityQueueException {
		
		if(isEmpty())
			throw new EmptyPriorityQueueException("Priority Queue is Empty!");
	        return heap.get(0);
	}


	/**
	 * 
	 * @param key the priority key of the key to be inserted
	 * @param value the value of the entry to be inserted
	 * @return the entry that was inserted
	 * @throws InvalidKeyException
	 */
	@Override
	public Entry<K, V> insert(K key, V value)
			throws InvalidKeyException {
		
		Entry<K,V> entry = new MyEntry<K,V>(key,value);
		heap.add(entry);
		heapify(size()-1);
		return entry;
	}
	/**
	 * heapifies the tree
	 * @param i the size of the heap. (heap.size()-1) because upheap should begin in index 0.
	 */
	public void heapify(int i) {
		while (i > 1) {
			if (heap.get(i / 2).getKey().compareTo(heap.get(i).getKey()) <= 0)
				break;
			swap(i / 2, i);
			i = i / 2;
		}
	}
/**
 * Performs maxHeap sorting
 * @param i the first element of the heap which is zero.
 */
	public void maxHeapify(int i) {
		int size = size()-1;
		int smallerChild;
		while (size >= 2 * i) {
			smallerChild = 2 * i;
			if (size >= 2 * i + 1)
				if (heap.get(2 * i + 1).getKey()
						.compareTo(heap.get(2 * i).getKey()) < 0)
					smallerChild = 2 * i + 1;
			if (heap.get(i).getKey().compareTo(heap.get(smallerChild).getKey()) <= 0)
				break;
			swap(i, smallerChild);
			i = smallerChild;
		}
	}
/**
 * swaps the position of the two keys in the parameter
 * @param j first key 
 * @param i second key
 */
	public void swap(int j, int i) {
		Entry<K, V> temp;
		temp = heap.get(j);
		heap.set(j, heap.get(i));
		heap.set(i, temp);
	}
	/**
	 * Removes and returns an entry with maximum priority key
	 * 	
	 * @return entry that has the highest priority key
	 * @throws EmptyPriorityQueueException if queue is empty
	 */
	@Override
	public Entry<K, V> extractMax() throws EmptyPriorityQueueException {

        if (size() == 1)
            return heap.remove(0);

        Entry<K,V> max = max();
        heap.set(0, heap.remove(size()-1));
        maxHeapify(0);
        return max;
		
	}
	/**
	 * Prints the elements of the heap
	 * @return the elements of the heap in (Key, Value) formats
	 */
	@Override
	public String toString() {
        return heap.toString();
    }

}
