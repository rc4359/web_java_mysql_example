package admin;







/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import mysql_func.MySQLAccess;
import mysql_func.macros.database_define;

/**
 *
 * @author richard
 */
@WebServlet(urlPatterns = {"/admin/add_new_member_servlet"})
public class add_new_member_servlet extends HttpServlet {

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
        
        
            /*  Create a new row with empty content */
           int new_id = 0;
             String uname = "";
             String pwd = "";
             String mail = "";
             String web = "";
             String born_date = "";
             String summary = "";
             String comments = "";
             
           MySQLAccess sql_acc = new MySQLAccess();
           
           sql_acc.select_db(database_define.DB_NAME);
           int ret = sql_acc.creat_new_row(database_define.DB_TBALE);
        
           new_id = sql_acc.get_newest_row_id(database_define.DB_PRIVATE_KEY_ID);
            System.out.print(" ---   Add_new_Servlet  post -- ");
            
            
            /* Update all field each by each */
            
            try{
            
              uname = request.getParameter("uname");
              pwd = request.getParameter("pwd");
              mail = request.getParameter("mail");
              web = request.getParameter("web");
              born_date = request.getParameter("born_date");
              summary = request.getParameter("summary");
              comments = request.getParameter("comments");
             
             /*
             sql_acc.update_string_from_id(database_define.DB_TBALE, new_id,
                    database_define.DB_USER_FIELD, uname);
             
             sql_acc.update_string_from_id(database_define.DB_TBALE, new_id,
                    database_define.DB_PWD_FIELD, pwd);
             
             sql_acc.update_string_from_id(database_define.DB_TBALE, new_id,
                    database_define.DB_MAIL_FIELD, mail);
             
             sql_acc.update_string_from_id(database_define.DB_TBALE, new_id,
                    database_define.DB_WEBPAGE_FIELD, web);
             
             sql_acc.update_string_from_id(database_define.DB_TBALE, new_id,
                    database_define.DB_DATUM_FIELD, born_date);     
             
             sql_acc.update_string_from_id(database_define.DB_TBALE, new_id,
                    database_define.DB_SUMMARY_FIELD, summary);     
             
             sql_acc.update_string_from_id(database_define.DB_TBALE, new_id,
                    database_define.DB_COMMENTS_FIELD, comments);       
              */
            }
            catch(Exception e)
            {
                System.out.println(" Error : add row java action !!");
                e.printStackTrace();
            }
            
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet add_new_row_servlet</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1 align=\"center\">Servlet add_new_row_servlet at " + request.getContextPath() + "</h1>");
            out.println("<h1 align=\"center\"> new number id is" + Integer.toString(new_id) +"</h1>");
            
            out.println("<h2 align=\"center\" style=\"color:blue;\"> name :" + uname + "</h2>");
            out.println("<h2 align=\"center\" style=\"color:blue;\"> password :" + pwd + "</h2>");
            out.println("<h2 align=\"center\" style=\"color:blue;\"> mail :" + mail + "</h2>");
            out.println("<h2 align=\"center\" style=\"color:blue;\"> web site :" + web + "</h2>");
            out.println("<h2 align=\"center\" style=\"color:blue;\"> born_date :" + born_date + "</h2>");
            out.println("<h2 align=\"center\" style=\"color:blue;\"> summary :" + summary + "</h2>");
            out.println("<h2 align=\"center\" style=\"color:blue;\"> comments :" + comments + "</h2>");
            
            
            out.println("</body>");
            out.println("</html>");
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
