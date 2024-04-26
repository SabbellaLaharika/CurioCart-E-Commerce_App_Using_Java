import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

public class EssentialsFrame extends JFrame implements ActionListener{

    JButton devotionalItemsButton,giftItemsButton,boxesAndBottlesButton,soapsAndShampoosButton,backButton;
        JLabel essentialsLabel;
        EssentialsFrame()
        {
            setTitle("CurioCart/Categories/Essentials");
            setIconImage(new ImageIcon("Images/MainIcons/Logo1.jpg").getImage());
            getContentPane().setBackground(Color.white);
            setSize(600,800);
            setLayout(null);

            backButton = new JButton(new ImageIcon("Images/MainIcons/back1.jpg"));
            backButton.setBounds(5, 5, 50, 50);
            backButton.addActionListener(this);
            backButton.setBorderPainted(false);
            add(backButton);

            essentialsLabel = new JLabel("Essentials");
            essentialsLabel.setFont(new Font(essentialsLabel.getFont().getFontName(),Font.BOLD,35));
            essentialsLabel.setBounds(200,1,250,50);
            add(essentialsLabel);

            devotionalItemsButton = new JButton("Devotional Items",new ImageIcon("Images/Essentials/DevotionalItems.png"));
            devotionalItemsButton.setBounds(70,60,170,190);
            devotionalItemsButton.setBackground(Color.white);
            devotionalItemsButton.setVerticalTextPosition(SwingConstants.BOTTOM); // aligning products text to bottom
            devotionalItemsButton.setHorizontalTextPosition(SwingConstants.CENTER); // aligning products text to center
            devotionalItemsButton.setBorderPainted(false);
            devotionalItemsButton.addActionListener(this);
            add(devotionalItemsButton);
            
            giftItemsButton= new JButton("Gift Items",new ImageIcon("Images/Essentials/GiftItems.png"));
            giftItemsButton.setBounds(350,60,170,190);
            giftItemsButton.setBackground(Color.white);
            giftItemsButton.setVerticalTextPosition(SwingConstants.BOTTOM); // aligning products text to bottom
            giftItemsButton.setHorizontalTextPosition(SwingConstants.CENTER); // aligning products text to center
            giftItemsButton.setBorderPainted(false);
            giftItemsButton.addActionListener(this);
            add(giftItemsButton);

            boxesAndBottlesButton = new JButton("Boxes and Bottles",new ImageIcon("Images/Essentials/LunchBoxesAndBottles.png"));
            boxesAndBottlesButton.setBounds(70,300,170,190);
            boxesAndBottlesButton.setBackground(Color.white);
            boxesAndBottlesButton.setVerticalTextPosition(SwingConstants.BOTTOM); // aligning products text to bottom
            boxesAndBottlesButton.setHorizontalTextPosition(SwingConstants.CENTER); // aligning products text to center
            boxesAndBottlesButton.setBorderPainted(false);
            boxesAndBottlesButton.addActionListener(this);
            add(boxesAndBottlesButton);
            
            soapsAndShampoosButton = new JButton("Soaps and Shampoos",new ImageIcon("Images/Essentials/SoapsAndShampoos.png"));
            soapsAndShampoosButton.setBounds(350,300,170,190);
            soapsAndShampoosButton.setBackground(Color.white);
            soapsAndShampoosButton.setVerticalTextPosition(SwingConstants.BOTTOM); // aligning products text to bottom
            soapsAndShampoosButton.setHorizontalTextPosition(SwingConstants.CENTER); // aligning products text to center
            soapsAndShampoosButton.setBorderPainted(false);
            soapsAndShampoosButton.addActionListener(this);
            add(soapsAndShampoosButton);
            setResizable(false);
            setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            setVisible(true);
        }
        public void actionPerformed(ActionEvent event){
            if(event.getSource() == backButton)
            {
                new CategoryFrame();
            }
            if(event.getSource() == devotionalItemsButton){
                new DevotionalFrame();
            }
            if(event.getSource() == giftItemsButton){
                new GiftItemsFrame();
            }
            if(event.getSource() == boxesAndBottlesButton){
                new BoxesAndBottlesFrame();
            }
            if(event.getSource() == soapsAndShampoosButton){
                new SoapsAndShampoosFrame();
            }
        }
}
