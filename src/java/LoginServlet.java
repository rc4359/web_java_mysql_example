/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import mysql_func.MySQLAccess;
import mysql_func.macros.database_define;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author richard
 */
@WebServlet(urlPatterns = {"/LoginServlet"})
public class LoginServlet extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     * @throws java.sql.SQLException
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, SQLException {
        
                String username = request.getParameter("username");
                String password = request.getParameter("password");
                    
                
                if((username.equalsIgnoreCase("richard")) 
                        && (password.equalsIgnoreCase("123456789"))
                        )
                {
                    RequestDispatcher rd = request.getRequestDispatcher("admin_func/admin.html");
                    rd.forward(request, response);
                    return;
                }
                
                if((username.equalsIgnoreCase("lora")) 
                        && (password.equalsIgnoreCase("lora"))
                        )
                {
                    RequestDispatcher rd = request.getRequestDispatcher("lora/lora_main.html");
                    rd.forward(request, response);
                    return;
                }
                
                
                MySQLAccess sql_ac = new MySQLAccess();
            
                sql_ac.select_db("php_sql_login");
            
                if(sql_ac.db_connect() == 1)
                {    
            
                    //sql_ac.retrive_string_from_integer()
                    String db_password  = 
                       
                              sql_ac.get_field_where(database_define.DB_TBALE, database_define.DB_USER_FIELD, 
                                      username, database_define.DB_PWD_FIELD);                            
                 
                    System.out.print(" db_password --> " + db_password + "input pass -->" + password);
                    
                    if(db_password == null ? password == null : db_password.equals(password))
                    {
                        RequestDispatcher rd = request.getRequestDispatcher("welcome.html");
                        rd.forward(request, response);
                    }
                    else
                    {
                        RequestDispatcher rd = request.getRequestDispatcher("auth_fail.html");
                        rd.forward(request, response);
                    }
                    
                }
                
                sql_ac.db_close();
            
                    response.setContentType("text/html;charset=UTF-8");
                    try (PrintWriter out = response.getWriter()) 
                    {

                        /* TODO output your page here. You may use following sample code. */
                        out.println("<!DOCTYPE html>");
                        out.println("<html>");
                        out.println("<head>");
                        out.println("<title>Servlet LoginServlet</title>");            
                        out.println("</head>");
                        out.println("<body>");
                        out.println("<h1>Servlet LoginServlet at " + request.getContextPath() + "</h1>");

                        out.println("<h1> username --> " + username + "</h1>");
                        out.println("<h1> password --> " + password + "</h1>");

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
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
       {
        try {
          
            processRequest(request, response);
            
            System.out.println("----- doGet ------");        
        } catch (SQLException ex) {
            Logger.getLogger(LoginServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
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
        try {
            processRequest(request, response);
        } catch (SQLException ex) {
            Logger.getLogger(LoginServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
        


        System.out.println("----- doPost ------");
        
        
        
        
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
