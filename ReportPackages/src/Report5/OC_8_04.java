package Report5;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class OC_8_04 {
    public static void main(String[] args) throws FileNotFoundException {
        String filePath = "c:\\windows\\system.imi";

        File file = new File(filePath);
        Scanner fileScanner = new Scanner(file);

        int lineNumber = 1;
        while (fileScanner.hasNextLine()) {
            String line = fileScanner.nextLine();
            System.out.printf("%4d: %s\n", lineNumber, line);
            lineNumber++;
        }

        fileScanner.close();
    }
}

