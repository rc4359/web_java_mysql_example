/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mysql_func.macros;


/**
 *
 * @author richard
 */
public class lora_db_log_data {
   // String addres =     "0";
   // String sequence =   "0";
   // String message =    "0";
    
    private final int column = 4;
    
    public class lora_column_string{
            String id       =   "0";
            String addres   =     "0";
            String sequence =   "0";
            String message  =    "0";
    }
  
    
    public int get_has_columns()
    {
        return column;
    }
}
