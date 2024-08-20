public class Rook extends Piece{

    public Rook (boolean isWhite, String name){
        super(isWhite, name);
    }

    public boolean canMove(Board board, Move move){
        return Utils.canMoveAsRook(board, move);
    }
}
