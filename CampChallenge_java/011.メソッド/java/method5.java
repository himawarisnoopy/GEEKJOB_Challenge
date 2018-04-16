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
import java.util.ArrayList;



/**
 *
 * @author kawas
 */

/*
戻り値2

ユーザー定義メソッドを作成してください。引数・戻り値・処理内容については，以下の通りです。 

・引数　なし 
・戻り値　配列（ArrayListでも可） 
　適当な人物の ID・生年月日・住所を要素とする配列を返します（配列情報の生成はすべてメソッドの内部で行います）。 

メソッドを作成したら，このメソッドを呼び出し，その戻り値に格納された要素をそれぞれ表示してください。このとき，表示する要素は反復処理によって順番に指定するものとし，ID の値については表示しないものとしてください。


*/
public class method5 extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    
    ArrayList<String> profile(PrintWriter pw){
        ArrayList<String> human = new ArrayList<>();
            human.add("ID");
            human.add("生年月日");
            human.add("住所");
            for(int i=1;i<3;i++){
                pw.print(human.get(i)+"<br>");
            }
        return human;
            
            }
    
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            
            profile(out);
            
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
