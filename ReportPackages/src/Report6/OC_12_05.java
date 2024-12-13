package Report6;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.*;
import java.io.*;
import javax.imageio.ImageIO;

public class OC_12_05 extends JFrame {
    private ImagePanel imagePanel;

    public OC_12_05() {
        setTitle("Image Zoom");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        imagePanel = new ImagePanel("C:\\Users\\a9016\\git\\JavaGit\\ReportPackages\\src\\Report6\\apple.jpg");
        add(imagePanel);

        // Key listener for zoom
        addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                int keyCode = e.getKeyCode();
                if (keyCode == KeyEvent.VK_PLUS || keyCode == KeyEvent.VK_ADD) {
                    imagePanel.zoom(1.1); // 10% zoom in
                } else if (keyCode == KeyEvent.VK_MINUS || keyCode == KeyEvent.VK_SUBTRACT) {
                    imagePanel.zoom(0.9); // 10% zoom out
                }
            }
        });

        setSize(500, 500);
        setLocationRelativeTo(null); // Center the frame
        setVisible(true);
        setFocusable(true);
    }

    public static void main(String[] args) {
        new OC_12_05();
    }
}

class ImagePanel extends JPanel {
    private BufferedImage image;
    private double scale;

    public ImagePanel(String imagePath) {
        scale = 1.0; // Default scale is 100%
        try {
            image = ImageIO.read(new File(imagePath));
        } catch (IOException e) {
            System.out.println("Image not found: " + imagePath);
        }
    }

    public void zoom(double scaleFactor) {
        scale *= scaleFactor;
        repaint();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        if (image != null) {
            Graphics2D g2d = (Graphics2D) g;
            int x = 10, y = 10; // Image draw position
            int width = (int) (image.getWidth() * scale);
            int height = (int) (image.getHeight() * scale);
            g2d.drawImage(image, x, y, width, height, this);
        }
    }
}
