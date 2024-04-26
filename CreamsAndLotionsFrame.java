

import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.LayoutManager;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class CreamsAndLotionsFrame extends JFrame implements ActionListener{
    JButton backButton;
    public CreamsAndLotionsFrame() {
        setTitle("CurioCart/Categories/Cosmetics and Jewellary/CreamsAndLotions");
        setIconImage(new ImageIcon("Images/MainIcons/Logo1.jpg").getImage());
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(600, 800);
        getContentPane().setBackground(Color.white);
        backButton = new JButton(new ImageIcon("Images/MainIcons/back1.jpg"));
        backButton.setBounds(5, 5, 40, 40);
        backButton.addActionListener(this);
        backButton.setBackground(Color.white);
        backButton.setBorderPainted(false);
        add(backButton);
        // Create a panel with BoxLayout in Y_AXIS direction
        JPanel mainPanel = new JPanel();
        mainPanel.setLayout((LayoutManager) new BoxLayout(mainPanel, BoxLayout.Y_AXIS));
        mainPanel.setBackground(Color.WHITE);

        JLabel creamsAndLotionsLabel = new JLabel("Creams and Lotions");
        creamsAndLotionsLabel.setFont(new Font(creamsAndLotionsLabel.getFont().getFontName(),Font.BOLD,30));

        String[] images = {"Images/CosmeticsAndJewellary/CreamsAndLotions/1.png",
                            "Images/CosmeticsAndJewellary/CreamsAndLotions/2.png",
                            "Images/CosmeticsAndJewellary/CreamsAndLotions/3.png",
                            "Images/CosmeticsAndJewellary/CreamsAndLotions/4.png",
                            "Images/CosmeticsAndJewellary/CreamsAndLotions/5.png"};
        String[] brands = {"Rolex Submariner",
                            "Omega Speedmaster Professional",
                            "TAG Heuer Carrera",
                            "Seiko Prospex",
                            "Casio G-Shock"};
         
         String[] prices = {"\n   $8,000",
                            "\n   $5,500",
                            "\n   $4,000",
                            "\n   $700",
                            "\n   $150"};
         
         String[] features = {"Features:\n•  Stainless Steel Case\n•  Automatic Movement\n•  Water Resistant up to 300m\n•  Date Display\n•  Luminescent Hands and Markers",
                              "Features:\n•  Stainless Steel Case\n•  Manual-Winding Movement\n•  Water Resistant up to 50m\n•  Chronograph Function\n•  Tachymeter Scale",
                              "Features:\n•  Stainless Steel Case\n•  Automatic Movement\n•  Water Resistant up to 100m\n•  Date Display\n•  Chronograph Function",
                              "Features:\n•  Stainless Steel Case\n•  Automatic Movement\n•  Water Resistant up to 200m\n•  Date Display\n•  Rotating Bezel",
                              "Features:\n•  Resin Case\n•  Quartz Movement\n•  Water Resistant up to 200m\n•  Shock Resistant\n•  Stopwatch Function"};
     
        JPanel backButtonAndBlankSpacePanel = new JPanel(new BorderLayout());
        backButtonAndBlankSpacePanel.add(backButton,BorderLayout.WEST);
        backButtonAndBlankSpacePanel.setBackground(Color.WHITE);
        JLabel blankSpaceLabel = new JLabel("icsudhjfoehlfoehldfivcodj");
        blankSpaceLabel.setForeground(Color.WHITE);
        backButtonAndBlankSpacePanel.add(blankSpaceLabel,BorderLayout.CENTER);
        JPanel headerPanel = new JPanel(new BorderLayout());
        headerPanel.add(backButtonAndBlankSpacePanel,BorderLayout.WEST);
        headerPanel.setBackground(Color.WHITE);
        headerPanel.add(creamsAndLotionsLabel,BorderLayout.CENTER);
        mainPanel.add(headerPanel);

        for (int i = 0; i < 5; i++) {
            //ImageIcon imageIcon = new ImageIcon(images[i]); // Provide the path to your image file
                JLabel imageLabel = new JLabel(new ImageIcon(images[i]));
    
                // Label
                JLabel label = new JLabel("Price :");
                JLabel brandLabel = new JLabel(brands[i]);
                brandLabel.setBackground(Color.white);
                brandLabel.setFont(new Font(brandLabel.getFont().getFontName(), Font.BOLD,20));
                JLabel priceLabel= new JLabel(prices[i]);
                priceLabel.setBackground(Color.white);
                priceLabel.setFont(new Font(priceLabel.getFont().getFontName(), Font.BOLD, 15));
    
                // Description
                JTextArea featuresArea = new JTextArea(features[i]);
                featuresArea.setLineWrap(true);
                featuresArea.setWrapStyleWord(true);
                featuresArea.setEditable(false); // Make it non-editable*/
                featuresArea.setFont(new Font(featuresArea.getFont().getFontName(),Font.ITALIC,15));
    
                // Button
                JButton buyButton = new JButton("BUY");
                buyButton.setBackground(Color.PINK);
                final int k = i + 1;
                buyButton.addActionListener(new ActionListener() { 
                    public int count;
                    public void actionPerformed(ActionEvent e) {
                        try
                        {
                            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/products","root", "SL$12");
                            if(con != null)   System.out.println("Connection Successful");
                            
                            Statement st = con.createStatement();
                            //System.out.println(k);
                            ResultSet rs = st.executeQuery("select stockAvail from lotions where sno = " + k);
                            if(rs.next())
                                count = Integer.parseInt(rs.getString(1));
                        }
                        catch(SQLException exp){
                            System.out.println(exp);
                        }
                        if (count > 0) {
                            final int l = k;
                            JOptionPane.showMessageDialog(null,"Order Confirmed");
                            try
                            {
                                Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/products","root", "SL$12");
                                if(con != null)   System.out.println("Connection Successful");
                                System.out.println(l);
                                Statement st = con.createStatement();
                                int newCount = count - 1;
                                st.executeUpdate("update lotions set stockAvail = " + newCount + " where sno = " + l);
                            }
                            catch(SQLException exp){
                                System.out.println(exp);
                            }
                            
                        } else {
                            JOptionPane.showMessageDialog(null,"Order Not confirmed");
                        }
                    }
                });
    
                //Create a sub-panel for label, description, and button
                JPanel priceAndBuyPanel = new JPanel();
                priceAndBuyPanel.setLayout(new BoxLayout(priceAndBuyPanel, BoxLayout.Y_AXIS));
                priceAndBuyPanel.add(label,BorderLayout.NORTH);
                priceAndBuyPanel.add(priceLabel,BorderLayout.CENTER);
                priceAndBuyPanel.add(buyButton,BorderLayout.SOUTH);
                priceAndBuyPanel.setBackground(Color.white);
                // Create a panel for each group
                JPanel allDetailsPanel = new JPanel(new BorderLayout());
                allDetailsPanel.add(imageLabel, BorderLayout.WEST);
                allDetailsPanel.add(priceAndBuyPanel,BorderLayout.EAST);
                allDetailsPanel.add(brandLabel,BorderLayout.NORTH);
                allDetailsPanel.setBackground(Color.WHITE);
                allDetailsPanel.add(featuresArea,BorderLayout.CENTER);
    
                // Add the group panel to the main panel
                mainPanel.add(allDetailsPanel);

        }
        // Add the main panel to the content pane
        getContentPane().add(new JScrollPane(mainPanel));

        // Set the window to be visible
        setVisible(true);
        setResizable(false);   //restrict from resizing

    }
    public void actionPerformed(ActionEvent event){
        if(event.getSource() == backButton)
        {
            new CosmeticsAndJewellaryFrame();

        }
    }
}