package Report5;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class OC_8_02 {
    public static void main(String[] args) throws FileNotFoundException {
        String filePath = "c:\\temp\\phone.txt";
        System.out.print(filePath + "를 출력합니다.\n");

        File file = new File(filePath);
        Scanner fileScanner = new Scanner(file);

        while (fileScanner.hasNextLine()) {
            String line = fileScanner.nextLine();
            System.out.println(line);
        }

        fileScanner.close();
    }
}
