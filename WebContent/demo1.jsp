<%@page import="entity.Company"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Welcome to my Company</title>
</head>
<script type="text/javascript" src="${pageContext.request.contextPath }/js/jquery.min.js"></script>
<script type="text/javascript">
function  add(){
	var name  = $("#name").val();
	var sex = $("#sex").val();
	var position = $("#position").val();
	$.ajax({
		url:"/Study02/CompanyServlet.do/",
		type:"post",
		success:function(data){
			if(data){
				$("#sp1").html("注册成功");
			}else{
				$("#sp1").html("注册失败");
			}
		},
		data:{name:name,sex:sex,position:position}
	});
   }
	function  remove(){
		var name = $("#name").val();
		
		$.ajax({
			url:"",
			type:"delete",
			success:function(data){
				if(data){
					$("#sp1").html("删除成功");
				}else{
					$("#sp1").html("删除失败");
				}
			}
		});
  }
	
	function  select(){
		var name = $("#name").val();
		
		$.ajax({
			url:"",
			type:"get",
			success:function(data){
				if(data == null){
					$("#sp1").html("查询失败");
				}
				// 给输入框赋值
				$("#name").val(data.name);
				$("#sex").val(data.sex);
				$("#position").val(data.position);
			},
			dataType:"json"
		});
  }



<body  bgcolor="red">

	<h1>康润普科文化有限公司人员登记表</h1>
<%List<Company> companys = (List<Company>) request.getAttribute("companys");%>
	<table  width="550px" height="300px" border="5px" bordercolor="#be3131">
	<tr><td>姓名</td><td>年龄</td><td>职位</td><td>功能一</td><td>功能二</td><td><input type="text" placeholder="请输入要增加的信息"><input type="submit" value="增加"></td></tr>
<%for (int i = 0; i < companys.size(); i++) {
				Company company = companys.get(i);%>
	<tr><td>
<%=company.getName()%>
	</td>
	<td>
<%=company.getSex()%>
	</td>
  <td>
<%=company.getPosition()%>
	</td>
  <td><button name="delete">删除</button></td>
  <td><button name="update">修改</button></td>
</tr>
<%}%>
	</table>
</body>
</html>
