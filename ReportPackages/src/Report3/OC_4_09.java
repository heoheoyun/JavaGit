package Report3;

import java.util.Scanner;

class Player{
	private String name;
	private int Score = 0;
	
	Player(String name, int Score){
		this.name = name;
		this.Score = Score;
	}
	
	void AddScore(){
		this.Score ++;
	}
	
	String getName() {
		return this.name;
	}
	
	int getScore() {
		return Score;
	}
	
}

class GuessGame{
	private int hiddenAnswer, guessNumber;
	
	void Start() {
		hiddenAnswer = (int)(Math.random()*100+1);
		System.out.println("1~100사이의 숫자가 결정되었습니다. 선수들은 맞추어 보세요.");
	}
	
	GuessGame() {
	}
	
	
	GuessGame(int guessNumber){
		this.guessNumber = guessNumber;
	}
	
	int diff(int h) {
		return Math.abs(h-guessNumber);
	}
	
	int getHiddenAnswer() {
		return hiddenAnswer;
	}
	
	int getGuessNumber() {
		return guessNumber;
	}
}

public class OC_4_09 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		System.out.println("*** 예측 게임을 시작합니다. ***");
		System.out.print("게임에 참여할 선수 수>>");
		int Peoples = scanner.nextInt();
		Player [] player = new Player [Peoples];
		GuessGame [] GamePlayer =new GuessGame [Peoples];
		for(int i=0; i<Peoples; i++) {
			System.out.print("선수 이름>>");
			String name = scanner.next();
			player[i] = new Player(name, 0);
			GamePlayer[i] = new GuessGame();
		}
		GuessGame game = new GuessGame();
		while(true) {
			int n;
			game.Start();
			for(int i=0; i<player.length;i++) {
				System.out.print(player[i].getName()+">>");
				n = scanner.nextInt();
				GamePlayer[i] = new GuessGame();
			}
			n=0;
				for(int i=0 ; i<GamePlayer.length; i++) {
				if(GamePlayer[0].diff(game.getHiddenAnswer()) > GamePlayer[i].diff(game.getHiddenAnswer()));
				n = i;
				}
			System.out.println("정답은 "+game.getHiddenAnswer()+". "+player[n].getName() +"이 이겼습니다. 승점 1점 확보!");
			player[n].AddScore();
			System.out.print("계속하려면 yes 입력>>");
			String R = scanner.next();
			if(R.equals("yes"))
				continue;
			else {
				n = 0;
				for(int i=0; i<player.length;i++) {
					System.out.print(player[i].getName()+":"+player[i].getScore()+" ");
					if(player[i].getScore()>player[n].getScore())
						n = i;
				}
				System.out.println(player[n].getName() +"이 최종승리하였습니다.");
				break;
			}
		}
		scanner.close();
	}
}
