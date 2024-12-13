package Report6;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class OC_09_10 extends JFrame {
    private JPanel centerPanel;
    private JLabel[] numberLabels;
    private Random random = new Random();

    public OC_09_10() {
        setTitle("West Grid 프레임");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 400);
        setLocationRelativeTo(null);

        Container contentPane = getContentPane();
        contentPane.setLayout(new BorderLayout());

        JPanel westPanel = new JPanel(new GridLayout(10, 1));
        Color[] buttonColors = {
            Color.RED, Color.ORANGE, Color.YELLOW, Color.GREEN,
            Color.CYAN, Color.BLUE, Color.MAGENTA, Color.PINK,
            Color.LIGHT_GRAY, Color.DARK_GRAY
        };

        for (Color color : buttonColors) {
            JButton button = new JButton();
            button.setBackground(color);
            button.setOpaque(true);
            button.setBorderPainted(false);
            button.addActionListener(new ColorButtonListener(color));
            westPanel.add(button);
        }
        contentPane.add(westPanel, BorderLayout.WEST);

        centerPanel = new JPanel(null);
        numberLabels = new JLabel[10];
        for (int i = 0; i < 10; i++) {
            JLabel label = new JLabel(String.valueOf(i));
            label.setFont(new Font("Arial", Font.BOLD, 14));
            label.setSize(20, 20);
            centerPanel.add(label);
            numberLabels[i] = label;
        }
        randomizeLabels(Color.BLACK);
        contentPane.add(centerPanel, BorderLayout.CENTER);

        setVisible(true);
    }

    private void randomizeLabels(Color color) {
        for (JLabel label : numberLabels) {
            int x = 50 + random.nextInt(151);
            int y = 50 + random.nextInt(151);
            label.setLocation(x, y);
            label.setForeground(color);
        }
    }

    private class ColorButtonListener implements ActionListener {
        private Color color;

        public ColorButtonListener(Color color) {
            this.color = color;
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            randomizeLabels(color);
        }
    }

    public static void main(String[] args) {
        new OC_09_10();
    }
}
