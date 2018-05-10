/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package form;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
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
/*
特定のレコードの更新

以下のファイルを作成して，フォームで送信した値をもとにレコードの更新を行います。

■HTMLファイル
大単元「データベース基礎」の課題「テーブルの作成とinsert」で作成したテーブルの全カラム情報を送信するフォームを記述してください。

■ JSP or サーブレットファイル（サーブレットとJSPを連携させても構いません）
JDBC を利用して，更新処理を記述します。このとき，更新対象のレコードはフォームから受け取った profilesID の値で指定してください。更新するカラムはの値は，フォームから受け取った profilesID 以外の値によって指定してください。また，全件検索を行い，全レコードの全カラムを画面表示してください。


*/
public class update extends HttpServlet {

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
            
            int profilesID = Integer.parseInt(request.getParameter("profilesID"));
            String name = request.getParameter("name");
            String tell = request.getParameter("tel");
            int age = Integer.parseInt(request.getParameter("age"));
            Date birthday = getDate(request.getParameter("birthday"));
            
            try {
               Class.forName("com.mysql.jdbc.Driver").newInstance();
               db_con = DriverManager.getConnection("jdbc:mysql://localhost:3306/geekjob_db", "KAWASAKI", "1028");

               db_st = db_con.prepareStatement("UPDATE profiles SET name = ?,tell=?,age=?,birthday=? WHERE profilesID=?");
               db_st.setString(1,name);
               db_st.setString(2,tell);
               db_st.setInt(3,age);
               db_st.setDate(4, birthday);
               db_st.setInt(5, profilesID);
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
