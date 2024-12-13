package Report5;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Scanner;
import java.util.Set;

public class OC_7_04_1 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		HashMap<String, Integer> hm = new HashMap<String, Integer>();
		hm.put("고추장", 3000);
		hm.put("만두", 500);
		hm.put("새우깡", 1500);
		hm.put("콜라", 600);
		hm.put("참치캔", 2000);
		hm.put("치약", 1000);
		hm.put("연어", 2500);
		hm.put("삼겹살", 2500);
		
		Set<String> keys = hm.keySet();
		Iterator<String> it = keys.iterator();
		
		System.out.println("쇼핑 비용을 계산해드립니다. 구입 가능 물건과 가격은 다음과 같습니다.");
		while(it.hasNext()) {
			String key = it.next();
			Integer value = hm.get(key);
			System.out.print("[" + key + "," + value + "]  ");
		}	
		System.out.println();
		System.out.print("물건과 개수를 입력하세요>>");
		String input = sc.nextLine();
        String[] items = input.split(" ");
        Integer price = 0;
        sc.close();
        
        for (int i = 0; i < items.length; i += 2) {
            String itemName = items[i];
            int quantity = Integer.parseInt(items[i + 1]);
            price += hm.get(itemName) * quantity;
        }
		
		System.out.println("전체 비용은 " + price + "원입니다.");
	}
}
