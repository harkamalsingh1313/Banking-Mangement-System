/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package banking_project;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JDialog;
import javax.swing.JOptionPane;

/**
 *
 * @author Ricky Islam
 */
public class remove {
    
    public static void function_remove () {
        
        String num = JOptionPane.showInputDialog(null, "Give Desired Account Number: ") ;
      
        if (num.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Give A Valid Account Number !!! ");
            
        }
        
        else {
            
                 try {
Class.forName("oracle.jdbc.driver.OracleDriver");
Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","shunno");

Statement stmt=con.createStatement();
ResultSet rs = null ;
rs =  stmt.executeQuery("SELECT * FROM customer  WHERE account like '"+num+"'  ");

if (rs.next()) {
       JDialog.setDefaultLookAndFeelDecorated(true);
       int response = JOptionPane.showConfirmDialog(null,"Do You Really Want To Detele This Account ???", "Confirmation", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE) ;
    if (response == JOptionPane.NO_OPTION) {
        JOptionPane.showMessageDialog(null, "Account Not Deleted !!");
    }
    else if (response == JOptionPane.YES_OPTION) {
         try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            Connection con1 = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "system", "shunno");

            String query = "delete from customer where account like '"+num+"' ";

            PreparedStatement p = null;
            p = con.prepareStatement(query);

            p.executeUpdate();

            JOptionPane.showMessageDialog(null, " Deleted Succussfully !!! ");
            con1.close();
  

}
                catch(Exception e){
                     JOptionPane.showMessageDialog(null, " Error: "+e);
                   }
       
        
    }
    
    
    
    
    
    
   
       
    
    
}
else {
    JOptionPane.showMessageDialog(null, " This Account Number Doesn't Exists !!! "); 
}


 con.close();      
        
          }

                catch(Exception e){
                     JOptionPane.showMessageDialog(null, " Error: "+e);
                   }   
       

            
            
            
        }
        
        
        
        
        
        
    }
    
}
