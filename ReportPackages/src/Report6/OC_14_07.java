package Report6;

import javax.swing.*;
import java.awt.event.*;
import javax.sound.sampled.*;
import java.io.File;
import java.io.IOException;

public class OC_14_07 {
    private static Clip audioClip;

    public static void main(String[] args) {
        JFrame frame = new JFrame("오디오 프로그램");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 200);

        JMenuBar menuBar = new JMenuBar();
        JMenu audioMenu = new JMenu("오디오");

        JMenuItem playItem = new JMenuItem("연주");
        playItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFileChooser fileChooser = new JFileChooser();
                fileChooser.setDialogTitle("오디오 파일 선택");
                fileChooser.setFileFilter(new javax.swing.filechooser.FileNameExtensionFilter("WAV 파일", "wav"));

                if (fileChooser.showOpenDialog(frame) == JFileChooser.APPROVE_OPTION) {
                    File audioFile = fileChooser.getSelectedFile();
                    playAudio(audioFile);
                }
            }
        });

        JMenuItem stopItem = new JMenuItem("종료");
        stopItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                stopAudio();
            }
        });

        audioMenu.add(playItem);
        audioMenu.add(stopItem);
        menuBar.add(audioMenu);
        frame.setJMenuBar(menuBar);

        frame.setVisible(true);
    }

    private static void playAudio(File audioFile) {
        try {
            AudioInputStream audioStream = AudioSystem.getAudioInputStream(audioFile);
            audioClip = AudioSystem.getClip();
            audioClip.open(audioStream);
            audioClip.start();
        } catch (UnsupportedAudioFileException | IOException | LineUnavailableException e) {
            JOptionPane.showMessageDialog(null, "오디오 파일을 연주하는데 문제가 발생했습니다.", "오류", JOptionPane.ERROR_MESSAGE);
        }
    }

    private static void stopAudio() {
        if (audioClip != null && audioClip.isRunning()) {
            audioClip.stop();
        }
    }
}
