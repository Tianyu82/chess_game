public abstract class Piece{
    private boolean isWhite;
    private String name;
    public abstract boolean canMove(Board board, Move move);

    public Piece(boolean isWhite, String name){
        this.isWhite = isWhite;
        this.name=name;
    }

    public boolean isWhite(){
        return isWhite;
    }

    public String getName(){
        return this.name;
    }

    // for checking the winning conditions
    public boolean isWhiteKing(){
        return name.equals("W_King");
    }

    public boolean isBlackKing(){
        return name.equals("B_King");
    }
}
