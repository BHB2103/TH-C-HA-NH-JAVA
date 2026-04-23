import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.plaf.basic.BasicScrollBarUI;

public class ShoeStoreUI extends JFrame {

    class Product {
        String name, price, desc, imagePath;
        Product(String name, String price, String desc, String imagePath) {
            this.name = name;
            this.price = price;
            this.desc = desc;
            this.imagePath = imagePath;
        }
    }

    private final Product[] products = {
        new Product("4DFWD PULSE SHOES", "$160.00", "This product is excluded from all promotional discounts and offers.", "img/img1.png"),
        new Product("FORUM MID SHOES", "$100.00", "This product is excluded from all promotional discounts and offers.", "img/img2.png"),
        new Product("SUPERNOVA SHOES", "$150.00", "NMD City Stock 2.", "img/img3.png"),
        new Product("Adidas", "$160.00", "NMD City Stock 2.", "img/img4.png"),
        new Product("Adidas", "$120.00", "NMD City Stock 2.", "img/img5.png"),
        new Product("4DFWD PULSE SHOES", "$160.00", "This product is excluded from all promotional discounts and offers.", "img/img6.png"),
        new Product("4DFWD PULSE SHOES", "$160.00", "This product is excluded from all promotional discounts and offers.", "img/img1.png"),
        new Product("FORUM MID SHOES", "$100.00", "This product is excluded from all promotional discounts and offers.", "img/img2.png"),
        new Product("SUPERNOVA SHOES", "$150.00", "NMD City Stock 2.", "img/img3.png"),
        new Product("Adidas", "$160.00", "NMD City Stock 2.", "img/img4.png"),
        new Product("Adidas", "$120.00", "NMD City Stock 2.", "img/img5.png"),
        new Product("4DFWD PULSE SHOES", "$160.00", "This product is excluded from all promotional discounts and offers.", "img/img6.png"),
        new Product("4DFWD PULSE SHOES", "$160.00", "This product is excluded from all promotional discounts and offers.", "img/img1.png"),
        new Product("FORUM MID SHOES", "$100.00", "This product is excluded from all promotional discounts and offers.", "img/img2.png"),
        new Product("SUPERNOVA SHOES", "$150.00", "NMD City Stock 2.", "img/img3.png"),
        new Product("Adidas", "$160.00", "NMD City Stock 2.", "img/img4.png"),
        new Product("Adidas", "$120.00", "NMD City Stock 2.", "img/img5.png"),
        new Product("4DFWD PULSE SHOES", "$160.00", "This product is excluded from all promotional discounts and offers.", "img/img6.png"),
        new Product("4DFWD PULSE SHOES", "$160.00", "This product is excluded from all promotional discounts and offers.", "img/img1.png"),
        new Product("FORUM MID SHOES", "$100.00", "This product is excluded from all promotional discounts and offers.", "img/img2.png"),
        new Product("SUPERNOVA SHOES", "$150.00", "NMD City Stock 2.", "img/img3.png"),
        new Product("Adidas", "$160.00", "NMD City Stock 2.", "img/img4.png"),
        new Product("Adidas", "$120.00", "NMD City Stock 2.", "img/img5.png"),
        new Product("4DFWD PULSE SHOES", "$160.00", "This product is excluded from all promotional discounts and offers.", "img/img6.png"),
        new Product("4DFWD PULSE SHOES", "$160.00", "This product is excluded from all promotional discounts and offers.", "img/img1.png"),
        new Product("FORUM MID SHOES", "$100.00", "This product is excluded from all promotional discounts and offers.", "img/img2.png"),
        new Product("SUPERNOVA SHOES", "$150.00", "NMD City Stock 2.", "img/img3.png"),
        new Product("Adidas", "$160.00", "NMD City Stock 2.", "img/img4.png"),
        new Product("Adidas", "$120.00", "NMD City Stock 2.", "img/img5.png"),
        new Product("4DFWD PULSE SHOES", "$160.00", "This product is excluded from all promotional discounts and offers.", "img/img6.png"),
        new Product("4DFWD PULSE SHOES", "$160.00", "This product is excluded from all promotional discounts and offers.", "img/img1.png"),
        new Product("FORUM MID SHOES", "$100.00", "This product is excluded from all promotional discounts and offers.", "img/img2.png"),
        new Product("SUPERNOVA SHOES", "$150.00", "NMD City Stock 2.", "img/img3.png"),
        new Product("Adidas", "$160.00", "NMD City Stock 2.", "img/img4.png"),
        new Product("Adidas", "$120.00", "NMD City Stock 2.", "img/img5.png"),
        new Product("4DFWD PULSE SHOES", "$160.00", "This product is excluded from all promotional discounts and offers.", "img/img6.png")
    };

