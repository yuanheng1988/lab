
public class BinaryCode {
	
	public static void main(String[] args){
		System.out.println((Integer.toBinaryString(Integer.MAX_VALUE)));
		System.out.println((Integer.toHexString(Integer.MAX_VALUE)));
		System.out.println(Integer.toBinaryString(Integer.MIN_VALUE + 1));
		System.out.println(Integer.toBinaryString(Integer.MIN_VALUE));
		System.out.println(Integer.toHexString(Integer.MIN_VALUE + 1));
		System.out.println(Integer.toHexString(Integer.MIN_VALUE));
		
		System.out.println(Integer.toBinaryString(-1));
		System.out.println(Integer.toHexString(-1));
		System.out.println(Integer.toBinaryString(0));
		System.out.println(Integer.toHexString(0));
		System.out.println(Integer.toBinaryString(1));
		System.out.println(Integer.toHexString(1));
		
		System.out.println(1<<5);
	}

}
