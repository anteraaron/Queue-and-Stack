/**
 * 
 * @author Anter Aaron Custodio
 *
 *This class is used as a complex data type for the nodes in the LinkedQueue class
 * @param <E> can be of any type.
 * @param next points to the next node
 */


public class Node<E> {

	public E data;
	public Node<E> next;
	
	public Node(E data, Node<E> next){
	
		this.data = data;
		this.next = next;
		
	 }

}
