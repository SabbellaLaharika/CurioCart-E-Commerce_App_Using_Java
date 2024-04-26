import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.SwingConstants;
import javax.swing.ImageIcon;
import javax.swing.JButton;

// To create a class WelcomeFrame as a sub class of JFrame which can access all the methods of the JFrame.
public class WelcomeFrame extends JFrame implements ActionListener {
    JButton productsButton;
    WelcomeFrame(){
        setTitle("CurioCart");  // To set the title for the WelcomeFrame
        setSize(600,800);  // To set the size of the frame
        getContentPane().setBackground(Color.white);
        setLayout(null);  //To set the layout of frame as null
        setIconImage(new ImageIcon("Images/MainIcons/Logo1.jpg").getImage());  // To set logo for the frame
        productsButton = new JButton("PRODUCTS",new ImageIcon("Images/MainIcons/deal.jpeg")); // Creating a button with products image and text
        productsButton.setVerticalTextPosition(SwingConstants.BOTTOM); // aligning products text to bottom
        productsButton.setHorizontalTextPosition(SwingConstants.CENTER); // aligning products text to center
        productsButton.setBackground(Color.white);
        productsButton.setBounds(10,10,450,420);  // Giving position and size to the products button
        productsButton.addActionListener(this); // 
        add(productsButton);
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent event){
        if(event.getSource() == productsButton){
            new CategoryFrame();
        }
    }
}
