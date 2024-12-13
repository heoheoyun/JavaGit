package Report6;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Random;

public class OC_10_05 extends JFrame {
    private JLabel label;
    private Random random = new Random();

    public OC_10_05() {
        setTitle("클릭 연습 프로그램");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 400);
        setLocationRelativeTo(null);

        Container contentPane = getContentPane();
        contentPane.setLayout(null);

        label = new JLabel("C");
        label.setFont(new Font("Arial", Font.BOLD, 20));
        label.setSize(20, 20);
        label.setLocation(100, 100);
        label.addMouseListener(new LabelClickListener());
        contentPane.add(label);

        setVisible(true);
    }

    private class LabelClickListener extends MouseAdapter {
        @Override
        public void mouseClicked(MouseEvent e) {
            int x = random.nextInt(361);
            int y = random.nextInt(361);
            label.setLocation(x, y);
        }
    }

    public static void main(String[] args) {
        new OC_10_05();
    }
}
