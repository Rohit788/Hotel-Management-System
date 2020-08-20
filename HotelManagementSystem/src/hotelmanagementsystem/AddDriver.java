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
public class AddDriver extends JFrame implements ActionListener
 {
    JTextField t1,t2,t3,t4,t5;
    JComboBox c1,c2;
    JButton b1,b2;
    AddDriver(){
        JLabel title =new JLabel("Add Rooms");
        title.setFont(new Font("Tahoma",Font.BOLD,17));
        title.setBounds(150,10,150,20);
              add(title) ;
              JLabel name =new JLabel("Name");
        name.setFont(new Font("Tahoma",Font.BOLD,15));
        name.setBounds(60,70,120,30);
              add(name) ;
               t1 =new JTextField();
              t1.setBounds(200,70,150,30);
              add(t1);
               JLabel age =new JLabel("Age");
        age.setFont(new Font("Tahoma",Font.BOLD,15));
        age.setBounds(60,110,120,30);
              add(age) ;
               t2 =new JTextField();
              t2.setBounds(200,110,150,30);
              add(t2);
               JLabel gender =new JLabel("Gender");
        gender.setFont(new Font("Tahoma",Font.BOLD,15));
        gender.setBounds(60,150,120,30);
              add(gender) ;
              c1= new JComboBox(new String[] {"Male" ,"Female"});
              c1.setBounds(200,150,150,30);
              c1.setBackground(Color.WHITE);
              add(c1);
               JLabel car =new JLabel("Car Company");
        car.setFont(new Font("Tahoma",Font.BOLD,15));
        car.setBounds(60,190,120,30);
              add(car) ;
              t3 =new JTextField();
              t3.setBounds(200,190,150,30);
              add(t3);
               JLabel model =new JLabel("Car Model");
        model.setFont(new Font("Tahoma",Font.BOLD,15));
        model.setBounds(60,230,120,30);
              add(model) ;
              t4 =new JTextField();
              t4.setBounds(200,230,150,30);
              add(t4);
               JLabel available =new JLabel("Available");
        available.setFont(new Font("Tahoma",Font.BOLD,15));
        available.setBounds(60,270,120,30);
              add(available) ;
              c2= new JComboBox(new String[] {"Available" ,"Occupied"});
              c2.setBounds(200,270,150,30);
              c2.setBackground(Color.WHITE);
              add(c2);
               JLabel location =new JLabel("Location");
        location.setFont(new Font("Tahoma",Font.BOLD,15));
        location.setBounds(60,310,120,30);
              add(location) ;
              t5 =new JTextField();
              t5.setBounds(200,310,150,30);
              add(t5);
              
               b1 =new JButton("Add Driver");
              b1.setBounds(60,370,130,30);
               b1.setForeground(Color.BLACK);
          b1.setBackground(Color.WHITE);
         b1.addActionListener(this);
    
      
          add(b1);
           b2 =new JButton("Cancel");
              b2.setBounds(220,370,130,30);
               b2.setForeground(Color.BLACK);
          b2.setBackground(Color.WHITE);
         b2.addActionListener(this);
              
              add(b2);
              getContentPane().setBackground(Color.WHITE);
              ImageIcon i1 =new ImageIcon(ClassLoader.getSystemResource("hotelmanagementsystem/icon/eleven.jpg"));
              Image i2 =i1.getImage().getScaledInstance(500, 400,Image.SCALE_DEFAULT);
          ImageIcon i3 =new ImageIcon(i2);
           JLabel l1=new JLabel(i3);
           l1.setBounds(400,80,500,300);
           add(l1);
                     
              
              
               setBounds(350,200,980,500);
        setLayout(null);
        setVisible(true);
    }
     public void actionPerformed(ActionEvent ae){
    if(ae.getSource()== b1){
        String name =t1.getText();
        String age=t2.getText();
        String gender=(String)c1.getSelectedItem();
         String car=t3.getText();
        String model=t4.getText();
        String available=(String)c2.getSelectedItem();
         String location=t5.getText();
     conn c=new conn();
     
            String str ="insert into drivers values('"+name+"','"+age+"','"+gender+"','"+car+"','"+model+"','"+available+"','"+location+"')";
            try{        
            c.s.executeUpdate(str);
                    JOptionPane.showMessageDialog(null,"Driver added successfully");
                  //  this.setVisible(false);
        }catch(Exception e)
        {
            System.out.print(e);
        }        
    }else if (ae.getSource()== b2){
        this.setVisible(false);
    }
     }
   // conn c=new conn();
    public static void main(String[] args){
        new AddDriver();
    }
}
