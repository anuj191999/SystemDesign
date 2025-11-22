package DesignPattern.CreationalPatterns.PrototypePatterns.Problem;

public class GameClientWithoutPrototypePattern {
    public static void main(String[] args) {

        GameBoard board=new GameBoard();
        board.addGamePiece(new GamePiece("Red",1));
        board.addGamePiece(new GamePiece("Blue",2));
        board.addGamePiece(new GamePiece("Yellow",3));
        board.showGamePieces();
        GameBoard boardCopy=new GameBoard();
        for(GamePiece gamePiece:board.getGamePieces()){
            boardCopy.addGamePiece(new GamePiece(gamePiece.getColour(), gamePiece.getPosition()));
        }
        boardCopy.showGamePieces();
    }
}
