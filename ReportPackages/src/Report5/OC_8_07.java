package Report5;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class OC_8_07 {

    public static void main(String[] args) throws IOException {
        String sourcePath = "a.jpg";
        String destinationPath = "b.jpg";

        FileInputStream in = new FileInputStream(sourcePath);
        FileOutputStream out = new FileOutputStream(destinationPath);

        System.out.println(sourcePath + "를 " + destinationPath + "로 복사합니다.");
        System.out.println("10%마다 *를 출력합니다.");

        int totalBytes = in.available();
        int bytesCopied = 0;
        int progress = 0;

        int data;
        while ((data = in.read()) != -1) {
            out.write(data);
            bytesCopied++;

            int newProgress = (bytesCopied * 100) / totalBytes;
            if (newProgress >= progress + 10) {
                System.out.print("*");
                progress += 10;
            }
        }

        in.close();
        out.close();

        System.out.println("\n파일 복사가 완료되었습니다.");
    }
}
