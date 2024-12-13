package Report5;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class OC_8_03 {
    public static void main(String[] args) throws FileNotFoundException {
        String filePath = "c:\\windows\\system.imi";

        File file = new File(filePath);
        Scanner fileScanner = new Scanner(file);

        while (fileScanner.hasNextLine()) {
            String line = fileScanner.nextLine();
            System.out.println(line.toUpperCase());
        }

        fileScanner.close();
    }
}
