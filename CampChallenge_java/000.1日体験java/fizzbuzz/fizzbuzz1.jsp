<%-- 
    Document   : camp
    Created on : 2018/03/07, 18:26:37
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
        課題1　1から20までカウントアップしながら、3の倍数の時にだけ[アホになる]という
　　　　　　文字列を画面に表示するプログラムを作成してください。
            */
        for(int num=1;num<=20;num++){
            out.print(num);
            if(num%3==0){
            out.print("アホになる");
            }
            out.print("<br>");
        }

        %>
    </body>
</html>
