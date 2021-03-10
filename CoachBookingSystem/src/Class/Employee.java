/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Class;

import DBClass.DBConnection;
import Frames.EmpDashboard;
import Interface.Route;
import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultCellEditor;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;

/**
 *
 * @author Arun
 */
public class Employee implements Route{

    public static int employeeID;
    public static String employeeName;
    

    public String login(String empUsername, String empPassword) {
        String errorMsg = "";

        Connection conn = DBClass.DBConnection.createDBConnection();

        if (conn != null) {
            try {
                ResultSet rsEmp = conn.createStatement().executeQuery("select * from employee where emp_Username='" + empUsername + "'AND emp_Password='" + empPassword + "'");
                if (rsEmp.next()) {
                    employeeID = rsEmp.getInt("emp_ID");
                    employeeName = rsEmp.getString("emp_Name");
                    new EmpDashboard().setVisible(true);
                } else {
                    errorMsg = "Invalid Username or Password. Retry!";
                }
            } catch (SQLException ex) {
                errorMsg = "SQL connection failed!";
            }
        } else {
            errorMsg = "Database connection failed!";
        }
        return errorMsg;
    }

    @Override
    public String addRoute(String deptCountry,String deptTown,String destCountry,String destTown,String deptTime,double price,String week) {
        Connection conn = DBConnection.createDBConnection();
        String errorMsg="";
        
        if(conn!=null){
            try {
                ResultSet rsCust = conn.createStatement().executeQuery("select * from route where departure_Country='" + deptCountry + 
                        "'AND departure_Town='" + deptTown + "'AND destination_Country='" + destCountry + "'AND destination_Town='" + destTown + 
                        "'AND week='" + week + "'AND departure_Time='" + deptTime + "'");
                if (!rsCust.next()) {
                    int addedcount = conn.createStatement().executeUpdate("insert into route(departure_Country,departure_Town,"
                            + "destination_Country,destination_Town,week,departure_Time,price,capacity,employee_emp_ID) "
                            + "values('"+deptCountry+"','"+deptTown+"','"+destCountry+"','"+destTown+"','"+week+"','"+deptTime+"','"+price+"','"+SEAT_CAPACITY+"','"+employeeID+"')");
                    if(addedcount>0)
                    {
                        errorMsg = "Succesfully added";
                    }
                    else{
                        errorMsg = "Route addition failed";
                    }
                } else {
                    errorMsg = "This route already exists";
                }
            } catch (SQLException ex) {
               errorMsg = "SQL Error";
            }
        }else
        {
            errorMsg = "Database connectivity error";
        }
        return errorMsg;
    }
    
