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

public class MobilesFrame extends JFrame implements ActionListener{
    JButton backButton;
    protected int l;
    public MobilesFrame() {
        
        setTitle("CurioCart/Categories/Electronics/Mobiles");
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

        JLabel mobilesLabel = new JLabel("Mobiles");
        mobilesLabel.setFont(new Font(mobilesLabel.getFont().getFontName(),Font.BOLD,30));

        String[] images = {"Images/Electronics/Mobiles/VivoT2X5G.jpg",
                           "Images/Electronics/Mobiles/Nothingphone.jpg",
                            "Images/Electronics/Mobiles/AppleiPhone15.jpg",
                            "Images/Electronics/Mobiles/Redminote13pro5G.jpg",
                            "Images/Electronics/Mobiles/PocoX6Neo5G.jpg"};
        String[] brands = {"ViVo T2X 5G ",
                           "Nothing phone(5G)",
                           "Apple iPhone 15",
                           "REDMI Note 13 Pro 5G ",
                           "POCO X6 Neo 5G"};
        String[] prices = {"\n   12,999/-",
                            "\n   23,999/-",
                            "\n   72,999/-",
                            "\n   25,999/-",
                            "\n   15,999/-"};
        //String[] prices = {"Price :\n   12,999/-","Price :\n   23,999/-","Price :\n   72,999/-","Price :\n   25,999/-","Price :\n   15,999/-"};
        String[] features = {"Features:\n•  6 GB RAM | 128 GB ROM\n•  16.71 cm (6.58 inch) Full HD+ Display\n•  50MP + 2MP | 8MP Front Camera\n•  5000 mAh Battery\n•  Mediatek Dimensity 6020",
                 "Features:\n•  8 GB RAM | 128 GB ROM\n•  17.02 cm (6.7 inch) Full HD+ Display\n•  50MP (OIS) + 50MP | 32MP Front Camera\n•  5000 mAh Battery\n•  Dimensity 7200 Pro Processor",
                 "Features:\n•  128 GB ROM•  15.49 cm (6.1 inch) Super Retina XDR Display\n•  48MP + 12MP | 12MP Front Camera\n•  A16 Bionic Chip, 6 Core Processor Processor\n•  Dimensity 7200 Pro Processor",
                 "Features:\n•  8 GB RAM | 128 GB ROM\n•  16.94 cm (6.67 inch) Display\n•  200MP (OIS) + 8MP + 2MP | 16MP Front Camera\n•  5100 mAh Battery\n•  7s Gen 2 Mobile Platform 5G Processor",
                 "Features:\n•  8 GB RAM | 128 GB ROM | Expandable Upto 1 TB\n•  16.94 cm (6.67 inch) Full HD+ Display\n•  108MP + 2MP | 16MP Front Camera\n•  5000 mAh Battery\n•  Dimensity 6080 Processor"};
        JPanel backButtonAndBlankSpacePanel = new JPanel(new BorderLayout());
        backButtonAndBlankSpacePanel.add(backButton,BorderLayout.WEST);
        backButtonAndBlankSpacePanel.setBackground(Color.WHITE);
        JLabel blankSpaceLabel = new JLabel("icsudhjfoehlfoehldfivcodj");
        blankSpaceLabel.setForeground(Color.WHITE);
        backButtonAndBlankSpacePanel.add(blankSpaceLabel,BorderLayout.CENTER);
        JPanel headerPanel = new JPanel(new BorderLayout());
        headerPanel.add(backButtonAndBlankSpacePanel,BorderLayout.WEST);
        headerPanel.setBackground(Color.WHITE);
        headerPanel.add(mobilesLabel,BorderLayout.CENTER);
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
                            ResultSet rs = st.executeQuery("select stockAvail from mobiles where sno = " + k);
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
                                st.executeUpdate("update mobiles set stockAvail = " + newCount + " where sno = " + l);
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