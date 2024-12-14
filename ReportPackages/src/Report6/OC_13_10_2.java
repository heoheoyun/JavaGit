package Report6;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Vector;

public class OC_13_10_2 extends JFrame {

    private static final String BUBBLE_IMAGE_PATH = "C:\\Users\\a9016\\git\\JavaGit\\ReportPackages\\src\\Report6\\Bubble.jpg";

    private JPanel contentPanel;
    private Vector<Bubble> bubbles;
    private Timer bubbleTimer;
    private boolean isPaused;

    public OC_13_10_2() {
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
                if (!isPaused) {
                    moveBubbles();
                    repaint();
                }
            }
        });

        bubbles = new Vector<>();
        isPaused = false;  // 초기에는 멈추지 않음
        bubbleTimer.start();

        addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_S) {
                    isPaused = true;  // s키가 눌리면 멈춤
                } else if (e.getKeyCode() == KeyEvent.VK_R) {
                    isPaused = false;  // r키가 눌리면 다시 시작
                }
            }
        });

        setFocusable(true);
    }

    private void moveBubbles() {
        Vector<Bubble> toRemove = new Vector<>();
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
            new OC_13_10_2().setVisible(true);
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
