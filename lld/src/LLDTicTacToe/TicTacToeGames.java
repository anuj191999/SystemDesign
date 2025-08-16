package LLDTicTacToe;

import LLDTicTacToe.Model.*;

import java.util.Deque;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class TicTacToeGames {

    public Deque<Player> players;
    Board gameBoard;
    public void initializeGame(){

        // creating 2 players;

        players = new LinkedList<>();
        PlayingPieceX crossPiece=new PlayingPieceX();
        Player player1=new Player("Player1",crossPiece);
        PlayingPieceO noughtsPiece=new PlayingPieceO();
        Player player2=new Player("Player2",noughtsPiece);

        players.add(player1);
        players.add(player2);

        gameBoard=new Board(3);
    }

    public String startGame(){

        boolean noWinner=true;

        while (noWinner){

            // take out the player whose turn is .

            Player playerTurn=players.removeFirst();

            gameBoard.printBoard();
            // get free space from the board;

            List<List<Integer>> freeSpaces=gameBoard.getFreeCells();

            // check is there any free space present in board or not if not then game has tie

            if(freeSpaces.isEmpty()){
                noWinner=false;
                continue;
            }

            System.out.println("Player :"+playerTurn.getName()+" Enter row , column");

            Scanner scanner=new Scanner(System.in);
            String s=scanner.nextLine();
            String [] values=s.split(",");
            int inputRow=Integer.parseInt(values[0]);
            int inputCol=Integer.parseInt(values[1]);

            // place the piece in grid;

            boolean pieceAddedSucessfully=gameBoard.addPiece(inputRow,inputCol,playerTurn.getPlayingPiece());
            if(!pieceAddedSucessfully){
                System.out.println("Incorrect position chosen,try again");
                players.addFirst(playerTurn);
                continue;
            }
            players.addLast(playerTurn);
            boolean winner=isThereWinner(inputRow,inputCol,playerTurn.getPlayingPiece().pieceType);
            if(winner){
                return  playerTurn.getName()+" Wins!";
            }
        }

        return  "tie";
    }

    public boolean isThereWinner(int row, int col, PieceType pieceType){

        boolean rowMatch=true;
        boolean colMatch=true;
        boolean diagonalMatch=true;
        boolean antiDiagonalMatch=true;

        // need to check in row;

        for(int i=0;i< gameBoard.size;i++){

            if(gameBoard.board[row][i]==null || gameBoard.board[row][i].pieceType!=pieceType){
                rowMatch=false;
                break;
            }
        }
        // need to check in column
        for(int i=0;i< gameBoard.size;i++){

            if(gameBoard.board[i][col]==null || gameBoard.board[i][i].pieceType!=pieceType){
                colMatch=false;
                break;
            }
        }

        // need to check in diagonal;

        for(int i=0,j=0;i< gameBoard.size;i++,j++){
            if(gameBoard.board[i][j]==null || gameBoard.board[i][j].pieceType!=pieceType){
                diagonalMatch=false;
                break;
            }
        }

        for(int i=0,j=gameBoard.size-1;i< gameBoard.size;i++,j--){
            if(gameBoard.board[i][j]==null || gameBoard.board[i][j].pieceType!=pieceType){
                antiDiagonalMatch=false;
                break;
            }
        }


        return  rowMatch || colMatch || diagonalMatch || antiDiagonalMatch;


    }
}
