<%-- 
    Document   : kuerisutoringu
    Created on : 2018/04/05, 15:08:43
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
            int total = Integer.parseInt(request.getParameter("total"));
            int count = Integer.parseInt(request.getParameter("count"));
            int type = Integer.parseInt(request.getParameter("type"));
            out.print("商品種別は");
            switch(type){
                case 1:
                    out.print("雑貨");
                    out.print("<br>");
                    break;
                case 2:
                    out.print("生鮮食品");
                    out.print("<br>");
                    break;
                case 3:
                    out.print("その他");
                    out.print("<br>");
            }
            out.print("商品単価は"+(int)(total/count)+"円<br>");
            
            double point =0;
            if(total<3000){
                point=0;
            }else if(point>=3000||point<5000){
                point=total*0.04;
            }else{
                point=total*0.05;
            }
            out.print("ポイントは"+(int)point+"円です");
            
            
            
            
            %>
    </body>
</html>
