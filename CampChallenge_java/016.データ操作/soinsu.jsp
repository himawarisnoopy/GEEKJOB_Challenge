<%-- 
    Document   : soinsu
    Created on : 2018/04/09, 11:14:02
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
        <%
       int num = Integer.parseInt(request.getParameter("num"));
       int primes[]={2,3,5,7};
       out.print(num + "=");

    for (int i = 0; i < primes.length; i++) {
        while (num % primes[i] == 0) {
            num /= primes[i];
            out.print(primes[i]+"*");
        }
    }
    if (num != 1) {
        out.print("あまり");
        out.print(num);
    }else
       %>
    </body>
</html>
