package Report5;

import java.util.ArrayList;
import java.util.Scanner;

public class OC_7_10 {
    private static ArrayList<String> al = new ArrayList<>();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.print("문자열들을 입력하세요>>");
            String input = sc.nextLine();

            if (input.equals("그만")) {
                System.out.println("프로그램을 종료합니다.");
                break;
            }

            String[] array = input.split(" ");
            al.clear();

            for (String word : array) {
                al.add(word);
            }

            for (int i = 0; i < al.size(); i++) {
                serachAndRemove(al.get(i), i + 1);
            }

            for (String word : al) {
                System.out.print(word + " ");
            }
            System.out.println();
        }

        sc.close();
    }

    private static void serachAndRemove(String src, int j) {
        while (j < al.size()) {
            String dest = al.get(j);
            if (src.equals(dest)) {
                al.remove(j);
            } else {
                j++;
            }
        }
    }
}

