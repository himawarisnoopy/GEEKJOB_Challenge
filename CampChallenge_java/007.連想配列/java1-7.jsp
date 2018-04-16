<%-- 
    Document   : java1-7
    Created on : 2018/03/08, 11:42:12
    Author     : kawas
--%>
<%@ page import="java.util.HashMap" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Hello World!</h1>
        <%
            /*
            以下の順で、連想配列を作成してください。
"1"に"AAA", "hello"に"world", "soeda"に"33", "20"に"20"
            */
            HashMap<String, String> prof =new HashMap<String, String>();
            prof.put("1", "AAA");
            prof.put("hello", "world");
            prof.put("soeda", "33");
            prof.put("20", "20");
            out.print(prof);
            %>
    </body>
</html>
