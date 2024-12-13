package Report4;

import java.util.Scanner;

abstract class Shape {
    private Shape next;

    Shape() {
        this.next = null;
    }

    public void setNext(Shape next) {
        this.next = next;
    }

    public Shape getNext() {
        return this.next;
    }

    public abstract void draw();
}

class Line extends Shape {
    Line() {
        super();
    }

    @Override
    public void draw() {
        System.out.println("Line");
    }
}

class Rect extends Shape {
    Rect() {
        super();
    }

    @Override
    public void draw() {
        System.out.println("Rect");
    }
}

class Circle extends Shape {
    Circle() {
        super();
    }

    @Override
    public void draw() {
        System.out.println("Circle");
    }
}

class GraphicEditor {
    private Shape head, tail;

    public GraphicEditor() {
        super();
        this.head = null;
        this.tail = null;
    }

    public void insert(int type) {
        Shape newShape = null;
        switch (type) {
            case 1:
                newShape = new Line();
                break;
            case 2:
                newShape = new Rect();
                break;
            case 3:
                newShape = new Circle();
                break;
            default:
                System.out.println("잘못된 입력입니다.");
                return;
        }

        if (head == null) {
            head = newShape;
            tail = newShape;
        } else {
            tail.setNext(newShape);
            tail = newShape;
        }
    }

    public void delete(int position) {
        if (head == null) {
            System.out.println("삭제할 수 없습니다.");
            return;
        }

        Shape current = head;
        Shape previous = null;

        for (int i = 1; i < position; i++) {
            if (current == null) {
                System.out.println("삭제할 수 없습니다.");
                return;
            }
            previous = current;
            current = current.getNext();
        }

        if (current == null) {
            System.out.println("삭제할 수 없습니다.");
        } else if (current == head) {
            head = head.getNext();
            System.out.println("삭제되었습니다.");
        } else {
            previous.setNext(current.getNext());
            System.out.println("삭제되었습니다.");
        }
    }

    public void showAll() {
        Shape current = head;
        if (current == null) {
            System.out.println("저장된 도형이 없습니다.");
        } else {
            while (current != null) {
                current.draw();
                current = current.getNext();
            }
        }
    }
}

public class OC_05_14 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        GraphicEditor editor = new GraphicEditor();

        System.out.println("그래픽 에디터 Beauty Graphic Editor를 실행합니다.");
        while (true) {
            System.out.print("삽입(1), 삭제(2), 모두 보기(3), 종료(4)>>>");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Line(1), Rect(2), Circle(3)>>");
                    int shapeType = scanner.nextInt();
                    editor.insert(shapeType);
                    break;
                case 2:
                    System.out.print("삭제할 도형의 위치>>");
                    int position = scanner.nextInt();
                    editor.delete(position);
                    break;
                case 3:
                    editor.showAll();
                    break;
                case 4:
                    System.out.println("Beauty Graphic Editor를 종료합니다.");
                    scanner.close();
                    return;
                default:
                    System.out.println("잘못된 입력입니다.");
            }
        }
    }
}

