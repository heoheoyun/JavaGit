package Report6;

import javax.swing.*;
import java.awt.*;

public class OC_12_10 extends JPanel {
    private Image image;

    public OC_12_10() {
        // 이미지 로드
        image = Toolkit.getDefaultToolkit().getImage("C:\\Users\\a9016\\git\\JavaGit\\ReportPackages\\src\\Report6\\apple.jpg");

        // 이미지가 완전히 로드될 때까지 대기
        MediaTracker tracker = new MediaTracker(this);
        tracker.addImage(image, 0);
        try {
            tracker.waitForAll();  // 이미지가 로드될 때까지 대기
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        if (image != null && image.getWidth(this) != -1) {
            // 패널 크기 가져오기
            int panelWidth = getWidth();
            int panelHeight = getHeight();

            // 이미지를 4등분으로 나누기
            int imageWidth = image.getWidth(this);
            int imageHeight = image.getHeight(this);
            int halfImageWidth = imageWidth / 2;
            int halfImageHeight = imageHeight / 2;

            // 각 섹션의 좌표 계산 (10픽셀 간격 포함)
            int leftX = 10;
            int rightX = panelWidth / 2 + 10;
            int topY = 10;
            int bottomY = panelHeight / 2 + 10;

            // 이미지를 4등분으로 그리기
            // 왼쪽 위
            g.drawImage(image, leftX, topY, leftX + (panelWidth / 2 - 10), topY + (panelHeight / 2 - 10), 0, 0, halfImageWidth, halfImageHeight, this);
            // 오른쪽 위
            g.drawImage(image, rightX, topY, rightX + (panelWidth / 2 - 10), topY + (panelHeight / 2 - 10), halfImageWidth, 0, imageWidth, halfImageHeight, this);
            // 왼쪽 아래
            g.drawImage(image, leftX, bottomY, leftX + (panelWidth / 2 - 10), bottomY + (panelHeight / 2 - 10), 0, halfImageHeight, halfImageWidth, imageHeight, this);
            // 오른쪽 아래
            g.drawImage(image, rightX, bottomY, rightX + (panelWidth / 2 - 10), bottomY + (panelHeight / 2 - 10), halfImageWidth, halfImageHeight, imageWidth, imageHeight, this);
        } else {
            // 이미지가 로드되지 않았을 경우 오류 메시지 출력
            g.drawString("Image failed to load.", 100, 100);
        }
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Image Panel Example");
        OC_12_10 panel = new OC_12_10();

        frame.add(panel);
        frame.setSize(800, 600);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }{}
}