    private JLabel mainImage, mainName, mainPrice, mainBrand, mainDesc;
    private RoundedPanel selectedCard = null;

    public ShoeStoreUI() {
        setTitle("Shoe Store");
        setSize(1200, 580);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel root = new JPanel(new BorderLayout(20, 20));
        root.setBorder(new EmptyBorder(20, 20, 20, 5));
        root.setBackground(Color.WHITE);

        // ================= LEFT PANEL =================
        JPanel leftPanel = new RoundedPanel(20);
        leftPanel.setLayout(new BorderLayout(0, 15));
        leftPanel.setPreferredSize(new Dimension(300, 0));
        leftPanel.setBackground(Color.WHITE);
        leftPanel.setBorder(new EmptyBorder(0, 20, 20, 20));

        mainImage = new JLabel();
        mainImage.setHorizontalAlignment(SwingConstants.CENTER);
        mainImage.setBorder(new EmptyBorder(0, 0, 0, 0));

        JPanel infoPanel = new JPanel();
        infoPanel.setLayout(new BoxLayout(infoPanel, BoxLayout.Y_AXIS));
        infoPanel.setOpaque(false);

        JSeparator line = new JSeparator();
        line.setMaximumSize(new Dimension(Integer.MAX_VALUE, 2));
        line.setAlignmentX(Component.LEFT_ALIGNMENT);

        mainName = new JLabel();
        mainName.setFont(new Font("Arial", Font.BOLD, 18));
        mainName.setAlignmentX(Component.LEFT_ALIGNMENT);

        mainPrice = new JLabel();
        mainPrice.setFont(new Font("Arial", Font.BOLD, 17));
        mainPrice.setAlignmentX(Component.LEFT_ALIGNMENT);

        mainBrand = new JLabel("Adidas");
        mainBrand.setFont(new Font("Arial", Font.PLAIN, 13));
        mainBrand.setAlignmentX(Component.LEFT_ALIGNMENT);

        mainDesc = new JLabel();
        mainDesc.setFont(new Font("Arial", Font.PLAIN, 17));
        mainDesc.setForeground(Color.GRAY);
        mainDesc.setAlignmentX(Component.LEFT_ALIGNMENT);

        infoPanel.add(line);
        infoPanel.add(Box.createVerticalStrut(15));
        infoPanel.add(mainName);
        infoPanel.add(Box.createVerticalStrut(10));
        infoPanel.add(mainPrice);
        infoPanel.add(Box.createVerticalStrut(5));
        infoPanel.add(mainBrand);
        infoPanel.add(Box.createVerticalStrut(10));
        infoPanel.add(mainDesc);

        leftPanel.add(mainImage, BorderLayout.NORTH);
        leftPanel.add(infoPanel, BorderLayout.CENTER);

        // ================= GRID PANEL =================
        JPanel grid = new JPanel(new GridLayout(0, 4, 15, 15));
        grid.setBackground(Color.WHITE);

        for (Product p : products) {
            grid.add(createProductCard(p));
        }

        JPanel gridWrapper = new JPanel(new BorderLayout());
        gridWrapper.setBackground(Color.WHITE);
        gridWrapper.setBorder(new EmptyBorder(0, 0, 0, 20));
        gridWrapper.add(grid, BorderLayout.NORTH);

        JScrollPane scrollPane = new JScrollPane(gridWrapper);
        scrollPane.setBorder(null);
        scrollPane.getViewport().setBackground(Color.WHITE);
        scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        scrollPane.getVerticalScrollBar().setUI(new ModernScrollBarUI());
        scrollPane.getVerticalScrollBar().setPreferredSize(new Dimension(5, 0));
        scrollPane.getVerticalScrollBar().setUnitIncrement(25);

        updateMainProduct(products[0]);

        SwingUtilities.invokeLater(() -> {
            Component first = grid.getComponent(0);
            if (first instanceof RoundedPanel card) {
                card.setBorderColor(new Color(0, 120, 255));
                selectedCard = card;
            }
        });

        root.add(leftPanel, BorderLayout.WEST);
        root.add(scrollPane, BorderLayout.CENTER);

        add(root);
        setVisible(true);
    }

