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
課題「引数，戻り値２」を改修します。
整数型の変数 limit を値 2 で用意してください。そして，limit を利用して，表示するプロフィール情報を２名分のみにしてください。
*/
public class method8 extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
            ArrayList<String> profile(int ID,PrintWriter pw){
        ArrayList<String> human1 = new ArrayList<>();
                    human1.add("1");
                    human1.add("1生年月日");
                    human1.add("1住所");
        ArrayList<String> human2 = new ArrayList<>();
                    human2.add("2");
                    human2.add("2生年月日");
                    human2.add(null);
        ArrayList<String> human3 = new ArrayList<>();
                    human3.add("3");
                    human3.add("3生年月日");
                    human3.add("3住所");
                    
                    ArrayList<ArrayList<String>> PROFILE=new ArrayList<>();
                    PROFILE.add(human1);
                    PROFILE.add(human2);
                    PROFILE.add(human3);
                    
                    for(ArrayList<String> list :PROFILE){
                        int id_num;
                        id_num=Integer.parseInt(list.get(0));
                        if (ID== id_num) {
                            return list;
                        }
                                                
                    }
                    return null;
        }
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
     
            int limit=2;
            for (int i = 0; i < 3; i++) {
                    if (i >= limit) {
                        break;
                    }
                    ArrayList<String> file = profile(i,out);
                    
                    for (int j = 1; j < file.size(); j++) {
                        if (file.get(j) == null) {
                            continue;
                        }
                        out.print(file.get(j) + "<br>");
                    }
                }
            
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
