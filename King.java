public class King extends Piece{
    public King (boolean isWhite, String name){
        super(isWhite, name);
    }
    public boolean canMove(Board board, Move move){
        return Utils.canMoveAsKing(board, move);
    }
}
