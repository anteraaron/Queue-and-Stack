

/**
 * Linked implementation of Queue
 * 
 * @author Anter Aaron M. Custodio
 *
 */

public class LinkedQueue<E> implements Queue<E> {

	/**
	 *Declaring "head" with the complex data type Node<E>
	 */
	 private Node<E> head;

	/**
	 * Calculates the length of the Linked Queue
	 * @param temp temporary pointer needed to count the number of nodes
	 * @param ctr counter for the nodes
	 */
	@Override
	public int size() {
		int ctr =0;
		Node<E> temp = head;
		while(temp!=null){
			temp = temp.next;
			ctr++;
		}
		return ctr;
	}

	/**
	 * @return true if node is empty/null
	 */
	@Override
	public boolean isEmpty() {
		return head == null;
	}

	/**
	 * gets the first element in the queue. Needed function in the dequeue
	 * @throws QueueEmptyException if the queue is empty
	 */
	@Override
	public E front() throws QueueEmptyException {
		if(head == null)
			throw new QueueEmptyException("Queue underflow.");
	      return head.data;
	}
	
	/**
	 * Enqueue or adds and element at the end of the queue
	 * If the queue is empty, adds the element at the beginning of the queue
	 * @param tmp loops until it reaches the end, then inserts after the last element
	 */
	@Override
	public void enqueue(E element) {
		
		if( head == null)
			 head = new Node<E>(element, head);
	      else
	      {
	         Node<E> tmp = head;
	         while(tmp.next != null) tmp = tmp.next;

	         tmp.next = new Node<E>(element, null);
	      }
		
	}
	/**
	 * deletes/removes the first inputted item(by using the function front()) in the queue since it's FIFO
	 * @param tmp calls the function front to check if the queue is empty, if not, return the first element in the queue
	 * @throws QueueEmptyException if the queue is empty
	 */
	@Override
	public E dequeue() throws QueueEmptyException {
		  E tmp = front();
	      head = head.next;
	      return tmp;
	}
}