    @Override
    public int deleteRoute(int ID) {
        Connection conn = DBConnection.createDBConnection();
        int errorCode=0;
        if(conn!=null)
        {
            try {
                int count = conn.createStatement().executeUpdate("delete from route where route_ID='"+ID+"'");
                if(count>0)
                    errorCode=1;
                else
                    errorCode=0;
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
        return errorCode;
    }

    @Override
    public int modifyRoute(int Id, String deptCountry, String deptTown, String destCountry, String destTown, String time, double price, String week) {
        Connection conn = DBConnection.createDBConnection();
        int errorCode=0;
        if(conn!=null)
        {
            try {
                int count = conn.createStatement().executeUpdate("update route set departure_Country='"+deptCountry+"',departure_Town='"+deptTown
                        +"',destination_Country='"+destCountry+"',destination_Town='"+destTown+"',week='"+week+"',departure_Time='"+time+"',price='"+price
                        +"' where route_ID ='"+Id+"'");
                if(count>0)
                {
                    errorCode=1;
                }
                else{
                    errorCode=0;
                }
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
        return errorCode;
    }
    
    @Override
    public void searchRoute() {
        
    }

    public static void displyaRecord(String sID,JComboBox c1,JComboBox c2,JComboBox c3,JComboBox c4,JSpinner spinH,JSpinner spinM,JSpinner spin3,JTextField txt,JComboBox c5)
    {
        int id = Integer.parseInt(sID);
        
        Connection conn = DBConnection.createDBConnection();
        
        if(conn!=null)
        {
            try {
                ResultSet rsR = conn.createStatement().executeQuery("select * from route where route_ID='"+sID+"'");
                if(rsR.next())
                {
                    c1.setSelectedItem(rsR.getString("departure_Country"));
                    c2.setSelectedItem(rsR.getString("departure_Town"));
                    c3.setSelectedItem(rsR.getString("destination_Country"));
                    c4.setSelectedItem(rsR.getString("destination_Town"));
                    String time = rsR.getString("departure_Time");
                    if(time.length()==6)
                    {
                       // System.out.println(""+time.substring(0, 1));
                        spinH.setValue(Integer.parseInt(time.substring(0, 1)));
                        spinM.setValue(Integer.parseInt(time.substring(2, 3)));
                        spin3.setValue(time.substring(4));
                    }
                    else if(time.length()==7)
                    {
                        if(time.charAt(1)==':')
                        {
                            spinH.setValue(Integer.parseInt(time.substring(0, 1)));
                            spinM.setValue(Integer.parseInt(time.substring(2, 4)));
                            spin3.setValue(time.substring(5));
                        }
                        else if(time.charAt(2)==':')
                        {
                            spinH.setValue(Integer.parseInt(time.substring(0, 2)));
                            spinM.setValue(Integer.parseInt(time.substring(3, 4)));
                            spin3.setValue(time.substring(5));
                        }
                    }
                    else if(time.length()==8)
                    {
                        spinH.setValue(Integer.parseInt(time.substring(0, 2)));
                        spinM.setValue(Integer.parseInt(time.substring(3, 5)));
                        spin3.setValue(time.substring(6));
                    }
                    txt.setText(rsR.getString("price"));
                    c5.setSelectedItem(rsR.getString("week"));
                }
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
    }
    
    @Override
    public void loadAllRoute(JTable table,JPanel panel,JPanel panel2,JLabel lblID,JComboBox c1,JComboBox c2,JComboBox c3,JComboBox c4,JSpinner spinH,JSpinner spinM,JSpinner spin3,JTextField txt,JComboBox c5) {
        Connection conn = DBConnection.createDBConnection();
        
        if(conn!=null)
        {
            try {
                ResultSet rsRoute;
                rsRoute = conn.createStatement().executeQuery("select * from route"+EmpDashboard.searchString);
                
                DefaultTableModel dtmRoute = (DefaultTableModel) table.getModel();
                    dtmRoute.setRowCount(0);
                while(rsRoute.next())
                {
                    String deptcountry = rsRoute.getString("departure_Country");
                    String depttown = rsRoute.getString("departure_Town");
                    String destcountry = rsRoute.getString("destination_Country");
                    String desttown = rsRoute.getString("destination_Town");
                    String week = rsRoute.getString("week");
                    String time = rsRoute.getString("departure_Time");
                    double price = rsRoute.getDouble("price");
                    int capacity = rsRoute.getInt("capacity");
                    int empId = rsRoute.getInt("employee_emp_ID");
                    
                    int routeID = rsRoute.getInt("route_ID");
                    String modify = "MODIFY " + routeID;
                    
                    
                    
                    Vector vRoute = new Vector();
                    
                    vRoute.add(deptcountry);
                    vRoute.add(depttown);
                    vRoute.add(destcountry);
                    vRoute.add(desttown);
                    vRoute.add(week);
                    vRoute.add(time);
                    vRoute.add(price);
                    vRoute.add(capacity);
                    vRoute.add(empId);
                    vRoute.add(modify);
                    
                    
                    
                    dtmRoute.addRow(vRoute);
                }
            } catch (Exception e) {
                System.out.println("error");
            }
            table.getColumn("Modify/ Delete").setCellRenderer(new ButtonRenderer());
   
            table.getColumn("Modify/ Delete").setCellEditor(
            new ButtonEditor(new JCheckBox(),panel,panel2,lblID,c1,c2,c3,c4,spinH,spinM,spin3,txt,c5));
        }
    }

}

class ButtonEditor extends DefaultCellEditor {
  protected JButton button;

  private String label;

  private boolean isPushed;

  public ButtonEditor(JCheckBox checkBox,JPanel panel,JPanel panel2,JLabel lblID,JComboBox c1,JComboBox c2,JComboBox c3,JComboBox c4,JSpinner spinH,JSpinner spinM,JSpinner spin3,JTextField txt,JComboBox c5) {
    super(checkBox);
    button = new JButton();
    button.setOpaque(true);
    button.addActionListener(new ActionListener() {
      
        @Override
      public void actionPerformed(ActionEvent e) {
        enableModifyPanel(panel,panel2,lblID,c1,c2,c3,c4,spinH,spinM,spin3,txt,c5);
      }

        private void enableModifyPanel(JPanel panel,JPanel panel2,JLabel lblID,JComboBox c1,JComboBox c2,JComboBox c3,JComboBox c4,JSpinner spinH,JSpinner spinM,JSpinner spin3,JTextField txt,JComboBox c5) {
            panel.setVisible(isPushed);
            panel2.setVisible(!isPushed);
            String newLabel = label.substring(7);
            lblID.setText(newLabel);
            Employee.displyaRecord(newLabel,c1,c2,c3,c4,spinH,spinM,spin3,txt,c5);
//            System.out.println(""+button.getText() );
        }

    });
  }

  @Override
  public Component getTableCellEditorComponent(JTable table, Object value,
      boolean isSelected, int row, int column) {
    if (isSelected) {
      button.setForeground(table.getSelectionForeground());
      button.setBackground(table.getSelectionBackground());
    } else {
      button.setForeground(table.getForeground());
      button.setBackground(table.getBackground());
    }
    label = (value == null) ? "" : value.toString();
    button.setText(label);
    isPushed = true;
    return button;
  }

  @Override
  public Object getCellEditorValue() {
    if (isPushed) {
      
    }
    isPushed = false;
    return new String(label);
  }

  @Override
  public boolean stopCellEditing() {
    isPushed = false;
    return super.stopCellEditing();
  }

}

class ButtonRenderer extends JButton implements TableCellRenderer {

  public ButtonRenderer() {
    setOpaque(true);
  }

  @Override
  public Component getTableCellRendererComponent(JTable table, Object value,
      boolean isSelected, boolean hasFocus, int row, int column) {
    if (isSelected) {
      setForeground(table.getSelectionForeground());
      setBackground(table.getSelectionBackground());
    } else {
      setForeground(table.getForeground());
      setBackground(UIManager.getColor("Button.background"));
    }
    setText((value == null) ? "" : value.toString());
    return this;
  }

}
