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
import static javax.ws.rs.client.Entity.form;

/**
 *
 * @author richard
 */
@WebServlet(name = "check_add_new_member", urlPatterns = {"/admin/check_add_new_member"})
public class check_add_new_member extends HttpServlet {

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
        
             String uname = "";
             String pwd = "";
             String mail ="";
             String web = "";
             String born_date = "";
             String summary = "";
             String comments = "";
             
         try
         {
            
              uname = request.getParameter("uname");
              pwd = request.getParameter("pwd");
              mail = request.getParameter("email");
              web = request.getParameter("web");
              born_date = request.getParameter("born_date");
              summary = request.getParameter("summary");
              comments = request.getParameter("comments");
         }
         catch(Exception e)
         {
                System.out.println(" Error : check member page error !!");
                e.printStackTrace();
         }
         
        
        
        
        
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet check_add_new_member</title>");            
            out.println("</head>");
            out.println("<body>");
           // out.println("<h1>Servlet check_add_new_member at " + request.getContextPath() + "</h1>");
            out.println("<h1 align=\"center\" style=\"color:red;\"> Your input data. please check again </h1>");
      /*
            out.println("<h2 align=\"center\" style=\"color:blue;\"> name :" + uname + "</h2>");
            out.println("<h2 align=\"center\" style=\"color:blue;\"> password :" + pwd + "</h2>");
            out.println("<h2 align=\"center\" style=\"color:blue;\"> mail :" + mail + "</h2>");
            out.println("<h2 align=\"center\" style=\"color:blue;\"> web site :" + web + "</h2>");
            out.println("<h2 align=\"center\" style=\"color:blue;\"> born_date :" + born_date + "</h2>");
            out.println("<h2 align=\"center\" style=\"color:blue;\"> summary :" + summary + "</h2>");
            out.println("<h2 align=\"center\" style=\"color:blue;\"> comments :" + comments + "</h2>");
        */    
            out.println("<div align = \"center\" style=\"color:blue; font-size:24px;\" >");
            out.println("<form action = \"../admin/empty_test\" method = \"post\">");
        
            
            
       
               /*
            out.println("<text name=\"uname\"> Name :" + uname +"</text><br />");
            out.println("<text name=\"pwd\"> Password " + pwd +"</text><br />");
            out.println("<text name=\"mail\"> E-mail :" + mail +"</text><br />");
            out.println("<text name=\"web\"> Web site:" + web +"</text><br />");
            out.println("<text name=\"born_date\" Born date :>" + born_date +"</text><br />");
            out.println("<text name=\"summary\"> Summary :" + summary +"</text><br />");
            out.println("<text name=\"comments\"> Comments " + comments +"</text><br />");
            */
            //out.println("<textarea style=\"font-size:13px;color:blue;\">");
            //out.println("</textarea>");
             out.println("<style>.comments { width: 600px; height: 75px; font-size:26px;color:blue;}</style>");
            out.println("<textarea class=\"comments\" name=\"uname\"> Name :" + uname +"</textarea><br />");
            out.println("<textarea class=\"comments\" name=\"pwd\"> Password " + pwd +"</textarea><br />");
            out.println("<textarea class=\"comments\" name=\"mail\"> E-mail :" + mail +"</textarea><br />");
            out.println("<textarea class=\"comments\" name=\"web\"> Web site:" + web +"</textarea><br />");
            out.println("<textarea class=\"comments\" name=\"born_date\" Born date :>" + born_date +"</textarea><br />");
            out.println("<textarea class=\"comments\" name=\"summary\"> Summary :" + summary +"</textarea><br />");
            out.println("<textarea class=\"comments\" name=\"comments\"> Comments " + comments +"</textarea><br />");
            
            out.println("<input   type = \"submit\" value = \" submit \"  style=\"width:120px;height:40px;font-size:20px;\" /><br />");
            out.println("</form>");  
            out.println("</div>");
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
