package jp.co.wap.exam.sample;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Queue;

public class PersistentQueueSample<E> {
	private List<E> queue;
	private int size;

	/**
	 * requires default constructor.
	 */
	public PersistentQueueSample(){
		queue = new ArrayList<E>();
	}
	
	public PersistentQueueSample(List<E> queue){
		this.queue = queue;
		this.size = queue.size();
	}
	
	public PersistentQueueSample<E> enqueue(E e) throws IllegalAccessException{
		if(e == null){
			throw new IllegalAccessException();
		}
		List<E> clone = new ArrayList<E>(queue);
		clone.add(e);
		return new PersistentQueueSample<E>(clone);
	}
	
	public PersistentQueueSample<E> dequeue(){
		if(queue.isEmpty()){
			throw new NoSuchElementException();
		}
		List<E> clone = new ArrayList<E>(queue);
		clone.remove(0);
		return new PersistentQueueSample<E>(clone);
	}
	
	public E peek(){
		if(queue.isEmpty()){
			throw new NoSuchElementException();
		}
		return queue.get(0);
	}
	
	public int size(){
		return size;
	}
}
