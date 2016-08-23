/**
 * Interface for a key-value pair entry
 * 
 * K is the key of the entry
 * V is the value of the entry
 * @author bryann
 *
 */
public interface Entry<K extends Comparable<K>,V> {
	/**
	 * Returns the key stored in this entry
	 * @return key of the entry
	 */
	public K getKey();
	
	/**
	 * Returns the value stored in this entry
	 * @return value of the entry
	 */
	public V getValue();
}