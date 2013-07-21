package jp.co.wap.exam;

import java.util.NoSuchElementException;

public class PersistentQueue<E> {

    private final PersistentList<E> front;
    private final PersistentList<E> back;
    
    public PersistentQueue(){
    	front = PersistentList.<E>nil();
    	back = PersistentList.<E>nil();
    }
    
	private PersistentQueue(PersistentQueue<E> queue)
	{
		this.front=queue.front;
		this.back=queue.back;
	}
	
    private PersistentQueue(PersistentList<E> front, PersistentList<E> back) {
        this.front = front;
        this.back = back;
    }

    public static <E> PersistentQueue<E> empty() {
        return new PersistentQueue<E>(PersistentList.<E>nil(), PersistentList.<E>nil());
    }

    public boolean isEmpty() {
        return front.isEmpty() && back.isEmpty();
    }

    public PersistentQueue<E> enqueue(E e) throws IllegalAccessException {
    	if(e == null){
			throw new IllegalAccessException();
		}
        return new PersistentQueue<E>(front.add(e), back);
    }

    public PersistentQueue<E> dequeue() {
        if (isEmpty()) throw new NoSuchElementException();
        if (back.isEmpty()) {
        	PersistentList<E> tnorf = front.reverse();
            return new PersistentQueue<E>(PersistentList.<E>nil(), tnorf.tail); 
        } else {
           return new PersistentQueue<E>(front, back.tail); 
        }
    }
    
    public E peek(){
    	if (isEmpty()) throw new NoSuchElementException();
        if (back.isEmpty()) {
        	PersistentList<E> tnorf = front.reverse();
            return tnorf.head; 
        } else {
           return back.head; 
        }
	}
	
	public int size(){
		return front.size() + back.size();
	}
}