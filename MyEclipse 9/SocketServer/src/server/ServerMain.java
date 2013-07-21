package server;

import java.io.BufferedReader;  
import java.io.IOException;  
import java.io.InputStreamReader;  
import java.io.PrintStream;  
import java.net.ServerSocket;  
import java.net.Socket;  
/** 
 * SocketͨѶ�������� 
 * @author ��ǿ<��ת���뱣�����ߺͳ���> 
 * @blog http://hi.baidu.com/mq612/blog 
 * @blog http://blog.csdn.net/mq612 
 */  
public class ServerMain {  
    public ServerMain() {  
        try {  
            // ���������ServerSocket���󣬲���Ϊ�������˿��ŵĶ˿ں�  
            ServerSocket ss = new ServerSocket(30102);  
            System.out.println("������׼��������");  
            // ��ѭ������ʹ�������������ڽ��տͻ���״̬  
            while(true){  
                // �÷���ʹ�����������ȴ��ͻ��˵����ӣ����������ͻ��˵����ӣ�����һ��Socket������ͻ��˵����Ự  
                Socket s = ss.accept();  
                // Ϊ�˲�Ӱ����������������ͻ��ˣ����￪����һ���̣߳����̴߳���������ͻ��˵ĻỰ  
                new ServerThread(s).start();  
            }  
        } catch (IOException e) {  
            e.printStackTrace();  
        }  
    }  
    public static void main(String[] args) {  
        new ServerMain();  
    }  
}  
  
/** 
 * ����������ͻ��˻Ự���߳� 
 */  
class ServerThread extends Thread {  
    private Socket s = null;  
    private BufferedReader read = null;  
    private PrintStream print = null;  
    public ServerThread(Socket s) {  
        this.s = s;   
        try {  
            // ��Socket�л�ȡ�����������������������ֻ��һ���򵥵��ַ���ͨѶ�����Բ���BufferedRead��PrintStream����װ���롢�����  
            read = new BufferedReader(new InputStreamReader(s.getInputStream()));  
            print = new PrintStream(s.getOutputStream());  
        } catch (IOException e) {  
            e.printStackTrace();  
        }  
    }  
    /** 
     * �̵߳�����run���� 
     */  
    public void run() {  
        try {  
            String message = null;  
            // ����ѭ������ʹ�����������Ľ��տͻ�����Ϣ��read.readLine()ͨ����������ȡһ���ַ�������ֵ��message���������message�ַ�����Ϊ��exit����ѭ�����������ѭ��  
            while (!(message = read.readLine()).equals("exit")){  
                // ���ַ���ǰ����ӡ����أ������ٷ��ؿͻ���  
                print.println("���أ�" + message);  
            }  
        } catch (IOException e) {                  
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

