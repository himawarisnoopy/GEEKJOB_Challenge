<%-- 
    Document   : java1-2
    Created on : 2018/03/08, 10:36:28
    Author     : kawas
--%>

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
        変数を宣言し，変数に自己紹介文（ "私の名前は佐藤一郎です" など）を格納してください。また，変数の値を画面に表示する処理を記述してください。
*/
            String myself="私の名前は川崎美乃里です";
            out.print(myself);
            %>
    </body>
</html>
