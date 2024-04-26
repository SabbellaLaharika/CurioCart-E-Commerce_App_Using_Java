import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

public class FashionsFrame extends JFrame implements ActionListener{
    JButton sareesButton,shirtsButton,jeanAndHoddiesButton,watchsButton,shoesButton,slippersButton,backButton;
        JLabel fashionLabel;
        FashionsFrame()
        {
            setTitle("CurioCart/Categories/Fashion");
            setIconImage(new ImageIcon("Images/MainIcons/Logo1.jpg").getImage());
            getContentPane().setBackground(Color.white);
            setSize(600,800);
            setLayout(null);

            backButton = new JButton(new ImageIcon("Images/MainIcons/back1.jpg"));
            backButton.setBounds(5, 5, 50, 50);
            backButton.addActionListener(this);
            backButton.setBorderPainted(false);
            add(backButton);

            fashionLabel = new JLabel("Fashion");
            fashionLabel.setFont(new Font(fashionLabel.getFont().getFontName(),Font.BOLD,35));
            fashionLabel.setBounds(200,1,250,50);
            add(fashionLabel);

            sareesButton = new JButton("Sarees",new ImageIcon("Images/Fashion/Sarees.jpg"));
            sareesButton.setBounds(70,60,170,190);
            sareesButton.setBackground(Color.white);
            sareesButton.setVerticalTextPosition(SwingConstants.BOTTOM); // aligning products text to bottom
            sareesButton.setHorizontalTextPosition(SwingConstants.CENTER); // aligning products text to center
            sareesButton.setBorderPainted(false);
            sareesButton.addActionListener(this);
            add(sareesButton);
            
            shirtsButton = new JButton("Shirts",new ImageIcon("Images/Fashion/Shirts.jpg"));
            shirtsButton.setBounds(350,60,170,190);
            shirtsButton.setBackground(Color.white);
            shirtsButton.setVerticalTextPosition(SwingConstants.BOTTOM); // aligning products text to bottom
            shirtsButton.setHorizontalTextPosition(SwingConstants.CENTER); // aligning products text to center
            shirtsButton.setBorderPainted(false);
            shirtsButton.addActionListener(this);
            add(shirtsButton);

            watchsButton = new JButton("Watches",new ImageIcon("Images/Fashion/Watch.jpg"));
            watchsButton.setBounds(70,300,170,190);
            watchsButton.setBackground(Color.white);
            watchsButton.setVerticalTextPosition(SwingConstants.BOTTOM); // aligning products text to bottom
            watchsButton.setHorizontalTextPosition(SwingConstants.CENTER); // aligning products text to center
            watchsButton.setBorderPainted(false);
            watchsButton.addActionListener(this);
            add(watchsButton);
            
            jeanAndHoddiesButton = new JButton("Jeans and Hoddies",new ImageIcon("Images/Fashion/Hoddies.jpg"));
            jeanAndHoddiesButton.setBounds(350,300,170,190);
            jeanAndHoddiesButton.setBackground(Color.white);
            jeanAndHoddiesButton.setVerticalTextPosition(SwingConstants.BOTTOM); // aligning products text to bottom
            jeanAndHoddiesButton.setHorizontalTextPosition(SwingConstants.CENTER); // aligning products text to center
            jeanAndHoddiesButton.setBorderPainted(false);
            jeanAndHoddiesButton.addActionListener(this);
            add(jeanAndHoddiesButton);

            shoesButton = new JButton("Shoes",new ImageIcon("Images/Fashion/Shoes.jpg"));
            shoesButton.setBounds(70,540,170,190);
            shoesButton.setBackground(Color.white);
            shoesButton.setVerticalTextPosition(SwingConstants.BOTTOM); // aligning products text to bottom
            shoesButton.setHorizontalTextPosition(SwingConstants.CENTER); // aligning products text to center
            shoesButton.setBorderPainted(false);
            shoesButton.addActionListener(this);
            add(shoesButton);
            
            slippersButton = new JButton("Slippers",new ImageIcon("Images/Fashion/Slippers.jpg"));
            slippersButton.setBounds(350,540,170,190);
            slippersButton.setBackground(Color.white);
            slippersButton.setVerticalTextPosition(SwingConstants.BOTTOM); // aligning products text to bottom
            slippersButton.setHorizontalTextPosition(SwingConstants.CENTER); // aligning products text to center
            slippersButton.setBorderPainted(false);
            slippersButton.addActionListener(this);
            add(slippersButton);

            setResizable(false);
            setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            setVisible(true);
        }
        public void actionPerformed(ActionEvent event){
            if(event.getSource() == backButton)
            {
                new CategoryFrame();
            }
            if(event.getSource() == sareesButton){
                new SareesFrame();
            }
            if(event.getSource() == shirtsButton){
                new ShirtsFrame();
            }
            if(event.getSource() == watchsButton){
                new WatchesFrame();
            }
            if(event.getSource() == jeanAndHoddiesButton){
                new JeansAndHoddiesFrame();
            }
            if(event.getSource() == shoesButton){
                new ShoesFrame();
            }
            if(event.getSource() == slippersButton){
                new SlippersFrame();
            }
        }
}
