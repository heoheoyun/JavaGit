package Report5;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Scanner;

public class OC_8_10 {
    public static void main(String[] args) throws IOException {
        HashMap<String, String> phoneBook = new HashMap<>();
        String filePath = "c:\\temp\\phone.txt";
        BufferedReader reader = new BufferedReader(new FileReader(filePath));

        String line;
        int count = 0;

        while ((line = reader.readLine()) != null) {
            String[] parts = line.split(" ");
            if (parts.length == 2) {
                phoneBook.put(parts[0], parts[1]);
                count++;
            }
        }

        reader.close();
        System.out.println("총 " + count + "개의 전화번호를 읽었습니다.");

        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.print("이름>> ");
            String name = scanner.nextLine();
            if (name.equals("그만")) break;

            String phoneNumber = phoneBook.get(name);
            if (phoneNumber != null) {
                System.out.println(phoneNumber);
            } else {
                System.out.println("찾는 이름이 없습니다.");
            }
        }

        scanner.close();
    }
}
