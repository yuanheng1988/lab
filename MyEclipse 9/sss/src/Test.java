import java.util.Scanner;


public class Test {
    public static int count1 = new Scanner(System.in).nextInt(); //与下面一行等效
//    public static int count1 = 8;
	private static Test tester = new Test(); //step 1  
              //step 2  
    public static int getCount1() {
		return count1;
	}
	public static void setCount1(int count1) {
		Test.count1 = count1;
	}
	
	public static int gethehe() {
		System.out.println("hehe");
		return 1;
	}

	private static int count2 = 2;           //step 3  
    public Test(){                           //step 4  
    	count1++;  
        count2++;  
        System.out.println("" + count1 + count2);  
    }  
    
    public static Test getTester(){          //step 5  
        return tester;  
    }  
      
    public static void main(String[] args) throws IllegalAccessException{  
    	Test tt = new Test();
//    	tt.getTester();  
//    	System.out.println(Test.count1);
//    	System.out.println(Test.gethehe());
//    	System.out.println(Test.getTester());
    	
//    	for (int i=0; i<100;i++){
//    		if (i % 9 == 0){
//    			throw new IllegalAccessException();
//    		}
//    	}
    	

    }  
}
