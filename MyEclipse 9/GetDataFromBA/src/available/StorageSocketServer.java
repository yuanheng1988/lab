package available;

import java.io.BufferedReader;  
import java.io.IOException;  
import java.io.InputStreamReader;  
import java.io.PrintStream;  
import java.net.ServerSocket;  
import java.net.Socket;  
/** 
 * Socket通讯服务器端 
 * @author 米强<如转载请保留作者和出处> 
 * @blog http://hi.baidu.com/mq612/blog 
 * @blog http://blog.csdn.net/mq612 
 */  
public class StorageSocketServer {  
    public StorageSocketServer() {  
        try {  
            // 构造服务器ServerSocket对象，参数为服务器端开放的端口号  
            ServerSocket ss = new ServerSocket(30141);  
            System.out.println("服务器准备就绪！");  
            // 死循环可以使服务器持续处于接收客户端状态  
            while(true){  
                // 该方法使程序阻塞，等待客户端的链接，当监听到客户端的链接，创建一个Socket对象与客户端单独会话  
                Socket s = ss.accept();  
                // 为了不影响服务器监听其它客户端，这里开启了一个线程，由线程处理与这个客户端的会话  
                new ServerThread(s).start();  
            }  
        } catch (IOException e) {  
            e.printStackTrace();  
        }  
    }  
    public static void main(String[] args) {  
        new StorageSocketServer();  
    }  
}  
  
/** 
 * 服务器端与客户端会话的线程 
 */  
class ServerThread extends Thread {  
    private Socket s = null;  
    private BufferedReader read = null;  
    private PrintStream print = null;  
    public ServerThread(Socket s) {  
        this.s = s;  
        try {  
            // 从Socket中获取输入流和输出流，由于我们只做一个简单的字符串通讯，所以采用BufferedRead和PrintStream来封装输入、输出流  
            read = new BufferedReader(new InputStreamReader(s.getInputStream()));  
            print = new PrintStream(s.getOutputStream());  
        } catch (IOException e) {  
            e.printStackTrace();  
        }  
    }  
    /** 
     * 线程的运行run方法 
     */  
    public void run() {  
        try {  
            // 这里循环可以使服务器持续的接收客户端信息。read.readLine()通过输入流读取一段字符串，赋值给message变量，如果message字符串不为“exit”则循环，否则结束循环  
                // 将字符串前面添加“返回：”，再发回客户端  \
        		String message = read.readLine();       		
        		String url = message.split(";")[0];
        		String tool = message.split(";")[1];
//        		System.out.println(url + "||" + tool);
//        		print.print(url + "||" + tool);
/*        		if(url.equals("http://192.168.12.9:8080/rest/api/2.0.alpha1/issue/NFS-1"))
        			print.print("  hehe");
        		if (tool.equals("jira"))
        			print.print("  haha");*/
            	print.print(ClientWithResponseHandler.GetResponseData(url,tool)); 
            	
        } catch (IOException e) {  
        } catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {  
            // 在 finally 代码块中无论如何都会执行下面代码：  
            try {  
                // 如果没有关闭Socket  
                if(!s.isClosed()){  
                    // 关闭Socket链接  
                    s.close();  
                }  
            } catch (IOException e1) {  
                e1.printStackTrace();  
            }  
        }  
    }  
}  

