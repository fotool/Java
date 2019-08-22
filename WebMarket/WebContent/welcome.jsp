<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
   <%@ page import="java.util.Date" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<!-- bootstrap을 사용하겠다는 표시 -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
<title>Insert title here</title>
</head>
<body>
	
	<!-- header가 위치하는 부분 -->
	<%@ include file="menu.jsp" %>
	<% String greeting="Welcome~!";
		String tailine="Welcome to Web Market";
	%>
	
	<div class= "jumbotron">
		<div class= "container">
			<h1 class="display-3">
			<%=greeting%>
			</h1>
		</div>
	</div>
	
	<div class="container">
		<div class="text-center">
			<h3><%=tailine%></h3>
			<!-- 접속 시간을 위한 내용 추가 -->
			<%
			Date day = new java.util.Date();
			String am_pm;
			int hour = day.getHours();
			int minute = day.getMinutes();
			int second = day.getSeconds();
			if(hour/12 == 0) {
				am_pm = "AM";
			}else {
				am_pm = "PM";
				hour = hour - 12;
			}
			String CT = hour + ":" + minute + ":" + second +" " + am_pm;
			out.println("Now, the time is : " + CT + "\n");
			%>
			<%
				response.setIntHeader("Refresh", 1);
			%>
		</div>
	</div>
	<!-- footer가 위치하는 부분 -->
	<%@ include file="footer.jsp" %>
</body>
</html>