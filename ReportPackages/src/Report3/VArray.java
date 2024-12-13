package Report3;

public class VArray {
    private int[] array;
    private int count;

    public VArray(int initialCapacity) {
        array = new int[initialCapacity];
        count = 0;
    }

    public int capacity() {
        return array.length;
    }

    public int size() {
        return count;
    }

    public void add(int value) {
        if (count >= array.length) {
            expandCapacity();
        }
        array[count++] = value;
    }

    public void insert(int index, int value) {
        if (index < 0 || index > count) {
            System.out.println("잘못된 인덱스입니다.");
            return;
        }
        if (count >= array.length) {
            expandCapacity();
        }
        for (int i = count; i > index; i--) {
            array[i] = array[i - 1];
        }
        array[index] = value;
        count++;
    }

    public void remove(int index) {
        if (index < 0 || index >= count) {
            System.out.println("잘못된 인덱스입니다.");
            return;
        }
        for (int i = index; i < count - 1; i++) {
            array[i] = array[i + 1];
        }
        count--;
    }

    public void print() {
        for (int i = 0; i < count; i++) {
            System.out.print(array[i] + " ");
        }
        System.out.println();
    }

    private void expandCapacity() {
        int newCapacity = array.length * 2;
        int[] newArray = new int[newCapacity];
        for (int i = 0; i < array.length; i++) {
            newArray[i] = array[i];
        }
        array = newArray;
    }
}
