<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ page import="com.mysql.jdbc.Driver" %> 
<%@ page import="java.sql.*" %>
<%
String path = request.getContextPath();
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html;charset=utf-8"/>
<script type="text/javascript" src="ckeditor/ckeditor.js"></script>
</head>

<body>

<%
		//页面读取返回值时的编码方式
		request.setCharacterEncoding("utf-8");
		
		//数据库操作
		
		//驱动程序名
		String driverName="com.mysql.jdbc.Driver";
		//数据库用户名
		String userName="root";
		//密码
		String userPasswd = "root";
		//数据库名
		String dbName = "GaoZhongMath";
		//表名
		String tableName = "math_content";
		//连接字符串
		String url = "jdbc:mysql://localhost/"+dbName+"?user="+userName+"&password="+userPasswd+"&characterEncoding=utf8";
		Class.forName("com.mysql.jdbc.Driver").newInstance();
		Connection connection = DriverManager.getConnection(url);
		Statement statement=connection.createStatement();
		
		//获取数据
		//分类
		String classify1 = request.getParameter("classify2");
		String classify2 = request.getParameter("classify3");
		String classify3 = request.getParameter("classify4");
		//
		//题型
		String problem_type=request.getParameter("problem_type");
		//难度
		String difficulty = request.getParameter("difficulty");
		//标题/来源
		String source= "自编";
		//题目内容
		String content = request.getParameter("editor1");
		
		//插入数据库
		String sql="insert into "+tableName+" (classify1,classify2,classify3,type,difficulty,source,content) values "+"( '"+classify1+"','"
					+classify2+"','"+classify3+"','"+problem_type+"','"
					+difficulty+"','"+source+"','"+content+"')";
		sql = sql.replaceAll("\\\\","\\\\\\\\");
		System.out.println(sql);
		statement.execute(sql);
		
		out.println("数据库操作成功，恭喜您!");
		
		
		//取记录
		sql = "select * from " + tableName;
		ResultSet rs = statement.executeQuery(sql);
		String show_content = null;
		String id_number = null;
		out.println("<h1>目前数据库中的题目有如下这些：</h1><br>");
		while(rs.next())
		{
			show_content="";
			//题号
			id_number=rs.getString(1);
			show_content = "题号：" + id_number;
			//题型
			problem_type=rs.getString(5);
			show_content = show_content + "，题型：" + problem_type;
			//难度
			difficulty = rs.getString(6);
			show_content = show_content + "，难度：" + difficulty + "</br>";
			//标题/来源
			source= rs.getString(7);
			show_content = show_content + "标题/来源：" +  source ;
			//日期
			java.util.Date date = new java.util.Date();
			String problem_date = date.toLocaleString();
			show_content = show_content + "，日期" + problem_date + "</br>";
			content = rs.getString(8);
			show_content = show_content + content + "</br>";
			//分类
			String classify = rs.getString(2) + "--"+rs.getString(3)+"--"+rs.getString(4);
			if(content!=null&&!content.equals("")){
				out.println(show_content+"<br>");
				}
		}
		
   %>

</body>
</html>
