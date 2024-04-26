
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

public class LaptopsFrame extends JFrame implements ActionListener{
    JButton backButton;
    public LaptopsFrame() {
        setTitle("CurioCart/Categories/Electronics/Laptops");
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

        JLabel laptopsLabel = new JLabel("Laptops");
        laptopsLabel.setFont(new Font(laptopsLabel.getFont().getFontName(),Font.BOLD,30));

        String[] images = {"Images/Electronics/Laptops/HP15sIntelCorei3.jpg",
                            "Images/Electronics/Laptops/SAMSUNGGalaxy.jpg",
                            "Images/Electronics/Laptops/ASUSVivobook.jpg",
                            "Images/Electronics/Laptops/AcerAspireLite.jpg",
                            "Images/Electronics/Laptops/HPPavilionIntelCorei5.jpg"};
        String[] brands = {"HP 15s Intel Core i3",
                            "SAMSUNG Galaxy Book 2",
                            "ASUS Vivobook 15 ",
                            "Acer Aspire Lite",
                            "HP Pavilion Intel Core i5"};
        
        String[] prices = {"\n   37,290/-",
                        "\n   46,990/-",
                        "\n   37,990/-",
                        "\n   34,990/-",
                        "\n   72,490/-"};

        String[] features = {"Features:\n•  Intel Core i3 Processor (12th Gen)\n•  8 GB DDR4 RAM\n•  64 bit Windows 11 Operating System\n•  512 GB SSD\n•  39.62 cm (15.6 Inch) Display\n•  Microsoft Office Home & Student 2021\n•  1 Year Onsite Warranty",
                 "Features\n•  Intel Core i5 Processor (12th Gen)\n•  8 GB DDR4 RAM\n•  Windows 11 Operating System\n•  512 GB SSD\n•  39.62 cm (15.6 Inch) Display\n•  1 Year Onsite Warranty", 
                 "Features:\n•  Intel Core i3 Processor (12th Gen)\n•  8 GB DDR4 RAM\n•  Windows 11 Operating System\n•  512 GB SSD\n•  39.62 cm (15.6 Inch) Display",
                 "Features:\n•  AMD Ryzen 5 Hexa Core Processor\n•  8 GB DDR4 RAM\n•  Windows 11 Operating System\n•  512 GB SSD\n•  39.62 cm (15.6 inch) Display",
                 "Features:\n•  intel Core i5 Processor (13th Gen)\n•  16 GB DDR4 RAM\n•  Windows 11 Operating System\n•  1 TB SSD\n•  39.62 cm (15.6 Inch) Display"};

        //String[] prices = {"Price :\n   12,999/-","Price :\n   23,999/-","Price :\n   72,999/-","Price :\n   25,999/-","Price :\n   15,999/-"};
        JPanel backButtonAndBlankSpacePanel = new JPanel(new BorderLayout());
        backButtonAndBlankSpacePanel.add(backButton,BorderLayout.WEST);
        backButtonAndBlankSpacePanel.setBackground(Color.WHITE);
        JLabel blankSpaceLabel = new JLabel("icsudhjfoehlfoehldfivcodj");
        blankSpaceLabel.setForeground(Color.WHITE);
        backButtonAndBlankSpacePanel.add(blankSpaceLabel,BorderLayout.CENTER);
        JPanel headerPanel = new JPanel(new BorderLayout());
        headerPanel.add(backButtonAndBlankSpacePanel,BorderLayout.WEST);
        headerPanel.setBackground(Color.WHITE);
        headerPanel.add(laptopsLabel,BorderLayout.CENTER);
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
                            ResultSet rs = st.executeQuery("select stockAvail from laptops where sno = " + k);
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
                                st.executeUpdate("update laptops set stockAvail = " + newCount + " where sno = " + l);
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
            new ElectronicsFrame();
        }
    }
}

