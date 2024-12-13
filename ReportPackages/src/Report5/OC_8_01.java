package Report5;

import java.io.FileWriter;
import java.util.Scanner;

public class OC_8_01 {
    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        String filePath = "c:\\temp\\phone.txt";
        
        System.out.println("전화번호 입력 프로그램입니다.");

        FileWriter writer = new FileWriter(filePath);

        while (true) {
            System.out.print("이름 전화번호 >> ");
            String input = scanner.nextLine();
            
            if (input.equals("그만")) {
                break;
            }
            
            writer.write(input + "\n");
        }
        
        writer.close();
        System.out.println(filePath + "에 저장하였습니다.");
        
        scanner.close();
    }
}
