package Report6;

import javax.swing.*;
import java.awt.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class OC_11_05 extends JFrame {

    private JLabel label;
    private JSlider slider;

    public OC_11_05() {
        setTitle("슬라이더와 레이블 예제");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(300, 150);
        setLocationRelativeTo(null);

        JPanel panel = new JPanel();
        panel.setLayout(new FlowLayout());

        slider = new JSlider(100, 200);
        slider.setMajorTickSpacing(20);
        slider.setMinorTickSpacing(5);
        slider.setPaintTicks(true);
        slider.setPaintLabels(true);
        slider.setValue(100);

        label = new JLabel("100");

        slider.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                label.setText(String.valueOf(slider.getValue()));
            }
        });

        panel.add(slider);
        panel.add(label);

        add(panel);

        setVisible(true);
    }

    public static void main(String[] args) {
        new OC_11_05();
    }
}
