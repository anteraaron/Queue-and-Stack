

/**
 * Array implementation of queue
 * 
 * @author Richard Bryann Chua
 *
 */
public class ArrayQueue<E> implements Queue<E> {
	/**
	 * Array that holds the elements of the queue.
	 */
	private E[] q;
	
	/**
	 * Index of the front of the queue.
	 */
	private int front = 0;
	
	/**
	 * Index of the rear of the queue.
	 */
	private int rear = 0;
	
	/**
	 * Maximum length of the queue
	 */
	private int capacity;
	
	/**
	 * Default size of the array for the queue when 
	 * the size of the array is not specified.
	 */
	private static final int CAPACITY = 100;
	
	/**
	 * Initialize the queue to use an array of default length CAPACITY
	 */
	public ArrayQueue() {
		this(CAPACITY);
	}
	
	/**
	 * Initialize the queue to use an array of given length
	 * 
	 * @param capacity length of the array
	 */
	public ArrayQueue(int capacity) {
		this.capacity = capacity;
		q = (E[]) new Object[capacity]; 
	}

	/* (non-Javadoc)
	 * @see Queue#dequeue()
	 */
	@Override
	public E dequeue() throws QueueEmptyException {
		if (isEmpty())
			throw new QueueEmptyException("Queue underflow");
		else {
			front = (front + 1) % capacity;
			E element = q[front];
			q[front] = null;
			return element;
		}
			
	}

	/* (non-Javadoc)
	 * @see Queue#enqueue(java.lang.Object)
	 */
	@Override
	public void enqueue(E element) throws QueueFullException {
		if (isFull())
			throw new QueueFullException("Queue overflow.");
		rear = (rear + 1) % capacity;
		q[rear] = element;
	}

	/* (non-Javadoc)
	 * @see Queue#front()
	 */
	@Override
	public E front() throws QueueEmptyException {		
		if (isEmpty())
			throw new QueueEmptyException("Queue underflow.");
		return q[front + 1];
	}

	/* (non-Javadoc)
	 * @see Queue#isEmpty()
	 */
	@Override
	public boolean isEmpty() {		
		return (front == rear);
	}

	/* (non-Javadoc)
	 * @see Queue#size()
	 */
	@Override
	public int size() {
		int initialSize = ((rear - front) % capacity);
		return (initialSize + capacity) % capacity;
	}
	
	/**
	 * 
	 * @return true if the queue is already full, false otherwise.
	 */
	private boolean isFull() {
		return (front == (rear + 1) % capacity);
	}

}
