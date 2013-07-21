package kexin;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;


public class hehe {
	
	private void oo(){
		System.out.println("oo");
	}
	public void kk(){
		oo();
		System.out.println("kk");
	}
	
	public void add(List<Integer> list){
		list.add(4);
	}
	
	public static void main(String[] args){
		hehe h = new hehe();
		h.kk();
		List<Integer> list = new LinkedList<Integer>();
		List<Integer> ll = Arrays.asList(1,2,3);
		list.add(0);
		list.add(4);
		System.out.println(list.get(0));
		int a = 5;
		h.add(list);
		System.out.println(list);
	}
	
	

}
