package jp.co.wap.exam.test;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import jp.co.wap.exam.PersistentList;
import jp.co.wap.exam.PersistentQueue;
import jp.co.wap.exam.sample.PersistentQueueSample;

public class test {
	
	public static void main(String[] args) throws IllegalAccessException{
		PersistentQueue<Integer> pq = PersistentQueue.empty();
		PersistentQueueSample<Integer> pqs = new PersistentQueueSample<Integer>();
		
		int N =10000;
		for(int i = 0;i < N; i++){
			pq = pq.enqueue(i);
			pqs = pqs.enqueue(i);
		}
		
		long startTime;
		long endTime;
		long time = 0;
		
		for(int i = 0; i<N; i++){
			startTime = System.nanoTime();
			pq = pq.enqueue(109);
//			pq = pq.dequeue();
//			int ll = pq.peek();
//			System.out.println(ll);
//			int pp = pq.size();
//			System.out.println(pp);
			endTime = System.nanoTime();
			time += endTime-startTime;
		}
		System.out.println(time/N);
		
		for(int i = 0; i<N; i++){
			startTime = System.nanoTime();
			pq = pq.enqueue(109);
//			pqs = pqs.dequeue();
//			int ll = pq.peek();
//			System.out.println(ll);
//			int pp = pq.size();
//			System.out.println(pp);
			endTime = System.nanoTime();
			time += endTime-startTime;
		}
		System.out.println("sample:" + time/N);
		
		
	}

}
