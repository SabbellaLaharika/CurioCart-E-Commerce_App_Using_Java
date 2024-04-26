
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

public class FansFrame extends JFrame implements ActionListener{
    JButton backButton;
    public FansFrame() {
        setTitle("CurioCart/Categories/Electronics/Fans");
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

        JLabel fansLabel = new JLabel("Fans");
        fansLabel.setFont(new Font(fansLabel.getFont().getFontName(),Font.BOLD,30));

        String[] images = {"Images/Electronics/Fans/BajajFrore1200mm.jpg",
                            "Images/Electronics/Fans/OrientElectricZeno.jpg",
                            "Images/Electronics/Fans/PolycabOptimaMimni.jpg",
                            "Images/Electronics/Fans/CandesBrioTurbo.jpg",
                            "Images/Electronics/Fans/AmazonBasicsHighSpeed.jpg"};
                            String[] brands = {"Bajaj Frore 1200 mm  ",
                            "Orient Electric Zeno 1200mm ",
                            "Polycab Optima Mini 400 mm  ",
                            "Candes Brio Turbo 600 mm ",
                            "AmazonBasics High Speed Table Fan"};
         String[] prices = {"\n   1,379/-",
                             "\n   2,949/-",
                             "\n   2,550/-",
                             "\n   1,243/-",
                             "\n   1,999/-"};
        String[] features = {"Features:\n• Bajaj Frore 1200 mm (48\") stars Rated Ceiling Fans for Home\n• BEE 1 star Rated Energy Efficient Ceiling Fan\n• Rust Free Coating for Long Life\n• High Air Delivery,2-Yr Warranty White\n",       
                            "Features:\n• Orient Electric Zeno 1200mm BLDC Ceiling Fan with Remote\n• BEE 5-star rated Energy Saving Fan\n• 3-year warranty by Orient,White\n",
                             "Features:\n• Polycab Optima Mini 400 mm Pedestal Fan with Superior Air Delivery\n• 100% Copper Motor and 2 years warranty (Blue)",
                             "Features:\n• Candes Brio Turbo 600 mm\n• 24 Inch High Speed 4 Blade Anti-Dust Ceiling Fan\n•  Suitable for Kitchen/Veranda/Balcony/Small Room\n",
                             "Features:\n•AmazonBasics High Speed Table Fan\n• for Cooling with Automatic Oscillation (400 mm, 55W, White)\n" };

        JPanel backButtonAndBlankSpacePanel = new JPanel(new BorderLayout());
        backButtonAndBlankSpacePanel.add(backButton,BorderLayout.WEST);
        backButtonAndBlankSpacePanel.setBackground(Color.WHITE);
        JLabel blankSpaceLabel = new JLabel("icsudhjfoehlfoehldfivcodj");
        blankSpaceLabel.setForeground(Color.WHITE);
        backButtonAndBlankSpacePanel.add(blankSpaceLabel,BorderLayout.CENTER);
        JPanel headerPanel = new JPanel(new BorderLayout());
        headerPanel.add(backButtonAndBlankSpacePanel,BorderLayout.WEST);
        headerPanel.setBackground(Color.WHITE);
        headerPanel.add(fansLabel,BorderLayout.CENTER);
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
                buyButton.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        JOptionPane.showMessageDialog(null, "Order Confirmed");
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