import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;


public class SystemIn {
	public static void main(String[] args) throws IOException{
		int ch = (int)'\r';
        System.out.printf("ch = %d\n", ch);
     
        ch = (int)'\n';
        System.out.printf("ch = %d\n", ch);
 
        System.out.println("«Î ‰»Î“ª¥Æ◊÷∑˚:");
        while (true) {
            try { 
                ch = (int)System.in.read();
            } catch(IOException e) {
 
            }
            System.out.printf("ch = %d",ch);
        }
/*		System.out.println("«Î ‰»Î:");
		BufferedReader bfr = new BufferedReader(new InputStreamReader(System.in));
		System.out.println(bfr.readLine());*/
	}

}
