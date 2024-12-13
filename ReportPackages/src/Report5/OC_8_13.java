package Report5;

import java.io.File;
import java.util.Scanner;

public class OC_8_13 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        File currentDir = new File("c:\\");

        System.out.println("***** 파일 탐색기입니다. *****");

        while (true) {
            System.out.println("\t[" + currentDir.getAbsolutePath() + "]");
            File[] files = currentDir.listFiles();

            if (files != null) {
                for (File file : files) {
                    String type = file.isDirectory() ? "dir" : "file";
                    long size = file.length();
                    String name = file.getName();
                    System.out.printf("%-8s\t%-10d\t%s\n", type, size, name);
                }
            }

            System.out.print(">>");
            String command = scanner.nextLine();

            if (command.equals("그만")) {
                break;
            } else if (command.equals("..")) {
                File parentDir = currentDir.getParentFile();
                if (parentDir != null) {
                    currentDir = parentDir;
                } else {
                    System.out.println("상위 디렉터리가 없습니다.");
                }
            } else {
                File nextDir = new File(currentDir, command);
                if (nextDir.isDirectory()) {
                    currentDir = nextDir;
                } else {
                    System.out.println("유효하지 않은 디렉터리입니다.");
                }
            }
        }

        scanner.close();
    }
}
