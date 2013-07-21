<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html;charset=utf-8"/>
		<script type="text/javascript" src="ckeditor/ckeditor.js"></script>
		<script type="text/javascript" src="ckeditor/ckfinder.js"></script>
	</head>

	<body>

		<form name="testForm" method="post" action="<%=path %>/show.jsp" accept-charset="utf-8">
		
			<!-- ckeditor的文本域 -->
   	<textarea cols="80" id="editor1" name="editor1" rows="10">
      在此添加内容
    	</textarea>
    	<script type="text/javascript">
				var editor=CKEDITOR.replace( 'editor1',
     			{
      				filebrowserBrowseUrl : '/ckeditor/ckfinder/ckfinder.html',
					filebrowserImageBrowseUrl : '/ckeditor/ckfinder/ckfinder.html?type=Images',
					filebrowserFlashBrowseUrl : '/ckeditor/ckfinder/ckfinder.html?type=Flash',
					filebrowserUploadUrl : '/ckeditor/ckfinder/core/connector/java/connector.java?command=QuickUpload&type=Files',
					filebrowserImageUploadUrl : '/ckeditor/ckfinder/core/connector/java/connector.java?command=QuickUpload&type=Images',
					filebrowserFlashUploadUrl : '/ckeditor/ckfinder/core/connector/java/connector.java?command=QuickUpload&type=Flash'
 			    });
 			    
  	 </script>
  	 		<!-- 题目的分类，如：高中数学，函数与导数，函数，函数及其表示 -->
   	<p>
   					题目所属类：（如：高中数学   函数与导数   函数   函数及其表示）</br>
   			<input type="text" name="classify1">
   			<input type="text" name="classify2"></br>
   			<input type="text" name="classify3">
   			<input type="text" name="classify4"></br>							
   	</p>
   			<!--题型 -->
   	<p>题型：<select name="problem_type">
   			<option value="选择题">选择题</option>
   			<option value="填空题">填空题</option>
   			<option value="解答题">解答题</option>
   			</select>
   	</p>
   			<!-- 难度 -->				 
   	<p>难度：<select name="difficulty">
   			<option value="1">1</option>
   			<option value="2">2</option>
   			<option value="3">3</option>
   			<option value="4">4</option>
   			<option value="5">5</option>
   			</select>
   	</p>
   							 
   			<!-- 提交表单 -->				 
    <input type="submit" value="提交"/>
    </form>

</body>
</html>