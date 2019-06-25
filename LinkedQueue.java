package queues;
import exceptionclasses.*;

/**
 * <p>Title: The LinkedQueue Class</p>
 *
 * <p>Description: Defines the properties and behaviors of a linked queue.</p>
 *
 * @author Jason Diaz
 */
public class LinkedQueue<E> implements QueueADT<E>
{
	protected Node<E> front, rear; //references to the first and last nodes

	/**
	 * default constructor - creates an empty queue
	 */
	public LinkedQueue()
	{
		front = rear = null;
	}

	/**
	 * enqueue method - adds the specified item to the rear of the queue
	 * @param newItem a reference to the item to be added to the queue
	 */
	public void enqueue (E newItem)
	{
		Node <E> current = new Node<E>(newItem);
		if(isEmpty())
		{
			front = rear = current;
		}
		else
		{
			rear.setNext(current);
			rear = current;
		}	
	}

	/**
	 * dequeue method - removes the item at the front of the queue
	 * @return a reference to the item removed from the front of the queue
	 * @throws an QueueException if the queue is empty
	 */
	public E dequeue()
	{

		if(isEmpty())
		{
			throw new QueueException("Queue is empty!");
		}
		E current = front.getItem();
		if(front == rear)
		{
			front = rear = null;
			return current;
		}
		else
		{
			front = front.getNext();
			return current;
		}
	}

	/**
	 * front method - returns a reference to the item at the front of the queue
	 * without removing it from the queue
	 * @return a reference to the item at the front of the queue
	 * @throws an QueueException if the queue is empty  
	 */
	public E front() 
	{
		if(isEmpty())
		{
			throw new QueueException(" Queue is empty!");
		}
		return front.getItem();
	}

	/**
	 * isEmpty method - determines whether or not the queue is empty
	 * @return true if the queue is empty; false if the queue is not empty
	 */
	public boolean isEmpty()
	{
		return (front == null);
	}

	/**
	 * size method - returns a count of the number of items in the queue
	 * @return the number of items in the queue
	 */
	public int size()
	{
		Node<E> current = front;
		int counter = 0;
		while(current != null)
		{
			counter++;
			current = current.getNext();
		}

		return counter;
	}

	/**
	 * search method - accepts a reference to the item to search for and returns the 1-based position of the item if it is found,
	 * otherwise -1 is returned.
	 * @param item the reference to the item were searching for.
	 * @return int which is the 1-based position of the item or -1 if the item was not found.
	 */
	public int search(E item)
	{
		int counter = 1;
		Node<E> current = front;
		if(isEmpty())
		{
			return -1;
		}
		while(!current.getItem().equals(item))
		{
			counter++;
			current = current.getNext();

			if(counter>size())
			{
				return-1;
			}
		}

		return counter;

	}

	public E removeLast()
	{
	Node<E> current = front;
	Node<E> temp = new Node();
		if(isEmpty())
		{
			throw new QueueException("Queue is empty!");
		}
		if(front == rear)
		{
			temp = front;
			front = rear = null;
			return temp.getItem();
		}
		while(current.getNext().getNext() != null)
		{
		current = current.getNext();
		}
			rear = current;
			temp = current.getNext();
			current.setNext(null);
			return temp.getItem();
		
		}

	/**
	 * toString method - returns a String representing the state of the queue
	 * @return a string containing all items in the queue
	 */
	public String toString()
	{
		String str = new String();
		Node<E> current = front;

		while(current != null)
		{
			str += current.getItem().toString() + "\n";
			current = current.getNext();
		}

		return str;
	}
}
