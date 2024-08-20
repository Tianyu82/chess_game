public class Bishop extends Piece{
    public Bishop (boolean isWhite, String name){
        super(isWhite, name);
    }
    public boolean canMove(Board board, Move move){
        return Utils.canMoveAsBishop(board, move);
    }
}
