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
//import net.proteanit.sql.*;
public class AddCustomer extends JFrame implements ActionListener{
    JTextField t1,t2,t3,t4,t5;
    JButton b1,b2;
    JComboBox c1;
    Choice c2;
    JRadioButton r1,r2;
    AddCustomer(){
        JLabel l1 =new JLabel("NEW CUSTOMER FORM");
        l1.setFont(new Font("Tahoma",Font.PLAIN,20));
        
        l1.setBounds(100,20,300,20);
              l1.setForeground(Color.BLUE);
              add(l1);
              JLabel l2 =new JLabel("ID");
        l2.setBounds(35,80,100,20);
              add(l2);
              c1 =new JComboBox(new String[]{"Passport","Voter-id Card","Driving License","Aadhar Card"});
               c1.setBackground(Color.WHITE);
              c1.setBounds(200,80,150,25);
              add(c1);
              
               JLabel l3 =new JLabel("NUMBER");
        l3.setBounds(35,120,100,20);
              add(l3);
              t1 =new JTextField();
              t1.setBounds(200,120,150,25);
              add(t1);
               JLabel l4 =new JLabel("NAME");
        l4.setBounds(35,160,100,20);
              add(l4);
              t2 =new JTextField();
              t2.setBounds(200,160,150,30);
              add(t2);
               JLabel l5 =new JLabel("GENDER");
        l5.setBounds(35,200,100,20);
              add(l5);
              r1 =new JRadioButton("Male");
              r1.setBounds(200,200,60,25);
              r1.setBackground(Color.WHITE);
              add(r1);
               r2 =new JRadioButton("Female");
              r2.setBounds(270,200,90,25);
              r2.setBackground(Color.WHITE);
              add(r2);
              
              JLabel l6 =new JLabel("COUNTRY");
        l6.setBounds(35,240,100,20);
              add(l6);
               t3 =new JTextField();
              t3.setBounds(200,240,150,30);
              add(t3);
              JLabel l7 =new JLabel("ALLOCATED ROOM NO");
        l7.setBounds(35,280,170,15);
              add(l7);
              c2 = new Choice();
               try{
            conn c=new conn();
            String str ="select* from  room";
                  ResultSet rs =  c.s.executeQuery(str);
                 
                   while(rs.next()){
                       c2.add(rs.getString("room_number"));
                   } 
        }catch(Exception e)
            
        {
            System.out.print(e);
        }      
               c2.setBounds(200,280,150,25);
            add(c2);
               
               
              JLabel l8 =new JLabel("CHECKED IN");
        l8.setBounds(35,320,100,20);
              add(l8);
              t4 =new JTextField();
              t4.setBounds(200,320,150,30);
              add(t4);
               JLabel l9 =new JLabel("DEPOSIT");
        l9.setBounds(35,360,100,20);
              add(l9);
              t5 =new JTextField();
              t5.setBounds(200,360,150,30);
              add(t5);
              
                b1 =new JButton("Add Customer");
              b1.setBounds(40,410,130,30);
               b1.setForeground(Color.BLACK);
          b1.setBackground(Color.WHITE);
         b1.addActionListener(this);
    
        
          add(b1);
           b2 =new JButton("Back");
              b2.setBounds(200,410,130,30);
               b2.setForeground(Color.BLACK);
          b2.setBackground(Color.WHITE);
         b2.addActionListener(this);
              add(b2);
              ImageIcon i1 =new ImageIcon(ClassLoader.getSystemResource("hotelmanagementsystem/icon/fifth.png"));
              Image i2 = i1.getImage().getScaledInstance(300, 400, Image.SCALE_DEFAULT);
              ImageIcon i3 =new ImageIcon(i2);
           JLabel l10 =new JLabel(i3);
           l10.setBounds(400,50,300,400);
           add(l10);
               getContentPane().setBackground(Color.WHITE);
        setBounds(500,200,800,500);
        setLayout(null);
        setVisible(true);
    }
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource() == b1){
        String id=(String)c1.getSelectedItem();
         String number =t1.getText();
         String name =t2.getText();
         String gender =null;
         if(r1.isSelected()){
             gender = "Male";
         }else if(r2.isSelected()){
             gender = "Female";
             
    }
     String country =t3.getText();
      String room =c2.getSelectedItem();
       String status =t4.getText();
        String deposit =t5.getText();
        
       
       
            String str ="insert into customer values('"+id+"','"+number+"','"+name+"','"+gender+"','"+country+"','"+room+"','"+status+"','"+deposit+"')";
                 String str2 ="update room set available ='Occupied' where room_number = '"+room+"'";
            
            try{ 
                       conn c=new conn();
            c.s.executeUpdate(str);
            c.s.executeUpdate(str2);
                    JOptionPane.showMessageDialog(null,"New Customer Added");
                    new Reception().setVisible(true);
                    this.setVisible(false);
        }catch(Exception e)
        {
            System.out.print(e);
        }        
    
        }
        else if(ae.getSource()== b2){
            new Reception().setVisible(true);
            this.setVisible(false);
        }
    }
     public static void main(String[] args){
        new AddCustomer().setVisible(true);
}
}
