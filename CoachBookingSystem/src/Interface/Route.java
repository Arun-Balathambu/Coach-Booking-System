/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interface;

import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.JTable;
import javax.swing.JTextField;

/**
 *
 * @author Lenovo
 */
public interface Route {
    
    int SEAT_CAPACITY = 40;
    
    public String addRoute(String deptCountry,String deptTown,String destCountry,String destTown,String deptTime,double price,String week);
    public int modifyRoute(int Id,String deptCountry,String deptTown,String destCountry,String destTown,String time,double price,String week);
    public int deleteRoute(int ID);
    public void searchRoute();
    public void loadAllRoute(JTable table,JPanel panel,JPanel panel2,JLabel lblID,
            JComboBox c1,JComboBox c2,JComboBox c3,JComboBox c4,JSpinner spinH,JSpinner spinM,JSpinner spin3,JTextField txt,JComboBox c5);
}
