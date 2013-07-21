package cn.iscas.nfs.platform.coreservice.storage.io;

import java.sql.Connection;
import java.sql.DriverManager;



public class DBOperation {
	private static Connection con = null;
	private static String DB_URL = "jdbc:mysql://192.168.10.19:3307/nfsplatform?user=root&password=root&useUnicode=true&characterEncoding=utf8";
	
	public static Connection getConnection() throws Exception {
		if(con != null && !con.isClosed()) return con;
		
		String driver = "com.mysql.jdbc.Driver";
		Class.forName(driver);
        con = DriverManager.getConnection(DB_URL);
        return con;
	}
}
