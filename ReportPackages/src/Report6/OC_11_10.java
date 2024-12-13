package Report6;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;

public class OC_11_10 extends JFrame {
    private ArrayList<String> words;
    private ArrayList<JLabel> wordLabels;
    private StringBuilder currentSentence;
    private int wordIndex;
    private JLabel sentenceLabel;
    private String targetSentence;

    public OC_11_10() {
        setTitle("문장 완성 게임");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(600, 400);
        setLocationRelativeTo(null);
        setLayout(null);

        initializeGame();
        setVisible(true);
    }

    private void initializeGame() {
        JButton newTextButton = new JButton("New Text");
        newTextButton.setBounds(250, 20, 100, 30);
        newTextButton.addActionListener(e -> startNewGame());
        add(newTextButton);

        sentenceLabel = new JLabel("완성된 문장:");
        sentenceLabel.setBounds(50, 300, 500, 30);
        sentenceLabel.setFont(new Font("맑은 고딕", Font.PLAIN, 14));
        sentenceLabel.setHorizontalAlignment(SwingConstants.CENTER);
        add(sentenceLabel);

        wordLabels = new ArrayList<>();
    }

    private void startNewGame() {
        resetGame();

        String[] sentences = {
            "You are the dancing queen",
            "I am the walrus",
            "Hello world this is java",
            "Java is fun to learn",
            "Programming is awesome",
            "Swing GUI is great"
        };

        targetSentence = sentences[new Random().nextInt(sentences.length)];
        words = new ArrayList<>(Arrays.asList(targetSentence.split(" ")));
        Collections.shuffle(words);

        for (String word : words) {
            JLabel wordLabel = createWordLabel(word);
            wordLabels.add(wordLabel);
            add(wordLabel);
        }

        revalidate();
        repaint();
    }

    private void resetGame() {
        if (!wordLabels.isEmpty()) {
            for (JLabel label : wordLabels) {
                remove(label);
            }
        }
        wordLabels.clear();
        currentSentence = new StringBuilder();
        wordIndex = 0;
        sentenceLabel.setText("완성된 문장:");
    }

    private JLabel createWordLabel(String word) {
        JLabel wordLabel = new JLabel(word);
        wordLabel.setFont(new Font("맑은 고딕", Font.PLAIN, 20));
        wordLabel.setHorizontalAlignment(SwingConstants.CENTER);

        Random random = new Random();
        int x = random.nextInt(500); // 화면 크기 내에서 랜덤 위치 지정
        int y = random.nextInt(200) + 50;
        wordLabel.setBounds(x, y, word.length() * 12 + 20, 30);

        wordLabel.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                handleWordClick(wordLabel);
            }
        });

        return wordLabel;
    }

    private void handleWordClick(JLabel clickedLabel) {
        String clickedWord = clickedLabel.getText();
        if (clickedWord.equals(words.get(wordIndex))) {
            clickedLabel.setForeground(Color.GRAY); // 클릭된 단어는 회색으로 표시
            clickedLabel.removeMouseListener(clickedLabel.getMouseListeners()[0]); // 추가 클릭 방지

            currentSentence.append(clickedWord).append(" ");
            sentenceLabel.setText("완성된 문장: " + currentSentence.toString().trim());
            wordIndex++;

            if (wordIndex == words.size()) {
                sentenceLabel.setText("완성된 문장: " + currentSentence.toString().trim() + " >> 성공!");
            }
        }
    }

    public static void main(String[] args) {
        new OC_11_10();
    }
}
