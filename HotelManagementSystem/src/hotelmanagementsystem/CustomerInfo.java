/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hotelmanagementsystem;

/**
 *
 * @author rk565
 */
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.sql.*;
import net.proteanit.sql.*;
public class CustomerInfo extends JFrame implements ActionListener{
    
    JTable t1;
    JButton b1,b2;
    CustomerInfo(){
        t1 =new JTable();
        t1.setBounds(0,40,1000,500);
        add(t1);
        JLabel l1=new JLabel("Document Type");
        l1.setBounds(10,10,100,20);
        add(l1);
        JLabel l2=new JLabel("Number");
        l2.setBounds(160,10,70,20);
        add(l2);
        JLabel l3=new JLabel("Name");
        l3.setBounds(290,10,70,20);
        add(l3);
        JLabel l4=new JLabel("Gender");
        l4.setBounds(410,10,70,20);
        add(l4);
        JLabel l5=new JLabel("Country");
        l5.setBounds(540,10,70,20);
        add(l5);
        JLabel l6=new JLabel("Room Number");
        l6.setBounds(640,10,100,20);
        add(l6);
        JLabel l7=new JLabel("Status");
        l7.setBounds(790,10,70,20);
        add(l7);
        JLabel l8=new JLabel("Deposit");
        l8.setBounds(900,10,70,20);
        add(l8);
        
         b1 =new JButton("Load Data");
              b1.setBounds(350,560,120,30);
              b1.setForeground(Color.BLACK);
          b1.setBackground(Color.WHITE);
         b1.addActionListener(this);
    
        
          add(b1);
          
          b2 =new JButton("Back");
              b2.setBounds(530,560,120,30);
               b2.setForeground(Color.BLACK);
          b2.setBackground(Color.WHITE);
         b2.addActionListener(this);
         add(b2);
        getContentPane().setBackground(Color.WHITE);
        setBounds(350,100,980,650);
        setLayout(null);
        setVisible(true);
    }
     public void actionPerformed(ActionEvent ae){
          if (ae.getSource()== b1){
              
        try{
            conn c=new conn();
            String str ="select* from  customer ";
                  ResultSet rs =  c.s.executeQuery(str);
                  t1.setModel(DbUtils.resultSetToTableModel(rs));
                    
        }catch(Exception e)
        {
            System.out.print(e);
        }        
       
     }
         else if (ae.getSource()== b2){
             new Reception().setVisible(true);
         
        this.setVisible(false);
         
     }
     }
      public static void main(String[] args){
        new CustomerInfo().setVisible(true);
        
    }
    
}
