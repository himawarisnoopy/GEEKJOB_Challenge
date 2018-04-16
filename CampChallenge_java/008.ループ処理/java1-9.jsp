<%-- 
    Document   : java1-9
    Created on : 2018/03/08, 11:51:18
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
            変数を宣言し，その値を数値型の 1000 としてください。また，while 文を利用して，変数の値を 2 で割り続け，割った結果が 100 より小さくなったらループを抜ける処理を記述してください。 
ループ後に変数の値を画面に表示し，処理結果が正しいことを確認してください。
*/
            double num=1000;
            while(num>100){
                num=num/2 ;
            }
            out.print(num);
            %>
    </body>
</html>
