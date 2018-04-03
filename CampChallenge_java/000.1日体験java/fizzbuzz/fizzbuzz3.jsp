<%-- 
    Document   : fizzbuzz3
    Created on : 2018/03/07, 18:48:39
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
            for(int num=1;num<=40;num++){
            out.print(num);
                if(num%3==0 ||  String.valueOf(num).indexOf("3") != -1 ){
                    out.print("アホになる");
                }
                if(num%5==0){
                    out.print("犬っぽくなる");
                }
                out.print("<br>"); 
             }
            %>
    </body>
</html>
