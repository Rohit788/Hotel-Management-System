
package hotelmanagementsystem;



    
    
 import java.awt.*;
import javax.swing.*;
import java.awt.event.*;


   public  class HotelManagementSystem extends JFrame implements ActionListener{


        HotelManagementSystem() {
           // setBounds(300,200,1366,565);
        setSize(1366, 565);
            
          setLocation(100, 100);
            ImageIcon i1 =new ImageIcon(ClassLoader.getSystemResource("hotelmanagementsystem/icon/first.jpg"));
           JLabel l1 =new JLabel(i1);
           l1.setBounds(0,0,1366,565);
           add(l1);
          JLabel l2 = new JLabel("Hotel Management System");
          l2.setBounds(20,450,1000,80);
          l2.setForeground(Color.WHITE);
          l1.add(l2);
          l2.setFont(new Font("serif",Font.PLAIN,70));
          JButton b1 = new JButton("next");
          b1.setForeground(Color.BLACK);
          b1.setBackground(Color.WHITE);
          b1.setBounds(1150,450,150,30);
          b1.addActionListener(this);
          l1.add(b1);
           // setLayout(null);
            setVisible(true);
          while(true){
              l2.setVisible(false);
              try{
                  Thread.sleep(500);
                  
              }catch(Exception e){
                  
              }l2.setVisible(true);
              try{
                  Thread.sleep(500);
              }catch(Exception e){
          }
          }
         
          
}
    
public void actionPerformed(ActionEvent ae){
    new Login().setVisible(true);
    this.setVisible(false);
}


public static void main(String[] args) {
        // write your code here
        new HotelManagementSystem();
        
        }

   }