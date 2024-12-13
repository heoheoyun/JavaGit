package Report3;

import java.util.Scanner;

class Dictionary{
	private static String [] kor = { "사랑", "아기", "돈", "미래", "희망"};
	private static String [] eng = { "love", "baby", "money", "future", "hope"};
	public static String kor2Eng (String word) { 
		String Search =""; 
		for(int i=0; i<kor.length; i++) {
			if(kor[i].equals(word)) {
				Search = eng[i];
			}
		}
		return Search;
	}
}



public class OC_4_12 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("한영 단어 검색 프로그램입니다.");
		while(true) {
			String word, eng;
			System.out.print("한글 단어?");
			word = scanner.next();
			if(word.equals("그만"))
				break;
			eng = Dictionary.kor2Eng(word);
			if(eng.length()!=0) {
				System.out.println(word+"은 "+eng);
			}
			else {
				System.out.println(word+"는 저의 사전에 없습니다.");
			}
		}
		scanner.close();
	}
}
