package Report6;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Random;

public class OC_10_10 extends JFrame {
    private JPanel contentPane;
    private Random random = new Random();

    public OC_10_10() {
        setTitle("블록 생성 및 드래그 프로그램");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(600, 600);
        setLocationRelativeTo(null);

        contentPane = new JPanel();
        contentPane.setLayout(null);
        contentPane.setFocusable(true);
        contentPane.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyChar() == 'm') {
                    createBlock();
                }
            }
        });

        setContentPane(contentPane);
        setVisible(true);
    }

    private void createBlock() {
        JLabel block = new JLabel();
        block.setSize(80, 80);
        block.setOpaque(true);
        block.setBackground(new Color(random.nextInt(256), random.nextInt(256), random.nextInt(256)));
        block.setLocation(100, 100);

        MyMouseListener ml = new MyMouseListener();
        block.addMouseListener(ml);
        block.addMouseMotionListener(ml);

        contentPane.add(block);
        contentPane.repaint();
    }

    private class MyMouseListener extends MouseAdapter {
        private Point initialClick;
        private Point initialLocation;

        @Override
        public void mousePressed(MouseEvent e) {
            initialClick = e.getPoint();
            JLabel sourceLabel = (JLabel) e.getSource();
            initialLocation = sourceLabel.getLocation();
        }

        @Override
        public void mouseDragged(MouseEvent e) {
            JLabel sourceLabel = (JLabel) e.getSource();
            int deltaX = e.getX() - initialClick.x;
            int deltaY = e.getY() - initialClick.y;
            sourceLabel.setLocation(initialLocation.x + deltaX, initialLocation.y + deltaY);
        }
    }

    public static void main(String[] args) {
        new OC_10_10();
    }
}
