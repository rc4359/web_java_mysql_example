/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lora_j;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import mysql_func.MySQLAccess;
import mysql_func.macros.lora_db_log_data;

/**
 *
 * @author richard
 */
@WebServlet(name = "checkout_log", urlPatterns = {"/lora_j/checkout_log"})
public class checkout_log extends HttpServlet {

    
    
    
    public void show_db_string (String[] str, int rows, int column, HttpServletResponse response)
        throws ServletException, IOException{
        response.setContentType("text/html;charset=UTF-8");
        
        int show_row = 0;
        int show_column = 0;
        String html_line;
        
         try (PrintWriter out = response.getWriter()) {
                        /* TODO output your page here. You may use following sample code. */
                        out.println("<!DOCTYPE html>");
                        out.println("<html>");
                        out.println("<head>");
                        out.println("<title>Servlet checkout_log</title>");            
                        out.println("</head>");
                        out.println("<body>");
                        out.println("<h1>Servlet checkout_log </h1>");
                        out.println("<h1> ------------------------------------------------ </h1>");
                        /*  start show log */
                        
                        System.out.println("rows --> " + rows);
                        System.out.println("column --> " + column);
                        
                        while(show_row < rows)
                        {
                            html_line = "";
                            show_column = 0;
                            while(show_column < column)
                            {
                                int array_index = (show_column + (show_row * column));
                                html_line += "---";
                                html_line += str[array_index];
                                
                                show_column++;
                                //System.out.println("array_index --> " + array_index);
                                //System.out.println("show_column --> " + show_column);
                                //System.out.println("show_row --> " + show_row);
                                
                            }
                            out.println("<h1>" + html_line + "</h1>");
                            show_row++;
                               
                           
                        }
                        //System.out.println("end -- show_row --> " + show_row);
                         
                        /* --------------------- */
                        
                        out.println("<h1> ------------------------------------------------ </h1>");
                        out.println("<form action = \"checkout_log\" method = \"post\">");
                        out.println("<input type=\"submit\" name=\"act\" value=\"update\"/>");
                        out.println("<input type=\"submit\" name=\"act\" value=\"delete\"/>");
                        out.println("</form>");
                      
                                              
                        out.println("</body>");
                        out.println("</html>");
                        
                        
                        
                        }
    }
  
    
    public int retrive_db_string(String table, int rows, int column, String[] db_string)
    {
    
        int ret = 0;
        
        MySQLAccess sql_ac = new MySQLAccess();
            
        sql_ac.select_db(lora_data_define.LORA_LOG_BD);
            
        if(sql_ac.db_connect() == 1)
        {    
            ret =  sql_ac.get_table_string(table, rows, column, db_string);
        }
        sql_ac.db_close();
        //System.out.println(" db_string --> "+ db_string[0] + db_string[1] + db_string[2] +db_string[3]);
       // System.out.println(" db_string --> "+ db_string[4] + db_string[5] + db_string[6] +db_string[7]);
        return ret;
    }
    
    public int retive_db_rows(String table)
    {
        int rows = 0;
        
        MySQLAccess sql_ac = new MySQLAccess();
            
        sql_ac.select_db(lora_data_define.LORA_LOG_BD);
            
        if(sql_ac.db_connect() == 1)
        {    
            rows = sql_ac.get_how_many_rows(table);
            sql_ac.db_close();
                    
            System.out.println(" tbale" + lora_data_define.LORA_LOG_BD + "has " + rows + "rows");
        }
        
        return rows;
    }
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
        
        String act = request.getParameter("act");
        if (act == null) {
               System.out.println("---------- null --------");
        } else if (act.equals("delete")) {
                System.out.println("---------- delete --------");
        } else if (act.equals("update")) {
               System.out.println("---------- update  --------");
         } else {
               System.out.println("---------- something else --------");
        }
                int to_jsp = 0;
                lora_db_log_data l_db = new lora_db_log_data();
                int column = l_db.get_has_columns();
                int rows = retive_db_rows(lora_data_define.LORA_LOG_DEMO_TABLE);
                String [] db_string = new String[rows * column];
                
                
                if( rows > 0)  
                {
                        /* has some log in database */
                    
                        /* prepare buffer for retive logs */
                       System.out.println("rows * column --> " + rows * column);
                        
                        
                        int row_to_show = retrive_db_string(lora_data_define.LORA_LOG_DEMO_TABLE,
                                rows, column, db_string);
                        
                        if(row_to_show > 0)
                        {
                            show_db_string(db_string, row_to_show, column, response);
                            to_jsp = 0;
                        }
            
               
                        
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
        
                if(to_jsp == 1)
                {
                        RequestDispatcher requestDispatcher = request
                                .getRequestDispatcher("/lora/logjsp.jsp");
                         requestDispatcher.forward(request, response);
                    
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

    private void get_table_string(String table, int rows, int rows0, String[] db_string) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
