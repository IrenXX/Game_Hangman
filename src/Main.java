import java.io.IOException;
import java.util.Scanner;

public class Main {
    private static final Dictionary dictionary = new Dictionary("Words.txt");

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("Введите '1' для начала игры или '2' для выхода");
        switch (in.next().charAt(0)) {
            case ('1'): {
                Game game = new Game(dictionary.getRandomWordFromList());
                game.startGame();
                break;
            }
            case ('2'): {
                System.out.println("Вы решили завершить игру.");
                in.close();
                break;
            }
            default: {
                System.out.println("Запустите игру заново и введите корректное значение.");
                in.close();
            }
        }
    }
}