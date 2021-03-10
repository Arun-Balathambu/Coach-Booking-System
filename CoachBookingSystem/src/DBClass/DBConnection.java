/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DBClass;

import java.sql.Connection;
import java.sql.DriverManager;



/**
 *
 * @author Lenovo
 */
public class DBConnection {
    
    static Connection dbconn;
    
    public static Connection createDBConnection()
    {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            
            dbconn = DriverManager.getConnection("jdbc:mysql://localhost:3306/europebus_database", "root", "");
            
            return dbconn;
        } catch (Exception e) {
            return null;
        }
    }
}
