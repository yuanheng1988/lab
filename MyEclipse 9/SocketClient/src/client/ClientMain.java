package client;

import java.io.BufferedReader;  
import java.io.IOException;  
import java.io.InputStreamReader;  
import java.io.PrintStream;  
import java.net.Socket;  
import java.net.UnknownHostException;  
import java.util.Scanner;  
/** 
 * SocketͨѶ�ͻ��� 
 * @author ��ǿ<��ת���뱣�����ߺͳ���> 
 * @blog http://hi.baidu.com/mq612/blog 
 * @blog http://blog.csdn.net/mq612 
 */  
public class ClientMain {  
    public ClientMain() {  
        try {  
            // �����������ͨѶ��Socket���󣬲���Ϊ������IP��ַ��String���Ͷ˿ںţ�int�����˿ں���Ҫ�ͷ������˿��ŵĶ˿ںŶ�Ӧ  
            Socket s = new Socket("localhost", 30141);  
            // ����һ���߳��������ͨѶ���������ӷ�������Socket���󴫵ݹ�ȥ  
            new LinkThread(s).start();  
        } catch (UnknownHostException e) {  
            e.printStackTrace();  
        } catch (IOException e) {  
            e.printStackTrace();  
        }  
    }  
      
      
    public static void main(String[] args) {  
        new ClientMain();  
    }  
      
}  
/** 
 * �������ͨѶ���߳� 
 */  
class LinkThread extends Thread {  
    private Socket s = null;  
    // �����  
    private PrintStream out = null;  
    // ����������  
    private BufferedReader in = null;  
    // ¼�����ֵ�Scanner����  
    private Scanner scanner = null;  
      
    public LinkThread(Socket s) {  
        // ��Socket����ʵ��������ȫ�ֱ����У���Ϊrun���������ǻ�Ҫ�����Ͽ�����  
        this.s = s;  
        try {  
            // ��Socket�л�ȡ�����������������������ֻ��һ���򵥵��ַ���ͨѶ�����Բ���BufferedRead��PrintStream����װ���롢�����  
            out = new PrintStream(s.getOutputStream());  
            in = new BufferedReader(new InputStreamReader(s.getInputStream()));  
        } catch (UnknownHostException e) {  
            e.printStackTrace();  
        } catch (IOException e) {  
            e.printStackTrace();  
        }  
    }  
      
    /** 
     * �̵߳�����run���� 
     */  
    public void run() {  
        // ����Scanner����  
        scanner = new Scanner(System.in);  
        System.out.println("��ʾ�����Ҫ�������λỰ�������롰exit��ָ�");  
        try {  
            // ��ѭ������ʹ�ͻ��˲��ϵ��������������Ϣ�����õ���ѭ���޷������������return�����Խ��������̡߳�  
/*            while(true){  
                // ��ʾ�û���������  
                System.out.print("�����룺");  
                // ���û�������ַ���������message������  
                String message = scanner.nextLine();  
                // ͨ������������ַ���  
                out.println(message);  
                // ��ջ��壬ǿ�����  
                out.flush();  
                // ��ȡ���������ص��ַ���  
                String str = in.readLine();  
                // ������ص��ַ�������  
                if(str != null){  
                    // ��ʾ�ڿ���̨  
                    System.out.println(str);  
                }else{  
                    // ��ʾ�Ự�������������߳�  
                    System.out.println("���λỰ������");  
                    return;  
                }  
            } */ 
        	out.println("http://192.168.8.52:8080/OSLC4JBugzilla/services/2/changeRequests/6;bugzilla");
        	out.flush();
        	System.out.println(in.readLine());
        } catch (IOException e) {  
            e.printStackTrace();  
        } finally {  
            // �� finally �������������ζ���ִ��������룺  
            try {  
                // ���û�йر�Socket  
                if(!s.isClosed()){  
                    // �ر�Socket����  
                    s.close();  
                }  
            } catch (IOException e1) {  
                e1.printStackTrace();  
            }  
        }  
    }  
      
}  
