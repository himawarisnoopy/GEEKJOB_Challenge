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
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author kawas
 */
public class dbsosa6 extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    /*
    特定のレコードの削除

JDBC を利用して，削除処理を記述します。 
課題「テーブルへ情報を格納」で挿入したレコードを削除してください。その後，全件検索を行い，全レコードの全カラムを画面表示してください
    */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            Connection db_con = null;
            PreparedStatement db_st = null;
            try {
               Class.forName("com.mysql.jdbc.Driver").newInstance();
               db_con = DriverManager.getConnection("jdbc:mysql://localhost:3306/geekjob_db", "KAWASAKI", "1028");

               db_st = db_con.prepareStatement("DELETE FROM profiles WHERE profilesID = ?");
               db_st.setInt(1, 5);
               db_st.execute();
               db_st=db_con.prepareStatement("SELECT * FROM profiles;");
               ResultSet db_data = db_st.executeQuery();
         
               while(db_data.next()) {
                   out.println("ID: " + db_data.getInt("profilesID"));
                   out.println(", Name: " + db_data.getString("name"));
                   out.println(", Tell: " + db_data.getString("tell"));
                   out.println(", Age: " + db_data.getInt("age"));
                   out.println(", Birthdaty: " + db_data.getDate("birthday").toString());
                   out.println("<br>");
               }
               db_con.close();
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
