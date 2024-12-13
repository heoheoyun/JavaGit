package Report5;

import java.util.ArrayList;
import java.util.Scanner;

public class OC_7_04_2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        ArrayList<String> itemsList = new ArrayList<>();
        ArrayList<Integer> pricesList = new ArrayList<>();

        itemsList.add("고추장"); pricesList.add(3000);
        itemsList.add("만두"); pricesList.add(500);
        itemsList.add("새우깡"); pricesList.add(1500);
        itemsList.add("콜라"); pricesList.add(600);
        itemsList.add("참치캔"); pricesList.add(2000);
        itemsList.add("치약"); pricesList.add(1000);
        itemsList.add("연어"); pricesList.add(2500);
        itemsList.add("삼겹살"); pricesList.add(2500);

        System.out.println("쇼핑 비용을 계산해드립니다. 구입 가능 물건과 가격은 다음과 같습니다.");
        for (int i = 0; i < itemsList.size(); i++) {
            System.out.print("[" + itemsList.get(i) + ", " + pricesList.get(i) + "]  ");
        }
        System.out.println();

        System.out.print("물건과 개수를 입력하세요>>");
        String input = sc.nextLine();
        String[] inputs = input.split(" ");
        int totalCost = 0;
        sc.close();
        
        for (int i = 0; i < inputs.length; i += 2) {
            String itemName = inputs[i];
            int quantity = Integer.parseInt(inputs[i + 1]);
            int index = itemsList.indexOf(itemName);
            if (index != -1) {
                totalCost += pricesList.get(index) * quantity;
            }
        }

        System.out.println("전체 비용은 " + totalCost + "원입니다.");
        sc.close();
    }
}
