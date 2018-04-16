/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/*
引数、戻り値1
ユーザー定義メソッドを作成してください。引数・戻り値・処理内容については，以下の通りです。 

・引数 
　文字列型 
・戻り値 
　文字列型を要素に持つ配列型 
・処理内容 
　３人分のプロフィール情報を，それぞれ配列で作成してください（プロフィール情報の項目は，課題「戻り値2」と同様です）。そして，引数として受け取った ID の値と同じ ID の値を持つ配列を，戻り値として返してください。 

メソッドの呼び出し側の記述については，課題「戻り値2」と同様としてください。
*/

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author kawas
 */
@WebServlet(urlPatterns = {"/method6"})
public class method6 extends HttpServlet {

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
                    human2.add("2住所");
        ArrayList<String> human3 = new ArrayList<>();
                    human3.add(ID);
                    human3.add("3生年月日");
                    human3.add("3住所");
        
            
        
        if( null!=ID)switch (ID) {
                case "100":
                    for(int i=1;i<human1.size();i++){
                        pw.print(human1.get(i)+"<br>");
                    }
                    return human1;
                case "200":
                    for(int i=1;i<human2.size();i++){
                        pw.print(human2.get(i)+"<br>");
                    }
                    return human2;
                case "300":
                    for(int i=1;i<human3.size();i++){
                        pw.print(human3.get(i)+"<br>");
                    }
                    return human3;
                default:
                    break;
            }
        return null;

        }
        


    
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
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
