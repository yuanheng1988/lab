package stack;

import java.util.Stack;

public class Stack_sort {
	public static boolean stacksort(Stack<Integer> s1, Stack<Integer> s2){
		if(s1.empty())
			return false;
		int top = (Integer)s1.pop();
		if(s1.empty()){
			s2.push(top);
			return false;
		}
		int next = (Integer)s1.peek();
		if(top > next){
			s1.pop();
			s2.push(next);
			s1.push(top);
			stacksort(s1,s2);
			return true;
		}
		else{
			s2.push(top);
			if(stacksort(s1,s2)) 
				return true;
			else
				return false;
		}
	}
	
	public static void main(String[] args){
		Stack<Integer> s1 = new Stack<Integer>();
		Stack<Integer> s2 = new Stack<Integer>();
		s1.push(2);
		s1.push(1);
		s1.push(7);
		s1.push(3);
		s1.push(9);
		s1.push(0);
		
		System.out.print("sorted stack is: ");
		
		while(stacksort(s1,s2)){
			while(!s2.empty())
				s1.push(s2.pop());
		}
		while(!s2.empty()) 
			s1.push(s2.pop());
		while(!s1.empty()){
			System.out.print(s1.pop() + "");
		}
		System.out.println();
	}
}




