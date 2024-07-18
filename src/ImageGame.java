public class ImageGame {
    public static void printImage(Game game) {
        System.out.println("Допущено " + game.getCountUserErrors() + " из 6 ошибок!");
        if (game.getCountUserErrors() > 0) {
            System.out.println("Ошибки: " + game.getWrongUserChar());
        }
        System.out.println(HangMan.hangman[game.getCountUserErrors()]);
        System.out.print("Загаданное слово: ");
        System.out.print(game.getUserChars());
        System.out.println();
    }
}

