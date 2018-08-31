<%@page import="jums.UserDataBeans"%>
<%@page import="javax.servlet.http.HttpSession" %>
<%@page import="jums.JumsHelper" %>
<%
    HttpSession hs = request.getSession();
    UserDataBeans udb = (UserDataBeans)hs.getAttribute("UserData");
    
    String name = "";
    int year = 0;
    int month = 0;
    int day = 0;
    int type = 0;
    String tell = "";
    String comment = "";
    
    if (udb != null) {
        name = udb.getName();
        year = udb.getYear();
        month = udb.getMonth();
        day = udb.getDay();
        type = udb.getType();
        tell = udb.getTell();
        comment = udb.getComment();
    }
    
%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JUMS登録画面</title>
    </head>
    <body>

    <form action="insertconfirm" method="POST">
        名前:
        <input type="text" name="name" value="<%= name %>">
        <br><br>

        生年月日:
        <select name="year">
            <option value="">----</option>
            <%
            for(int i=1950; i<=2010; i++){ %>
            <option value="<%=i%>"<% if(i==year){out.print("selected");}%><%=i%> </option>
            <% } %>
        </select>年
        <select name="month">
            <option value="">--</option>
            <%
            for(int i = 1; i<=12; i++){ %>
            <option value="<%=i%>"<% if (i == month) { out.print("selected"); } %>><%=i%></option>
            <% } %>
        </select>月
        <select name="day">
            <option value="">--</option>
            <%
            for(int i = 1; i<=31; i++){ %>
            <option value="<%=i%>"<% if (i == day) { out.print("selected"); } %>><%=i%></option>
            <% } %>
        </select>日
        <br><br>

        種別:
        <br>
        <input type="radio" name="type" value="1" <% if (type == 1) { out.print("checked"); } %>>エンジニア<br>
        <input type="radio" name="type" value="2"<% if (type == 2) { out.print("checked"); } %>>営業<br>
        <input type="radio" name="type" value="3"<% if (type == 3) { out.print("checked"); } %>>その他<br>
        <br>

        電話番号:
        <input type="text" name="tell" value="<%= tell %>">
        <br><br>

        自己紹介文
        <br>
        <textarea name="comment" rows=10 cols=50 style="resize:none" wrap="hard"><%= comment %></textarea><br><br>

        <input type="hidden" name="ac"  value="<%= hs.getAttribute("ac")%>">
        <input type="submit" name="btnSubmit" value="確認画面へ">
    </form>
        <br>
        <%=JumsHelper.getInstance().home()%>
    </body>
</html>
