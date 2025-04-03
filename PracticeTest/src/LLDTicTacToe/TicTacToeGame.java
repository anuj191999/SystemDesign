package LLDTicTacToe;

import LLDTicTacToe.Model.*;

import javax.swing.text.PlainDocument;
import java.util.Deque;
import java.util.LinkedList;

public class TicTacToeGame {

    Deque<Player> players;
    Board gameBoard;

    public void initializeGame(){
        players = new LinkedList<>();
        PlayingPieceX cross = new PlayingPieceX();
        PlayingPieceO noughtsPiece = new PlayingPieceO();

        Player player1=new Player("player-1",cross);
        Player player2=new Player("player-2",noughtsPiece);

        players.add(player1);
        players.add(player2);
        gameBoard=new Board(3,3);
    }

    public String playGame(){
        boolean noWinner=true;

    }
}
