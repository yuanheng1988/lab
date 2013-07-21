import java.io.Console;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;


public class ListSort {
		
	static int id = 1;
	
	public static void main(String[] args){
//		List<String> array = null;
		List<String> array = new ArrayList<String>();
		String[] arr = {"dadsa","xukexin","maoke","maoke","wangsong"};
		array = Arrays.asList(arr);
//		System.out.println(arr);
//		System.out.println(arr.hashCode());
//		System.out.println(arr[3].hashCode());
//		System.out.println(System.identityHashCode(arr[3]));
//		System.out.println(array.hashCode());
//		System.out.println(array.get(3).hashCode());
//		System.out.println(System.identityHashCode(array.get(3)));
		System.out.println(Arrays.toString(array.toArray()));
		
//		Collections.sort(array,new Comparator<String>(){
//			public int compare(String s1,String s2){
//				return (s2.compareTo(s1));
//			}
//		});
		Collections.sort(array);
		System.out.println(Arrays.toString(array.toArray()));
		
		Console console = System.console();;
		String aa = console.readLine();
		System.out.println(aa);
	}

}
