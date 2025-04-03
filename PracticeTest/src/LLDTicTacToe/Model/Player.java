package LLDTicTacToe.Model;

public class Player {
    public String name;
    public PlayingPiece playingPiece;

    public Player(String name, PlayingPiece playingPiece) {
        this.name = name;
        this.playingPiece = playingPiece;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String newName) {
        this.name = newName;
    }
    public PlayingPiece getPlayingPiece() {
        return this.playingPiece;
    }
    public void setPlayingPiece(PlayingPiece newPlayingPiece) {
        this.playingPiece = newPlayingPiece;
    }
}
