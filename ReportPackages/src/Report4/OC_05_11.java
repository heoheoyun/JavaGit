package Report4;

import java.util.Scanner;

interface IStack{
	int capacity();				// 스택에 저장 가능한 개수 리턴
	int length();				// 스택에 현재 저장된 개수 리턴
	boolean push(String val);	// 스택의 top에 문자열을 저장하고 true 리턴
								// 꽉 차서 넣을 수 없으면 false 리턴
	String pop();				// 스택의 top에 저장된 문자열 리턴. 스택이 비어있으면 null 리턴
}

class StringStack implements IStack{
	private String[] stack;
	private int size, index=0;
	
	public StringStack(int size) {
		this.size = size;
		stack = new String[size];
		stack[0] = "";
	}
	
	@Override
	public int capacity() {
		return size;
	}

	@Override
	public int length() {
		// TODO Auto-generated method stub
		return index;
	}

	@Override
	public boolean push(String val) {
		if(index>=size) {
			return false;
		}
		for(int i=index; i>0;i--) {
			stack[i]=stack[i-1];
			}
		stack[0]=val;
		index++;
		return true;
	}

	@Override
	public String pop() {
        if (index == 0) { return null; }
        String top = stack[0];
        for (int i = 0; i < index - 1; i++) {
            stack[i] = stack[i + 1];
        }
        stack[index - 1] = null;
        index--;
        return top;
    }
	
}

public class OC_05_11 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		System.out.print("스택 용량>>");
		int size = scanner.nextInt();
		StringStack st = new StringStack(size);
		String s;
		
		 while (true) {
	            System.out.print("문자열 입력>>");
	            s = scanner.next();
	            if (s.equals("그만")) {
	                break;
	            }

	            if (!st.push(s)) {
	                System.out.println("스택이 꽉 차서 " + s + " 저장 불가");
	            }
	        }

		 System.out.print("스택에 저장된 문자열 팝 : ");
	     while (true) {
	    	 String top = st.pop();
	         if (top == null) { break; }
	            System.out.print(top + " ");
	     }
	     scanner.close();
	}
}
