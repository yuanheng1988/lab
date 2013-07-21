import java.util.Arrays;


class A{
	int i;
	int j;
	
	public A(){
		this.i = 0;
		this.j = 0;
		System.out.println("i am constructor.");
	}
}

public class ArrayDeclare {
	
	@SuppressWarnings("null")
	public static void main(String[] args){
		Integer[] yy = new Integer[5];
		yy[0] = 2;
//		yy[0] = new Integer(3);
		System.out.println(yy[0]);
		
		int[] tt = new int[5];
		tt[0] = 11;
		System.out.println(tt[0]);
		
		System.out.println("----------------------");
		
		int[] pp = new int[100];
		System.out.println(pp.length);
		System.out.println(pp[2]);
		Arrays.fill(pp, 2);
		System.out.println(pp[2]);
		pp[3] = 20;
		System.out.println(pp[4]);
		
		System.out.println("---------------------");
		
		A[] aa = new A[10];
		aa[0] = new A();
		Arrays.fill(aa, aa[0]);    
		System.out.println(aa[1].i);
		aa[1].i = 20;
		System.out.println(aa[2].i);
	}

}
