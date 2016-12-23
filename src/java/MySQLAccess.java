
import com.sun.media.jfxmedia.logging.Logger;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


/**
 *
 * @author richard
 */
public class MySQLAccess {
   static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
   static final String DB_URL = "jdbc:mysql://localhost/php_ajax";

   //  Database credentials
   static final String USER = "root";
   static final String PASS = "000000";
   static Connection conn = null;
    
   String user_db = null;
   static final String mysql_prfix = "jdbc:mysql://localhost/";
           
   public void select_db(String s)
   {
       user_db = s;
   }
   
    public int db_connect()
    {
       
        try {
		Class.forName("com.mysql.jdbc.Driver");
	} catch (ClassNotFoundException e) {
		System.out.println("Where is your MySQL JDBC Driver?");
		e.printStackTrace();
		 return 0;
	}

        if(user_db == null)
        {
            System.out.println("----- No database had been selected ------");       
            return 0;
        }
        
        String db_url = mysql_prfix + user_db;
        
        try{   
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection(db_url, USER, PASS);
            
            System.out.println("----- Database connected ------");       
            return 1;
                   
        }
 
        catch(Exception e){
            e.printStackTrace();
            System.out.println( e.getMessage());
         
        }
        return 0;
    }
    
    public boolean db_close() 
    {
        if(conn != null)
        {
            System.out.println(" No Database connection to be close !! ");
            return false;
        }
        
        
        try{
            conn.close();
        }
        catch(Exception e)
        {
            System.out.println(" Excute close database error !! ");
            e.printStackTrace();
            return false;
        }
        
        System.out.println(" Database closed @@");
        return true;
    }
    
}
