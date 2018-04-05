<%-- 
    Document   : java1-5
    Created on : 2018/03/08, 10:48:36
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
            変数を宣言し，数値を格納してください。その後，変数の値によって条件分岐し，以下のような画面表示をしてください。なお，条件分岐には switch 文を利用してください。 

変数の値が１の場合 ... 「one」と表示する 
変数の値が２の場合 ... 「two」と表示する 
それ以外の場合 ... 「想定外」と表示する
            */
            int num=1;
            switch(num){
                case 1:
                    out.print("one");
                    break;
                case 2:
                    out.print("two");
                    break;
                default:
                    out.print("想定外");
            }
            /*
            char型の変数を宣言し，値を格納してください。その後，変数の値によって条件分岐し，以下のような画面表示をしてください。なお，条件分岐には switch 文を利用してください。 

変数の値が 'A' の場合 ... 「英語」と表示する 
変数の値が 'あ' の場合 ... 「日本語」と表示する 
それ以外の場合 ... 何も表示しない（処理を行わない）
            */
            char moji='い';
            switch(moji){
                case 'A':
                    out.print("英語");
                    break;
                case 'あ':
                    out.print("日本語");
                    break;
            
            }
            %>
    </body>
</html>
