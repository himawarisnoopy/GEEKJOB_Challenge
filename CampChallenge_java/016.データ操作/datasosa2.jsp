<%-- 
    Document   : datasosa2
    Created on : 2018/04/03, 2:44:37
    Author     : kawas
--%>
<!--
HTMLの入力データの取得と表示
課題「入力フィールド」で作成した HTML のフォームから値を送信し，サーブレットか JSP で受け取ってください。また，受け取った値を画面に表示してください。
-->

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <%
    request.setCharacterEncoding("utf-8");

    String name = request.getParameter("name");
    String sex = request.getParameter("sex");
    String hobby = request.getParameter("hobby");
    
    out.print("名前：" + name + "<br>");
    out.print("性別：" + sex + "<br>");
    out.print("趣味：" + hobby + "<br>");
    
%>
    </body>
</html>
