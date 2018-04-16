/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
/**
 *
 * @author kawas
 */
/*
ユーザー定義メソッドを２つ作成してください。引数・戻り値・処理内容については，以下の通りです。 

■１つめのユーザー定義メソッド 
このメソッドは，掛け算を行います。 
・引数 
　第一引数　数値型 
　第二引数　数値型 
　第三引数　boolean 型 
　第四引数　PrintWriter型 
（ただし，この課題をサーブレットではなく Java クラスで作成する場合は，第四引数は不要です）。 
・処理内容 
　第一引数と第二引数を掛け算し，第三引数の値が true であるときにかぎって，掛け算の結果をさらに２乗します。また，この計算結果の値を画面に表示処理します。 

■２つめのユーザー定義メソッド 
このメソッドは，１つめのメソッドのデフォルト値の設定を行います。 
・引数 
　考えてみましょう。 
・処理内容 
　１つめのユーザー定義メソッドの呼び出しを行います。このとき，１つめのユーザー定義メソッドに対して，第一引数に対して 5 を，第三引数に false を，それぞれデフォルト値として与えます。 

メソッドを作成したら，それぞれのメソッドに適当な引数を与えて呼び出して画面表示を行い，メソッドの処理内容が正しいことを確認してください。
*/
public class method3 extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    
    void metho1(int num1, int num2 , boolean s, PrintWriter pw) {
        int num;
        num=num1*num2;
        if(s==true){
            num=num*num;
        }
       pw.print("結果は"+num);
}
    void metho1(int num2,PrintWriter pw){
        metho1(5,num2,false,pw);
    }

   
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            
            metho1(6,out); 

        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
