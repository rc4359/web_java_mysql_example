package mysql_func;


import com.sun.media.jfxmedia.logging.Logger;
import java.lang.Boolean;
import static java.lang.Boolean.TRUE;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

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
   
   
   static final int DATA_TYPE_INT =  0;
   static final int DATA_TYPE_STR =  1;

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
 
    
   
    
    public String retrieve_string_from_string(String table, String where, String where_var, String field)
    {
        String s = null;

        String aql_cmd = "SELECT * from " + table + " WHERE " + where + " = '" + where_var +"'";
 
                
        try{
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(aql_cmd);
            
            while (rs.next()) 
            {                
                s = rs.getString(field);
      
            }
        }
        catch(Exception e)
        {
            System.out.print(" retrieve_string_from_integer can't get Statement !! ");
        
        }
        
        System.out.print(aql_cmd);
        
        return s;
    }    

    public int creat_new_row(String table)
    {
        int id = 0;
        //INSERT INTO `comments` VALUES (default,default,default,default,default,default,default,default);
        String aql_cmd = "INSERT INTO `" + table +"` VALUES ()";
        
        if(conn == null)
            db_connect();
        
        try
        {
            System.out.println("creat_new_row");
            System.out.println("aql_cmd =" + aql_cmd );
            Statement st = conn.createStatement();
            id = st.executeUpdate(aql_cmd);
        }
        catch(Exception e)
        {
            System.out.println(" creat_new_row error !! ");
            e.printStackTrace();
        }
        
        
       return id ;
         
    }
    
    public int get_newest_row_id(String private_key_id)
    {
        int id = -1;
        
       
        
        String sql_cmd = "SELECT * FROM comments ORDER BY id DESC LIMIT 1";
        
        try{
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(sql_cmd);
            
            while (rs.next()) 
            {                
                id = rs.getInt(private_key_id);
      
            }
        }
        catch(Exception e)
        {
            System.out.print(" get_newest_row_id error  !! ");
            e.printStackTrace();
        }
        
        System.out.print(sql_cmd);
        System.out.println("get_newest_row_id = " + id);
        
        return id;
    }

}
