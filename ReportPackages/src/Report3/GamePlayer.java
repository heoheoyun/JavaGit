package Report3;

import java.util.Scanner;

public class GamePlayer {
    private String name;

    public GamePlayer(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public String getWordFromUser(Scanner scanner) {
        System.out.print(name + ">> ");
        return scanner.nextLine();
    }
}
