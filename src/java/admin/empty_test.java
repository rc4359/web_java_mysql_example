/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package admin;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author richard
 */
@WebServlet(name = "empty_test", urlPatterns = {"/admin/empty_test"})
public class empty_test extends HttpServlet {

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
        
            String uname = request.getParameter("uname");
          
            String  pwd = request.getParameter("pwd");
            String  mail = request.getParameter("email");
            String  web = request.getParameter("web");
            String  born_date = request.getParameter("born_date");
            String  summary = request.getParameter("summary");
            String   comments = request.getParameter("comments");
        
        
        
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet empty_test</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet empty_test at " + request.getContextPath() + "</h1>");
            out.println("<h1>uname: " + uname + "</h1>");
            out.println("<h1>pwd: " + pwd + "</h1>");            
            out.println("<h1>mail: " + mail + "</h1>");
            out.println("<h1>web: " + web + "</h1>"); 
            out.println("<h1>born_date: " + born_date + "</h1>");
            out.println("<h1>summary: " + summary + "</h1>");
            out.println("<h1>comments: " + comments + "</h1>");
            out.println("<h1>Servlet empty_test at " + request.getContextPath() + "</h1>");
            
            
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
