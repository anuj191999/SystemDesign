package DesignPattern.CreationalPatterns.PrototypePatterns.Solution;


public class GameClientWithPrototypePattern {
    public static void main(String[] args) {

        GameBoard board=new GameBoard();
        board.addGamePiece(new GamePiece("Red",1));
        board.addGamePiece(new GamePiece("Blue",2));
        board.addGamePiece(new GamePiece("Yellow",3));
        board.showGamePieces();
        GameBoard boardCopy=board.clone();
        boardCopy.showGamePieces();
    }
}
