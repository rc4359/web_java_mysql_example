/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lora_j;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import mysql_func.MySQLAccess;

/**
 *
 * @author richard
 */
@WebServlet(name = "checkout_log", urlPatterns = {"/lora_j/checkout_log"})
public class checkout_log extends HttpServlet {

  
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
        
                MySQLAccess sql_ac = new MySQLAccess();
            
                sql_ac.select_db(lora_data_define.LORA_LOG_BD);
            
                if(sql_ac.db_connect() == 1)
                {    
                    int rows = sql_ac.get_how_many_rows(lora_data_define.LORA_LOG_DEMO_TABLE);
                    sql_ac.db_close();
                    
                    System.out.println(" tbale" + "has " + rows + "rows");
                    
                }
                else
                {
                     try (PrintWriter out = response.getWriter()) {
                        /* TODO output your page here. You may use following sample code. */
                        out.println("<!DOCTYPE html>");
                        out.println("<html>");
                        out.println("<head>");
                        out.println("<title>Servlet checkout_log</title>");            
                        out.println("</head>");
                        out.println("<body>");
                        out.println("<h1>Servlet checkout_log at " + request.getContextPath() + "</h1>");
                        out.println("<h1> LORA database has error occurs !! </h1>");
                        out.println("</body>");
                        out.println("</html>");
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
