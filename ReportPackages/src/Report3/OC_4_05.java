package Report3;

class Song{
	private String title, singer, lang;
	private int year;
	
	Song (String title, String singer, int year, String lang){
		this.title = title;
		this.singer = singer;
		this.year = year;
		this.lang = lang;
	}
	
	void show(){
		System.out.println(year +"년 "+ lang +"의 " + singer +"가 부른 "+title);
	}
	
}



public class OC_4_05 {
	public static void main(String[] args) {
		Song songinfo = new Song("가로수 그늘 아래 서면", "이문세", 1988, "한국");
		songinfo.show();
	}
}