    private RoundedPanel createProductCard(Product product) {
        RoundedPanel card = new RoundedPanel(20);
        card.setLayout(new BorderLayout(0, 12));
        card.setBackground(new Color(243, 243, 243));
        card.setBorderColor(new Color(243, 243, 243));
        card.setBorder(new EmptyBorder(15, 15, 15, 15));
        card.setPreferredSize(new Dimension(0, 240));

        JPanel textPanel = new JPanel();
        textPanel.setLayout(new BoxLayout(textPanel, BoxLayout.Y_AXIS));
        textPanel.setOpaque(false);

        JLabel name = new JLabel(product.name);
        name.setFont(new Font("Arial", Font.BOLD, 18));
        name.setAlignmentX(Component.LEFT_ALIGNMENT);

        String shortDesc = product.desc.length() > 35
                ? product.desc.substring(0, 35) + "..."
                : product.desc;

        JLabel desc = new JLabel(shortDesc);
        desc.setFont(new Font("Arial", Font.PLAIN, 17));
        desc.setForeground(Color.GRAY);
        desc.setAlignmentX(Component.LEFT_ALIGNMENT);

        textPanel.add(name);
        textPanel.add(Box.createVerticalStrut(6));
        textPanel.add(desc);

        JLabel image = new JLabel();
        image.setHorizontalAlignment(SwingConstants.CENTER);

        ImageIcon icon = new ImageIcon(product.imagePath);
        Image scaled = icon.getImage().getScaledInstance(150, 150, Image.SCALE_SMOOTH);
        image.setIcon(new ImageIcon(scaled));

        JPanel bottomRow = new JPanel(new BorderLayout());
        bottomRow.setOpaque(false);

        JLabel brand = new JLabel("Adidas");
        brand.setFont(new Font("Arial", Font.PLAIN, 13));

        JLabel price = new JLabel(product.price);
        price.setFont(new Font("Arial", Font.BOLD, 17));

        bottomRow.add(brand, BorderLayout.WEST);
        bottomRow.add(price, BorderLayout.EAST);

        card.add(textPanel, BorderLayout.NORTH);
        card.add(image, BorderLayout.CENTER);
        card.add(bottomRow, BorderLayout.SOUTH);

        card.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                if (selectedCard != null) {
                    selectedCard.setBorderColor(new Color(243, 243, 243));
                }

                card.setBorderColor(new Color(0, 120, 255));
                selectedCard = card;

                updateMainProduct(product);
            }

            public void mouseEntered(MouseEvent e) {
                if (card != selectedCard) {
                    card.setBackground(new Color(230, 230, 230));
                }
            }

            public void mouseExited(MouseEvent e) {
                if (card != selectedCard) {
                    card.setBackground(new Color(243, 243, 243));
                }
            }
        });

        return card;
    }

    private void updateMainProduct(Product product) {
        ImageIcon icon = new ImageIcon(product.imagePath);
        Image scaled = icon.getImage().getScaledInstance(250, 250, Image.SCALE_SMOOTH);
        mainImage.setIcon(new ImageIcon(scaled));

        mainName.setText(product.name);
        mainPrice.setText(product.price);
        mainBrand.setText("Adidas");
        mainDesc.setText("<html>" + product.desc + "</html>");
    }

    class RoundedPanel extends JPanel {
        private int radius;
        private Color borderColor = null;

        RoundedPanel(int radius) {
            this.radius = radius;
            setOpaque(false);
        }

        public void setBorderColor(Color color) {
            this.borderColor = color;
            repaint();
        }

        protected void paintComponent(Graphics g) {
            Graphics2D g2 = (Graphics2D) g.create();
            g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
                    RenderingHints.VALUE_ANTIALIAS_ON);

            g2.setColor(getBackground());
            g2.fillRoundRect(0, 0, getWidth(), getHeight(), radius, radius);

            if (borderColor != null) {
                g2.setColor(borderColor);
                g2.setStroke(new BasicStroke(2));
                g2.drawRoundRect(1, 1, getWidth() - 3, getHeight() - 3, radius, radius);
            }

            g2.dispose();
            super.paintComponent(g);
        }
    }

    class ModernScrollBarUI extends BasicScrollBarUI {
        protected void configureScrollBarColors() {
            thumbColor = new Color(200, 200, 200);
        }

        protected JButton createDecreaseButton(int orientation) {
            return createZeroButton();
        }

        protected JButton createIncreaseButton(int orientation) {
            return createZeroButton();
        }

        private JButton createZeroButton() {
            JButton button = new JButton();
            button.setPreferredSize(new Dimension(0, 0));
            return button;
        }

        protected void paintThumb(Graphics g, JComponent c, Rectangle r) {
            Graphics2D g2 = (Graphics2D) g.create();
            g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
                    RenderingHints.VALUE_ANTIALIAS_ON);
            g2.setColor(thumbColor);
            g2.fillRoundRect(r.x + 1, r.y, r.width - 2, r.height, 8, 8);
            g2.dispose();
        }

        protected void paintTrack(Graphics g, JComponent c, Rectangle r) {
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(ShoeStoreUI::new);
    }
}