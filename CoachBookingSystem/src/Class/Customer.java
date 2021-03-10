/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Class;

import DBClass.DBConnection;
import Frames.CustomerDashboard;
import Frames.EmpDashboard;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Arun
 */
public class Customer {

    public static int customerID;
    public static String customerName;
    public String errorMsg;
    
    public Customer(String custFName, String custLName, String custEmail, String password, 
            String gender, String dob, String pNumber, String address1, String address2) {
        
        Connection conn = DBConnection.createDBConnection();
        
        
        if(conn!=null){
            try {
                int addedcount = conn.createStatement().executeUpdate("insert into customer(customer_First_Name,customer_Last_Name,"
                        + "customer_Email,customer_Password,customer_Gender,customer_DOB,customer_PNumber,customer_Add_Street,customer_Add_City) "
                        + "values('"+custFName+"','"+custLName+"','"+custEmail+"','"+password+"','"+gender+"','"+dob+"','"+pNumber+"','"+address1+"','"+address2+"')");
                if(addedcount>0)
                {
                    errorMsg = "Succesfully registered";
                }
                else{
                    errorMsg = "Customer registration failed";
                }
            } catch (SQLException ex) {
                //errorMsg = "SQL Error";
                errorMsg = "This Username Already exist";
            }
        }else
        {
            errorMsg = "Database connectivity error";
        }
        
    }

    public Customer(String username, String password) {
        
        Connection conn = DBConnection.createDBConnection();
        
        if (conn != null) {
            try {
                ResultSet rsCust = conn.createStatement().executeQuery("select * from customer where customer_Email='" + username + "'AND customer_Password='" + password + "'");
                if (rsCust.next()) {
                    customerID = rsCust.getInt("customer_ID");
                    customerName = rsCust.getString("customer_First_Name");
                    new CustomerDashboard().setVisible(true);
                    errorMsg="";
                } else {
                    errorMsg = "Invalid Username or Password. Retry!";
                }
                
            } catch (SQLException ex) {
                errorMsg = "SQL connection failed!";
            }
        } else {
            errorMsg = "Database connection failed!";
        }
        
    }
        
}
