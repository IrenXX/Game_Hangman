import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;

public class Game {
    private final String word;
    private final char[] userChar;
    private int countUserErrors = 0;
    private String wrongUserChars = "";
    private static final Scanner scanner = new Scanner(System.in);


    public Game(String word) {
        this.word = word;
        this.userChar = new char[6];
        Arrays.fill(userChar, '*');
    }

    public char[] getUserChars() {
        return userChar;
    }

    public String getWrongUserChar() {
        return wrongUserChars;
    }

    public int getCountUserErrors() {
        return countUserErrors;
    }

    private boolean isWin(String hiddenWord, char[] userWord) {
        return hiddenWord.equals(String.valueOf(userWord));
    }

    public void startGame() {
        final int countErrors = 6;
        boolean isGameOver = false;
        HashSet<Character> characters = new HashSet<>();

        ImageGame.printImage(this);

        do {
            String enterChar = inputCharFromUser(characters);
            if (!this.openChar(enterChar)) {
                wrongUserChars = wrongUserChars + enterChar +"; ";
                countUserErrors++;
            }
            ImageGame.printImage(this);

            if (isWin(this.word, this.getUserChars())) {
                System.out.println("Вы выиграли!");
                isGameOver = true;
                return;
            }
            if (countErrors == countUserErrors) {
                System.out.println("Вы проиграли! Загаданное слово: " + this.word);
                return;
            }
        } while (true);
    }

    public String inputCharFromUser(HashSet<Character> characters) {
        String letter = "";
        do {
            System.out.print("Введите букву: \t");
            letter = String.valueOf(scanner.next().charAt(0)).toLowerCase();
            if (characters.contains(letter.charAt(0))) {
                System.out.println("Вы уже использовали эту букву. Попробуйте другую.");
            } else if (letter.charAt(0) < 'а' || letter.charAt(0) > 'я') {
                System.out.println("Введите букву русского алфавита.");
            } else {
                break;
            }
        } while (true);
        characters.add(letter.charAt(0));
        return letter;
    }

    public boolean openChar(String enterChar) {
        boolean open = false;
        char[] wordCharArray = this.word.toCharArray();
        for (int i = 0; i < wordCharArray.length; i++) {
            if (enterChar.equals(String.valueOf(wordCharArray[i]))) {
                open = true;
                this.getUserChars()[i] = enterChar.charAt(0);
            }
        }
        return open;
    }
}
