package LLDTicTacToe.Model;

import LLDTicTacToe.Pair;

import java.util.ArrayList;
import java.util.List;

public class Board {
    public int row;
    public int col;
    public PlayingPiece [][] board;
    public Board(int row, int col) {
        this.row = row;
        this.col = col;
        this.board = new PlayingPiece[row][col];
    }

    public boolean addPiece(int row,int col,PlayingPiece piece) {
        if(board[row][col] != null) {
            return false;
        }
        board[row][col] = piece;
        return true;
    }

    public List<Pair> getFreeCells() {
        List<Pair> freeCells = new ArrayList<>();

        for(int i=0;i<row;i++) {
            for(int j=0;j<col;j++) {
                if(board[i][j] == null) {
                    Pair pair=new Pair(i,j);
                    freeCells.add(pair);
                }
            }
        }

        return freeCells;
    }

    public void printBoard() {
        for(int i=0;i<row;i++) {
            for(int j=0;j<col;j++) {
                if (board[i][j] != null) {
                    System.out.print(board[i][j].type.name()+"  ");
                }else {
                    System.out.print("    ");
                }
                System.out.print(" | ");
            }
            System.out.println();
        }
    }


}
