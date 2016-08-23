/**
 * Thrown when a priority queue cannot fulfill the requested operation
 * because it is empty.
 * @author Roberto Tamassia
 */
public class EmptyPriorityQueueException  extends RuntimeException {
	
	private static final long serialVersionUID = 1L;

public EmptyPriorityQueueException (String message) {
    super (message);
  }
}