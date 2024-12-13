package Report6;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;

public class OC_14_01 {

    public static void main(String[] args) {
        JFrame frame = new JFrame("OC_14_01 메뉴 예시");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JMenuBar menuBar = new JMenuBar();

        JMenu fileMenu = new JMenu("파일");
        JMenu editMenu = new JMenu("편집");
        JMenu viewMenu = new JMenu("보기");
        JMenu inputMenu = new JMenu("입력");

        JMenuItem zoomItem = new JMenuItem("화면확대");
        JMenuItem pageLayoutItem = new JMenuItem("쪽윤관");

        viewMenu.add(zoomItem);
        viewMenu.add(pageLayoutItem);

        menuBar.add(fileMenu);
        menuBar.add(editMenu);
        menuBar.add(viewMenu);
        menuBar.add(inputMenu);

        frame.setJMenuBar(menuBar);

        zoomItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(frame, "화면을 확대합니다.");
            }
        });

        pageLayoutItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(frame, "쪽윤관 설정을 변경합니다.");
            }
        });

        frame.setSize(400, 300);
        frame.setVisible(true);
    }
}
