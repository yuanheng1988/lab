import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class t1 {
	public static void main(String[] args){
		System.out.print("hehe");
		
		String driver = "com.mysql.jdbc.Driver";
		String url = "jdbc:mysql://127.0.0.1:3306/scutcs";
		String user = "root";
		String password = "root";
		
		try {
		Class.forName(driver);
		Connection conn = DriverManager.getConnection(url, user, password);
		if(!conn.isClosed())
		System.out.println("Succeeded connecting to the Database!");
		
		Statement statement = conn.createStatement();
		String sql = "select * from student";
		
		ResultSet rs = statement.executeQuery(sql); 
		System.out.println("执行结果如下所示:");
		System.out.println("执行结果如下所示:");
		System.out.println(" 学号" + "\t" + " 姓名");  
		System.out.println("-----------------");
		String name = null; 
		while(rs.next()) {
			name = rs.getString("sname");
			name = new String(name.getBytes("ISO-8859-1"),"GB2312");
			System.out.println(rs.getString("sno") + "\t" + name);  
		} 
		rs.close();  
		conn.close();   
		}
		catch(ClassNotFoundException e) {   
			System.out.println("Sorry,can`t find the Driver!");   
			e.printStackTrace();   
		} 
		catch(SQLException e) {   
			e.printStackTrace();   
		} 
		catch(Exception e) {   
			e.printStackTrace();   
		}     
	}
}