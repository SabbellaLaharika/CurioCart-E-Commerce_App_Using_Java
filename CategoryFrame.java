import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CategoryFrame extends JFrame implements ActionListener{
        JButton electronicsButton,fashionButton,essentialsButton,cosmeticsAndJewellaryButton,backButton;
        CategoryFrame()
        {
            setTitle("CurioCart/Categories");
            setIconImage(new ImageIcon("Images/MainIcons/Logo1.jpg").getImage());
            setSize(600,800);
            getContentPane().setBackground(Color.white);
            setBackground(Color.pink);
            setLayout(null);

            backButton = new JButton(new ImageIcon("Images/MainIcons/back1.jpg"));
            backButton.setBounds(5, 5, 50, 50);
            backButton.addActionListener(this);
            backButton.setBorderPainted(false);
            add(backButton);

            electronicsButton = new JButton("ELECTRONICS", new ImageIcon("Images/MainIcons/Electronics.jpg"));
            electronicsButton.setBounds(30,80,240,240);
            electronicsButton.addActionListener(this);
            electronicsButton.setBackground(Color.WHITE);
            electronicsButton.setBorderPainted(false);
            add(electronicsButton);

            fashionButton = new JButton("FASHION",new ImageIcon("Images/MainIcons/Fashion.png"));
            fashionButton.setBounds(300,80,240,240);
            fashionButton.addActionListener(this);
            fashionButton.setBackground(Color.WHITE);
            fashionButton.setBorderPainted(false);
            add(fashionButton);

            essentialsButton = new JButton("ESSENTIALS",new ImageIcon("Images/MainIcons/Essentials.jpg"));
            essentialsButton.setBounds(30,400,240,240);
            essentialsButton.addActionListener(this);
            essentialsButton.setBackground(Color.WHITE);
            essentialsButton.setBorderPainted(false);
            add(essentialsButton);

            cosmeticsAndJewellaryButton=new JButton("COSMETICS AND JEWELLARY",new ImageIcon("Images/MainIcons/CosmeticAndJewellary.jpg"));
            cosmeticsAndJewellaryButton.setBounds(300,400,232,240);
            cosmeticsAndJewellaryButton.addActionListener(this);
            cosmeticsAndJewellaryButton.setBorderPainted(false);
            add(cosmeticsAndJewellaryButton);

            setResizable(false);
            setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            setVisible(true);
        }
        public void actionPerformed(ActionEvent event){
            if(event.getSource() == backButton)
            {
                new WelcomeFrame();
            }
            if(event.getSource() == electronicsButton){
                new ElectronicsFrame();
            }
            if(event.getSource() == fashionButton){
                new FashionsFrame();
            }
            if(event.getSource() == essentialsButton){
                new EssentialsFrame();
            }
            if(event.getSource() == cosmeticsAndJewellaryButton){
                new CosmeticsAndJewellaryFrame();
            }
        }
}
