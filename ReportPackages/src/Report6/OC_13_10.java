package Report6;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

public class OC_13_10 extends JFrame {

    private static final String BUBBLE_IMAGE_PATH = "C:\\Users\\a9016\\git\\JavaGit\\ReportPackages\\src\\Report6\\Bubble.jpg";

    private JPanel contentPanel;
    private ArrayList<Bubble> bubbles;
    private Timer bubbleTimer;

    public OC_13_10() {
        setTitle("Bubble Animation");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        contentPanel = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                for (Bubble bubble : bubbles) {
                    bubble.draw(g);
                }
            }
        };
        
        contentPanel.setBackground(Color.WHITE);
        add(contentPanel);

        contentPanel.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                int x = e.getX();
                int y = e.getY();
                bubbles.add(new Bubble(x, y));
            }
        });

        bubbleTimer = new Timer(20, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                moveBubbles();
                repaint();
            }
        });

        bubbles = new ArrayList<>();
        bubbleTimer.start();
    }

    private void moveBubbles() {
        ArrayList<Bubble> toRemove = new ArrayList<>();
        for (Bubble bubble : bubbles) {
            bubble.move();
            if (bubble.getY() < 0) {
                toRemove.add(bubble);
            }
        }
        bubbles.removeAll(toRemove);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new OC_13_10().setVisible(true);
        });
    }

    class Bubble {
        private int x, y;
        private Image bubbleImage;

        public Bubble(int x, int y) {
            this.x = x;
            this.y = y;
            ImageIcon icon = new ImageIcon(BUBBLE_IMAGE_PATH);
            bubbleImage = icon.getImage().getScaledInstance(icon.getIconWidth() / 2, icon.getIconHeight() / 2, Image.SCALE_SMOOTH);
        }

        public void move() {
            y -= 5;
        }

        public int getY() {
            return y;
        }

        public void draw(Graphics g) {
            g.drawImage(bubbleImage, x - bubbleImage.getWidth(null) / 2, y - bubbleImage.getHeight(null) / 2, null);
        }
    }
}
