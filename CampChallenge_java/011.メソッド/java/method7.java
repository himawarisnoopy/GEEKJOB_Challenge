/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author kawas
 */
/*
ユーザー定義メソッドを作成してください。引数・戻り値・処理内容については，以下の通りです。
・引数　文字列型
・戻り値　配列（ArrayList で実現してもOK）
・処理内容
　３人分のプロフィール情報を，それぞれ配列で作成してください（プロフィール情報の項目は，課題「引数、戻り値1」と同様です）。ただし，そのうちの１人については，住所 の値を null にしてください。
　そして，引数で受け取った文字列と ID の値が一致する人物について，そのプロフィール情報の配列を戻り値としてください。

　メソッドを作成したら，このメソッドを適宜呼び出し，３人分のプロフィール情報をすべて画面に表示してください。ただし，値が null なデータについては continue; を利用して画面表示をスキップしてください。
*/


public class method7 extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
        ArrayList<String> profile(String ID,PrintWriter pw){
        ArrayList<String> human1 = new ArrayList<>();
                    human1.add(ID);
                    human1.add("1生年月日");
                    human1.add("1住所");
        ArrayList<String> human2 = new ArrayList<>();
                    human2.add(ID);
                    human2.add("2生年月日");
                    human2.add(null);
        ArrayList<String> human3 = new ArrayList<>();
                    human3.add(ID);
                    human3.add("3生年月日");
                    human3.add("3住所");
                    

        if(ID=="100"){for(int i = 1; i <human1.size(); i++) {
                    if(human1.get(i) == null){
                        continue;
                    }
                    pw.print(human1.get(i)+"<br>");
                }
        return human1;
        }else if(ID=="200"){
                for(int i = 1; i <human2.size(); i++) {
                    if(human2.get(i) == null){
                        continue;
                    }
                    pw.print(human2.get(i)+"<br>");
                }
                return human2;
        }else if (ID=="300"){
                for(int i = 1; i < human3.size(); i++) {
                    if(human1.get(i) == null){
                        continue;
                    }
                    pw.print(human3.get(i)+"<br>");
                }
                return human3;
        }
        return null;

        }
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            
            profile("100",out);
            profile("200",out);
            profile("300",out);
            
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
