package Report3;

import java.util.Scanner;

public class WordGameApp {
    private Scanner scanner;
    private String lastWord = "아버지";
    private GamePlayer[] players;
    private int numPlayers;

    public WordGameApp(Scanner scanner, int numPlayers) {
        this.scanner = scanner;
        this.numPlayers = numPlayers;
        players = new GamePlayer[numPlayers];

        for (int i = 0; i < numPlayers; i++) {
            System.out.print("참가자의 이름을 입력하세요: ");
            String name = scanner.nextLine();
            players[i] = new GamePlayer(name);
        }
    }

    public void run() {
        System.out.println("시작하는 단어는 " + lastWord + "입니다.");
        int turn = 0;

        while (true) {
            GamePlayer current = players[turn % numPlayers];
            String newWord = current.getWordFromUser(scanner);

            if (!checkSuccess(newWord)) {
                System.out.println(current.getName() + "이(가) 졌습니다!");
                break;
            }

            lastWord = newWord;
            turn++;
        }
    }

    private boolean checkSuccess(String newWord) {
        char lastChar = lastWord.charAt(lastWord.length() - 1);
        char firstChar = newWord.charAt(0);
        return lastChar == firstChar;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("끝말잇기 게임을 시작합니다...");
        System.out.print("게임에 참가하는 인원은 몇명입니까?>> ");
        int n = scanner.nextInt();
        scanner.nextLine();

        WordGameApp game = new WordGameApp(scanner, n);
        game.run();

        scanner.close();
    }
}
