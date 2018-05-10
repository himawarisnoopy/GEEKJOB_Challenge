/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kensaku;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author kawas
 */
public class kensaku_b extends HttpServlet {

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
            
            String key1 = request.getParameter("name");
            String key2 = request.getParameter("tel");
            int key3 = Integer.parseInt(request.getParameter("age"));
            Date key4 = getDate(request.getParameter("birthday"));
            
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet kensaku_b</title>");            
            out.println("</head>");
            out.println("<body>");
            
            if (key4 == null) {
                out.println("エラーが発生しました．");
            } else {
                insertProfile(out, key1, key2, key3, key4);
            }
            
            out.println("</body>");
            out.println("</html>");
        }
    }
    
    private Date getDate(String dateString) {
        final String DATE_FORMAT = "yyyy-MM-dd";
        SimpleDateFormat sdf = new SimpleDateFormat(DATE_FORMAT);
        try {
            java.util.Date date = sdf.parse(dateString);
            return new Date(date.getTime());
        } catch (ParseException ex) {
            System.out.println(ex.getMessage());
            return null;
        }
    }
    
    private void insertProfile(PrintWriter out, 
            String name, String tell, int age, Date birthday) {

        Connection db_con = null;
        PreparedStatement st = null;

        try {
            Class.forName("com.mysql.jdbc.Driver").newInstance();
           db_con = DriverManager.getConnection("jdbc:mysql://localhost:3306/geekjob_db", "KAWASAKI", "1028");

            st = db_con.prepareStatement("INSERT INTO profiles VALUES(?, ?, ?, ?, ?)");
            st.setInt(1, 10);
            st.setString(2, name);
            st.setString(3, tell);
            st.setInt(4, age);
            st.setDate(5, birthday);
            st.execute();
            db_con.close();
            out.println("書き込みが正常に完了しました．");
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
