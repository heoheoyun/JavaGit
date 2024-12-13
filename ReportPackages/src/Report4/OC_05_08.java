package Report4;

import java.util.Scanner;

abstract class Box {
    protected int size;

    public Box(int size) {
        this.size = size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public abstract boolean consume();
    public abstract void print();
}

class IngredientBox extends Box {
    public IngredientBox(int size) {
        super(size);
    }

    @Override
    public boolean consume() {
        if (size > 0) {
            size--;
            return true;
        } else {
            return false;
        }
    }

    @Override
    public void print() {
        for (int i = 0; i < size; i++) {
            System.out.print("*");
        }
        System.out.print(size); // 잔량을 숫자로 표시
        System.out.println();
    }
}

public class OC_05_08 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        IngredientBox coffeeBox = new IngredientBox(5);
        IngredientBox creamBox = new IngredientBox(5);
        IngredientBox sugarBox = new IngredientBox(5);

        System.out.println("*****청춘 커피 자판기 입니다.*****");

        while (true) {
            System.out.print("커피 ");
            coffeeBox.print();
            System.out.print("프림 ");
            creamBox.print();
            System.out.print("설탕 ");
            sugarBox.print();

            System.out.print("다방커피:1, 설탕 커피:2, 블랙 커피:3, 종료:4>>");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    if (!(coffeeBox.consume() && creamBox.consume() && sugarBox.consume())) {
                        System.out.println("원료가 부족합니다.");
                    }
                    break;
                case 2:
                    if (!(coffeeBox.consume() && sugarBox.consume())) {
                        System.out.println("원료가 부족합니다.");
                    }
                    break;
                case 3:
                    if (!coffeeBox.consume()) {
                        System.out.println("원료가 부족합니다.");
                    }
                    break;
                case 4:
                    System.out.println("청춘 커피 자판기 프로그램을 종료합니다.");
                    scanner.close();
                    return;
                default:
                    System.out.println("잘못된 선택입니다.");
            }
        }
    }
}

