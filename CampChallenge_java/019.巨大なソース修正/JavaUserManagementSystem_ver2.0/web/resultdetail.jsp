<%@page import="jums.JumsHelper"
        import="jums.UserDataDTO" %>
<%
    JumsHelper jh = JumsHelper.getInstance();
    UserDataDTO udd = (UserDataDTO)request.getAttribute("resultData");
%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JUMSユーザー情報詳細画面</title>
    </head>
    <body>
        <h1>詳細情報</h1>
        名前:<%= udd.getName()%><br>
        生年月日:<%= udd.getBirthday()%><br>
        種別:<!--種別を日本語表示(ジャムズヘルパークラスのメソッド)-->
        <%=jh.exTypenum(udd.getType())%>
            <br>
        電話番号:<%= udd.getTell()%><br>
        自己紹介:<%= udd.getComment()%><br>
        登録日時:<%= udd.getNewDate()%><br>
        <form action="Update" method="POST">
            <!--hiddenタグで値を送信-->
            <input type="hidden" name="id" value="<%= udd.getUserID() %>">
            <input type="hidden" name="name" value="<%= udd.getName() %>">
            <input type="hidden" name="year" value="<%= jh.getYear(udd.getBirthday()) %>">
            <input type="hidden" name="month" value="<%= jh.getMonth(udd.getBirthday()) %>">
            <input type="hidden" name="date" value="<%= jh.getDate(udd.getBirthday()) %>">
            <input type="hidden" name="type" value="<%= udd.getType() %>">
            <input type="hidden" name="tel" value="<%= udd.getTell() %>">
            <input type="hidden" name="comment" value="<%= udd.getComment()%>">
        <input type="submit" name="update" value="変更"style="width:100px">
        </form>
        <form action="Delete" method="POST">
            <input type="hidden" name="id" value="<%= udd.getUserID() %>">
            <input type="hidden" name="name" value="<%= udd.getName() %>">
            <input type="hidden" name="year" value="<%= jh.getYear(udd.getBirthday()) %>">
            <input type="hidden" name="month" value="<%= jh.getMonth(udd.getBirthday()) %>">
            <input type="hidden" name="date" value="<%= jh.getDate(udd.getBirthday()) %>">
            <input type="hidden" name="type" value="<%= udd.getType() %>">
            <input type="hidden" name="tel" value="<%= udd.getTell() %>">
            <input type="hidden" name="comment" value="<%= udd.getComment()%>">
        <input type="submit" name="delete" value="削除"style="width:100px">
        <br>
        </form>
        <%=jh.home()%>
    </body>
</html>
