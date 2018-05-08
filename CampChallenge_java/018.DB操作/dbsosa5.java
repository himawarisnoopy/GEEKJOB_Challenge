/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 *
 * @author kawas
 */
public class dbsosa5 extends HttpServlet {

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
    特定のレコードの情報取得と表示

JDBC を利用して，部分一致検索処理を記述します。 
大単元「データベース基礎」の課題「テーブルの作成とinsert」で作成したテーブルについて，name カラムに「茂」を含むレコードを検索してください。また，検索結果のレコードについて，すべてのカラムの値を画面に表示してください。
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

               db_st = db_con.prepareStatement("SELECT * FROM profiles WHERE name LIKE ?;");
               db_st.setString(1, "%茂%");
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
           } catch (SQLException e) {
               out.println("接続時にエラーが発生しました： " + e.toString());
           } catch (Exception e) {
               out.println("接続時にエラーが発生しました： " + e.toString());
           } finally {
               if (db_con != null) {
                   try {
                       db_con.close();
                   } catch (Exception e) {
                       System.out.println(e.getMessage());
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
