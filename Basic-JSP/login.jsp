<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <title>Login Result</title>
</head>
<body>
    <% String username = request.getParameter("username"); %>
    <% String password = request.getParameter("password"); %>
    
    <% boolean isValidUser = false; %>
    <% if ("lav123".equals(username) && "lav123".equals(password)) {
            isValidUser = true;
        }
    %>
    <h1>Login Result</h1>
    <% if (isValidUser) { %>
        <p>Login successful! Welcome <%= username %>!</p>
        <p><a href="registration.jsp">Proceed for registration</a></p>
    <% } else { %>
        <p>Login failed. Please check your username and password.</p>
    <% } %>
</body>
</html>
