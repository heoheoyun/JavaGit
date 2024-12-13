package Report6;

import java.awt.Color;
import java.awt.Container;
import java.awt.GridLayout;

import javax.swing.JFrame;
import javax.swing.JLabel;

public class OC_09_05 extends JFrame {
    public OC_09_05() {
        setTitle("4x4 Color 프레임");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 400);
        setLocationRelativeTo(null);

        Container contentPane = getContentPane();
        contentPane.setLayout(new GridLayout(4, 4));

        Color[] colors = {
            Color.RED, Color.ORANGE, Color.YELLOW, Color.GREEN,
            Color.CYAN, Color.BLUE, Color.MAGENTA, Color.PINK,
            Color.LIGHT_GRAY, Color.GRAY, Color.DARK_GRAY, Color.BLACK,
            Color.WHITE, new Color(128, 0, 128),
            new Color(0, 128, 128), new Color(128, 128, 0)
        };

        for (Color color : colors) {
            JLabel label = new JLabel();
            label.setOpaque(true);
            label.setBackground(color);
            contentPane.add(label);
        }

        setVisible(true);
    }

    public static void main(String[] args) {
        new OC_09_05();
    }
}
