package DesignPattern.CreationalPatterns.PrototypePatterns.Problem;

import java.util.ArrayList;
import java.util.List;

public class GameBoard {
    List<GamePiece> gamePieces;
    public GameBoard() {
        gamePieces = new ArrayList<>();
    }
    public void addGamePiece(GamePiece gamePiece) {
        gamePieces.add(gamePiece);
    }
    public List<GamePiece> getGamePieces() {
        return gamePieces;
    }
    public void showGamePieces() {
        for (GamePiece gamePiece : gamePieces) {
            System.out.println(gamePiece);
        }
    }
}
