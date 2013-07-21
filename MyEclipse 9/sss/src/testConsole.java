import java.io.BufferedReader;
import java.io.Console;
import java.io.IOException;
import java.io.InputStreamReader;

public class testConsole{
  public static void main(String[] args) throws IOException{
      int aa = Integer.parseInt(new BufferedReader(new InputStreamReader(System.in)).readLine());
      System.out.println(aa);
      System.in.read();
  }
}