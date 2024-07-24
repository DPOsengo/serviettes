<%@ page language="java" contentType="text/html;charset=UTF-8"%>
<%@ page import="java.text.*,java.util.*" %>
<%@ page import="com.bigcorp.booking.pojo.PatatePojo" %>
<html>
<head>
<title>La JSP de la PATATE</title>
<link href="${pageContext.request.contextPath}/css/style.css" rel="stylesheet" />
</head>
<% String message = "hello les patates";%>
<body>
<h1>Bienvenue sur une JSP (Java Server Patate) !!!! Je dirai : <%= message %> </h1>
    <iframe src="patate" style="width:100%; height:500px; border:none;"></iframe>
    <%
        PatatePojo patatePojo = (PatatePojo) request.getServletContext().getAttribute("patatePojo");
        if (patatePojo != null) {
            out.println("<div class='infoBox playwrite-ar-cursive'>");
            out.println("<p>Variété : " + patatePojo.getVariete() + "</p>");
            out.println("<p>Masse : " + patatePojo.getMasse() + "</p>");
            out.println("</div>");
        }
    %>
</body>
</html>