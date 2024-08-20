public class Knight extends Piece{
    public Knight (boolean isWhite, String name){
        super(isWhite, name);
    }
    public boolean canMove(Board board, Move move){
        return Utils.canMoveAsKnight(board, move);
    }
}
