public class Queen extends Piece {
    public Queen (boolean isWhite, String name){
        super(isWhite, name);
    }
    public boolean canMove(Board board, Move move){
        return Utils.canMoveAsQueen(board, move);
    }
}
