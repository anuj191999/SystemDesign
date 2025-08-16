package LLDTicTacToe;

public class Main {
    public static void main(String[] args) {
        TicTacToeGames game=new TicTacToeGames();

        game.initializeGame();
        System.out.println("Final Result : "+game.startGame());
    }
}
