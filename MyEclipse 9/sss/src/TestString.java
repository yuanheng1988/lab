

import java.io.IOException;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class TestString {
	
	public static void main(String[] args) throws InterruptedException, IOException{
		DecimalFormat df = new DecimalFormat("#.0000");
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd: HH:mm:ss");
		
		String second = df.format(0.8990);
		System.out.println("The 0.8991 is: " + Double.parseDouble(df.format(0.8991)) + "\t" + "done");
		System.out.println("The 0.8990 is: " + second + "\t" + "done");
		
		while(true){
			System.out.println("hehe" + new Date());
			Thread.sleep(3000);
			System.out.println("haha" + sdf.format(new Date()));
			Thread.sleep(3000);
		}
	}

}
