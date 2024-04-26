
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

public class JeansAndHoddiesFrame extends JFrame implements ActionListener{
    JButton backButton;
    public JeansAndHoddiesFrame() {
        setTitle("CurioCart/Categories/Fashion/Jeans and Hoddies");
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

        JLabel jeansAndHoddiesLabel = new JLabel("Jeans and Hoddies");
        jeansAndHoddiesLabel.setFont(new Font(jeansAndHoddiesLabel.getFont().getFontName(),Font.BOLD,30));

        String[] images = {"Images/Fashion/Jeans/StretchableJeans.jpg",
                            "Images/Fashion/Jeans/FitJeans.jpg",
                            "Images/Fashion/Jeans/DenimJeans.jpg",
                            "Images/Fashion/Jeans/SlimFit.jpg",
                            "Images/Fashion/Jeans/ReguralJean.jpg",
                            "Images/Fashion/Jeans/LymioJeans.jpg"};
        String[] brands={"Stretchable Jeans",
                        "fit Jeans",
                        "Denim Jeans",
                        "Slim Fit",
                        "Regular Jean",
                        "Lymio Jean"};
        String[] prices = {"\n   624/-",
                            "\n   549/-",
                            "\n   799/-",
                            "\n   679/-",
                            "\n   550/-",
                            "\n 750/-"};
        String[] features={"Features:\n• Men's Slim Strtchable Jeans\n•  Material type	- Cotton Blend\n•  Style		- Modern\n•  Occasion type	- Casual",
                            "Features:\n•  Ben Martin Men's Fit Jeans\n•  Material type	- Cotton\n•  Style		- Modern\n•  Occasion type	- New Year, Birthday ",
                            "Features:\n•  Baggy Jeans for Men\n•  Material type	- Cotton\n•  Style		- Jeans\n•  Occasion type	- Anniversary,Party Use Jeans",
                            "Features:\n•  Kargeens Men's Jeans Pant Slim Fit\n• Material type	- Cotton Blend\n•  Style		- BoyFriend\n•  Occasion type	- Diwali, Wedding",
                            "Features:\n•  Dais Men's Regular Fit Jeans\n•  Material type	- Cotton\n •  Style		- Jeans\n•  Occasion type	- Casual",
                            "Features:\n•  Lymio Jeans for Men\n•  Material type	- Cotton\n•  Style		- Jeans\n•  Occasion type	- Party, Festivals"};
                            
                                                        
        JPanel backButtonAndBlankSpacePanel = new JPanel(new BorderLayout());
        backButtonAndBlankSpacePanel.add(backButton,BorderLayout.WEST);
        backButtonAndBlankSpacePanel.setBackground(Color.WHITE);
        JLabel blankSpaceLabel = new JLabel("icsudhjfoehlfoeh");
        blankSpaceLabel.setForeground(Color.WHITE);
        backButtonAndBlankSpacePanel.add(blankSpaceLabel,BorderLayout.CENTER);
        JPanel headerPanel = new JPanel(new BorderLayout());
        headerPanel.add(backButtonAndBlankSpacePanel,BorderLayout.WEST);
        headerPanel.setBackground(Color.WHITE);
        headerPanel.add(jeansAndHoddiesLabel,BorderLayout.CENTER);
        mainPanel.add(headerPanel);

        for (int i = 0; i < 6; i++) {
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
            new FashionsFrame();
        }
    }
}