<%-- 
    Document   : java1-3
    Created on : 2018/03/08, 10:40:18
    Author     : kawas
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
        <%
            //変数と定数を宣言し，それぞれ数値を格納してください。また，変数と定数を使って四則演算を行い，計算結果を画面に表示してください。
            int num1=20;
            final int NUM2=10;
            //足し算
            int tasu = num1+NUM2;
            //引き算
            int hiku = num1-NUM2;
            //掛け算
            int kake = num1*NUM2;
            //割り算
            int wari = num1/NUM2;
            //剰余算
            int amari = num1%NUM2;
            out.print(tasu+"<br>");
            out.print(hiku+"<br>");
            out.print(kake+"<br>");
            out.print(wari+"<br");
            out.print(amari+"<br>");

            
            %>
    </body>
</html>
