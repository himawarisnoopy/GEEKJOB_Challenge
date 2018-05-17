/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author kawas
 */
public class login_1 extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            Connection db_con = null;
            PreparedStatement db_st = null;
            String id = request.getParameter("id");
            String pass = request.getParameter("password");
            try {
               Class.forName("com.mysql.jdbc.Driver").newInstance();
               db_con = DriverManager.getConnection("jdbc:mysql://localhost:3306/geekjob_db", "KAWASAKI", "1028");
               
               HttpSession session =request.getSession();

               db_st = db_con.prepareStatement("select * from userstock where userID=? and password=?");
               db_st.setString(1,id);
               db_st.setString(2, pass);
               db_st.execute();
               
               ResultSet db_data = db_st.executeQuery();
               db_data.last();//カーソルをResultsetオブジェクト最終行に移動。boolean型
               int low =db_data.getRow();//現在の行番号を取得
               if(low==0){
                   db_con.close();
                   //out.print(id);
                   //out.print(pass);
                   RequestDispatcher rd =request.getRequestDispatcher("/login_failed");//ログインに失敗したときのページ
                   rd.forward(request,response);
               }else{
                   db_con.close();
                   session.setAttribute("userID",id);
                   session.setAttribute("password",pass);
                   
                   RequestDispatcher rd =request.getRequestDispatcher("/login_success.jsp");//ログインに成功したときのページ
                   rd.forward(request,response);
               }
               
           } catch (SQLException e_sql) {
               out.println("接続時にエラーが発生しました： " + e_sql.toString());
           } catch (Exception e) {
               out.println("接続時にエラーが発生しました： " + e.toString());
           } finally {
               if (db_con != null) {
                   try {
                       db_con.close();
                   } catch (Exception e_sql) {
                       System.out.println(e_sql.getMessage());
                   }
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
