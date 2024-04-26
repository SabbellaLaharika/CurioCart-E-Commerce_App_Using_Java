import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

public class CosmeticsAndJewellaryFrame extends JFrame implements ActionListener{
    JButton banglesAndRingsButton,makeUpButton,earingsButton,creamsAndLotionsButton,jewellaryButton,backButton;
        JLabel cosmeticsAndJewellaryLabel;
        CosmeticsAndJewellaryFrame()
        {
            setTitle("CurioCart/Categories/CosmeticsAndJewellary");
            setIconImage(new ImageIcon("Images/MainIcons/Logo1.jpg").getImage());
            getContentPane().setBackground(Color.white);
            setSize(600,800);
            setLayout(null);

            backButton = new JButton(new ImageIcon("Images/MainIcons/back1.jpg"));
            backButton.setBounds(5, 5, 50, 50);
            backButton.addActionListener(this);
            backButton.setBorderPainted(false);
            add(backButton);

            cosmeticsAndJewellaryLabel = new JLabel("Cosmetics And Jewellary");
            cosmeticsAndJewellaryLabel.setFont(new Font(cosmeticsAndJewellaryLabel.getFont().getFontName(),Font.BOLD,35));
            cosmeticsAndJewellaryLabel.setBounds(100,1,500,50);
            add(cosmeticsAndJewellaryLabel);

            banglesAndRingsButton = new JButton("Bangles And Rings",new ImageIcon("Images/CosmeticsAndJewellary/BanglesAndRings.png"));
            banglesAndRingsButton.setBounds(70,60,170,190);
            banglesAndRingsButton.setBackground(Color.white);
            banglesAndRingsButton.setVerticalTextPosition(SwingConstants.BOTTOM); // aligning products text to bottom
            banglesAndRingsButton.setHorizontalTextPosition(SwingConstants.CENTER); // aligning products text to center
            banglesAndRingsButton.setBorderPainted(false);
            banglesAndRingsButton.addActionListener(this);
            add(banglesAndRingsButton);
            
            makeUpButton = new JButton("MakeUp",new ImageIcon("Images/CosmeticsAndJewellary/MakeUp.png"));
            makeUpButton.setBounds(350,60,170,190);
            makeUpButton.setBackground(Color.white);
            makeUpButton.setVerticalTextPosition(SwingConstants.BOTTOM); // aligning products text to bottom
            makeUpButton.setHorizontalTextPosition(SwingConstants.CENTER); // aligning products text to center
            makeUpButton.setBorderPainted(false);
            makeUpButton.addActionListener(this);
            add(makeUpButton);

            creamsAndLotionsButton = new JButton("Creams And Lotions",new ImageIcon("Images/CosmeticsAndJewellary/CreamsAndLotions.png"));
            creamsAndLotionsButton.setBounds(70,300,170,190);
            creamsAndLotionsButton.setBackground(Color.white);
            creamsAndLotionsButton.setVerticalTextPosition(SwingConstants.BOTTOM); // aligning products text to bottom
            creamsAndLotionsButton.setHorizontalTextPosition(SwingConstants.CENTER); // aligning products text to center
            creamsAndLotionsButton.setBorderPainted(false);
            creamsAndLotionsButton.addActionListener(this);
            add(creamsAndLotionsButton);
            
            earingsButton = new JButton("Earings and Studs",new ImageIcon("Images/CosmeticsAndJewellary/Earings.png"));
            earingsButton.setBounds(350,300,170,190);
            earingsButton.setBackground(Color.white);
            earingsButton.setVerticalTextPosition(SwingConstants.BOTTOM); // aligning products text to bottom
            earingsButton.setHorizontalTextPosition(SwingConstants.CENTER); // aligning products text to center
            earingsButton.setBorderPainted(false);
            earingsButton.addActionListener(this);
            add(earingsButton);

            jewellaryButton = new JButton("Jewellary",new ImageIcon("Images/CosmeticsAndJewellary/Jewellary.png"));
            jewellaryButton.setBounds(70,540,170,190);
            jewellaryButton.setBackground(Color.white);
            jewellaryButton.setVerticalTextPosition(SwingConstants.BOTTOM); // aligning products text to bottom
            jewellaryButton.setHorizontalTextPosition(SwingConstants.CENTER); // aligning products text to center
            jewellaryButton.setBorderPainted(false);
            jewellaryButton.addActionListener(this);
            add(jewellaryButton);

            setResizable(false);
            setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            setVisible(true);
        }
        public void actionPerformed(ActionEvent event){
            if(event.getSource() == backButton)
            {
                new CategoryFrame();
            }
            if(event.getSource() == banglesAndRingsButton){
                new BanglesAndRingsFrame();
            }
            if(event.getSource() == makeUpButton){
                new MakeUpFrame();
            }
            if(event.getSource() == creamsAndLotionsButton){
                new CreamsAndLotionsFrame();
            }
            if(event.getSource() == earingsButton){
                new EaringsFrame();
            }
            if(event.getSource() == jewellaryButton){
                new JewellaryFrame();
            }
        }
}