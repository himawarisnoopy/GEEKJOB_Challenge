<%-- 
    Document   : java1-8
    Created on : 2018/03/08, 11:48:50
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
            //8 の 20 乗を計算し，計算結果を表示してください。この計算は，for文によって実現してください。
            long num=1;
            for(int i=1;i<=20;i++){
                num=num*8;
            }
            out.print(num+"<br>");
            /*
            文字列型の変数を宣言してください。その後，反復処理を使い，「 A が 30 文字続いたもの」としてください（"AAAAA...AA" といった状態）。そして，変数の値を画面に表示してください。
このとき，変数の値は，一度に 30 文字の "A" を代入するのではなく，for文を利用して 1 文字ずつ文字列連結して得ます。また，画面表示は，処理の最後にただ一度だけ行うものとします。
            */
            String moji="";
            for(int i=1;i<=30;i++){
                moji=moji+"A";
            }
            out.print(moji+"<br>");
            /*
            変数を宣言し，その値を 0 から 100 までの合計値にしてください。そして，その変数の値を画面に表示してください。
このとき，変数の値は，for文を利用して， 0 から始まる数値を順番に足しこむことで得るものとします。
            */
            int num2=0;
            for(int i=1;i<=100;i++){
                num2=num2+i;
            }
            out.print(num2+"<br>");
            %>
    </body>
</html>
