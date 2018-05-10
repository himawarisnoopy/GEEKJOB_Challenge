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
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author kawas
 */
public class Multi extends HttpServlet {

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
    複合検索

以下のファイルを作成して，フォームで送信した値をもとにレコードの検索を行います。 

■ HTML ファイル 
大単元「データベース基礎」の課題「テーブルの作成とinsert」で作成したテーブルの名前・年齢・誕生日情報を送信するフォームを記述してください。 

■ JSP or サーブレットファイル（サーブレットとJSPを連携させても構いません） 
JDBC を利用して，複合検索処理を記述します。AND検索とするか，OR検索とするかは，自由に決めて構いません。
    */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            String name = request.getParameter("name");
            int age = Integer.parseInt(request.getParameter("age"));
            Date birthday = getDate(request.getParameter("birthday"));
            
            if (birthday != null) {
                printResult(out, name, age, birthday);
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
    
    private void printResult(PrintWriter out, String name, int age, Date birthday) {

        PreparedStatement st = null;
        Connection db_con=null;
        ResultSet data = null;

        try {
            Class.forName("com.mysql.jdbc.Driver").newInstance();
             db_con = DriverManager.getConnection("jdbc:mysql://localhost:3306/geekjob_db", "KAWASAKI", "1028");

            st = db_con.prepareStatement("SELECT * FROM profiles WHERE name LIKE ? OR age = ? OR birthday = ?");
            st.setString(1, "%" + name + "%");
            st.setInt(2, age);
            st.setDate(3, birthday);

            data = st.executeQuery();
            List<String> results = new ArrayList<>();
            while (data.next()) {
                StringBuilder sb = new StringBuilder();
                sb.append(data.getString("name")).append(", ")
                        .append(data.getString("tell")).append(", ")
                        .append(data.getInt("age")).append(", ")
                        .append(data.getDate("birthday").toString());
                results.add(sb.toString());
            }
            db_con.close();

            if (results.isEmpty()) {
                out.println("該当するデータが見つかりませんでした．");
            } else {
                out.println(results.size() + "件のデータが見つかりました．<br>");
                for (String row : results) {
                    out.println(row);
                    out.println("<br>");
                }
            }
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
