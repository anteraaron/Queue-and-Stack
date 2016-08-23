/**
 * Interface for the priority queue ADT
 * 
 * K is the key of the entry stored in the priority queue and denotes the priority of the entry.
 * 
 * V is the auxillary data of the entry
 * @author bryann
 *
 */
public interface PriorityQueue<K extends Comparable<K>,V> {
	/**
	 * Returns the number of items in the priority queue
	 * 
	 * @return number of items in the priority queue
	 */
	public int size();
	
	/**
	 * Returns whether the priority queue is empty.
	 * 
	 * @return true if the priority queue is empty. Otherwise, false.
	 */
	public boolean isEmpty();
	
	/**
	 * Returns but does not remove an entry with maximum priority key
	 * 	
	 * @return entry that has the highest priority key
	 * @throws EmptyPriorityQueueException
	 */
	public Entry<K,V> max() throws EmptyPriorityQueueException;
	
	/**
	 * Inserts a key-value pair and returns the entry created.
	 * 
	 * @param key priority key of the entry to be inserted
	 * @param value value of the entry to be inserted
	 * @return entry that was inserted into the priority queue
	 * @throws InvalidKeyException
	 */
	public Entry<K,V> insert(K key, V value) throws InvalidKeyException;
	
	/**
	 * Removes and returns an entry with maximum priority key
	 * 	
	 * @return entry that has the highest priority key
	 * @throws EmptyPriorityQueueException
	 */
	public Entry<K,V> extractMax() throws EmptyPriorityQueueException;
}