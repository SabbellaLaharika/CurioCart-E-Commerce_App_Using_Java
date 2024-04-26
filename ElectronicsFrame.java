
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ElectronicsFrame extends JFrame implements ActionListener{
        JButton mobilesButton,laptopsButton,washingMachinesButton,grinderButton,fansButton,lightsButton,backButton;
        JLabel electronicsLabel;
        public ElectronicsFrame()
        {
            setTitle("CurioCart/Categories/Electronics");
            setIconImage(new ImageIcon("Images/MainIcons/Logo1.jpg").getImage());
            getContentPane().setBackground(Color.white);
            setSize(600,800);
            setLayout(null);

            backButton = new JButton(new ImageIcon("Images/MainIcons/back1.jpg"));
            backButton.setBounds(5, 5, 50, 50);
            backButton.addActionListener(this);
            backButton.setBorderPainted(false);
            add(backButton);

            electronicsLabel = new JLabel("Electronics");
            electronicsLabel.setFont(new Font(electronicsLabel.getFont().getFontName(),Font.BOLD,35));
            electronicsLabel.setBounds(200,1,250,50);
            add(electronicsLabel);

            mobilesButton = new JButton("Mobiles",new ImageIcon("Images/Electronics/Mobiles.jpg"));
            mobilesButton.setBounds(70,60,170,190);
            mobilesButton.setBackground(Color.white);
            mobilesButton.setVerticalTextPosition(SwingConstants.BOTTOM); // aligning products text to bottom
            mobilesButton.setHorizontalTextPosition(SwingConstants.CENTER); // aligning products text to center
            mobilesButton.setBorderPainted(false);
            mobilesButton.addActionListener(this);
            add(mobilesButton);
            
            laptopsButton = new JButton("Laptops",new ImageIcon("Images/Electronics/Laptops.jpg"));
            laptopsButton.setBounds(350,60,170,190);
            laptopsButton.setBackground(Color.white);
            laptopsButton.setVerticalTextPosition(SwingConstants.BOTTOM); // aligning products text to bottom
            laptopsButton.setHorizontalTextPosition(SwingConstants.CENTER); // aligning products text to center
            laptopsButton.setBorderPainted(false);
            laptopsButton.addActionListener(this);
            add(laptopsButton);

            washingMachinesButton = new JButton("Washing machines",new ImageIcon("Images/Electronics/WashingMachines.jpg"));
            washingMachinesButton.setBounds(70,300,170,190);
            washingMachinesButton.setBackground(Color.white);
            washingMachinesButton.setVerticalTextPosition(SwingConstants.BOTTOM); // aligning products text to bottom
            washingMachinesButton.setHorizontalTextPosition(SwingConstants.CENTER); // aligning products text to center
            washingMachinesButton.setBorderPainted(false);
            washingMachinesButton.addActionListener(this);
            add(washingMachinesButton);
            
            grinderButton = new JButton("Grinders",new ImageIcon("Images/Electronics/Grinders1.jpg"));
            grinderButton.setBounds(350,300,170,190);
            grinderButton.setBackground(Color.white);
            grinderButton.setVerticalTextPosition(SwingConstants.BOTTOM); // aligning products text to bottom
            grinderButton.setHorizontalTextPosition(SwingConstants.CENTER); // aligning products text to center
            grinderButton.setBorderPainted(false);
            grinderButton.addActionListener(this);
            add(grinderButton);

            fansButton = new JButton("Fans",new ImageIcon("Images/Electronics/Fans.jpg"));
            fansButton.setBounds(70,540,170,190);
            fansButton.setBackground(Color.white);
            fansButton.setVerticalTextPosition(SwingConstants.BOTTOM); // aligning products text to bottom
            fansButton.setHorizontalTextPosition(SwingConstants.CENTER); // aligning products text to center
            fansButton.setBorderPainted(false);
            fansButton.addActionListener(this);
            add(fansButton);
            
            lightsButton = new JButton("Lights",new ImageIcon("Images/Electronics/Lights.jpg"));
            lightsButton.setBounds(350,540,170,190);
            lightsButton.setBackground(Color.white);
            lightsButton.setVerticalTextPosition(SwingConstants.BOTTOM); // aligning products text to bottom
            lightsButton.setHorizontalTextPosition(SwingConstants.CENTER); // aligning products text to center
            lightsButton.setBorderPainted(false);
            lightsButton.addActionListener(this);
            add(lightsButton);

            setResizable(false);
            setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            setVisible(true);
        }
        public void actionPerformed(ActionEvent event){
            if(event.getSource() == backButton)
            {
                new CategoryFrame();
            }
            if(event.getSource() == mobilesButton){
                new MobilesFrame();
            }
            if(event.getSource() == laptopsButton){
                new LaptopsFrame();
            }
            if(event.getSource() == washingMachinesButton){
                new WashingMachinesFrame();
            }
            if(event.getSource() == grinderButton){
                new GrindersFrame();
            }
            if(event.getSource() == fansButton){
                new FansFrame();
            }
            if(event.getSource() == lightsButton){
                new LightsFrame();
            }
        }
}