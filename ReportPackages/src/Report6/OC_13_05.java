package Report6;

import java.util.Calendar;
import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;

public class OC_13_05 {
    public static void main(String[] args) {
        JFrame frame = new JFrame("디지털 시계");
        JLabel timeLabel = new JLabel("", JLabel.CENTER);
        timeLabel.setFont(new Font("Arial", Font.BOLD, 30));
        frame.add(timeLabel);
        frame.setSize(400, 150);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);

        Thread clockThread = new Thread(new Runnable() {
            @Override
            public void run() {
                while (true) {
                    Calendar now = Calendar.getInstance();
                    String timeText = String.format("%02d:%02d:%02d",
                            now.get(Calendar.HOUR_OF_DAY),
                            now.get(Calendar.MINUTE),
                            now.get(Calendar.SECOND));
                    timeLabel.setText(timeText);

                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        break;
                    }
                }
            }
        });

        clockThread.start();
    }
}
