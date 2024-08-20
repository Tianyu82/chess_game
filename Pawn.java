public class Pawn extends Piece{
    private boolean isFirstMove = true;

    public Pawn (boolean isWhite, String name){
        super(isWhite, name);
    }

    public boolean canMove(Board board, Move move){
        Block startBlock = move.getStartBlock();
        Block endBlock = move.getEndBlock();
        int endX = endBlock.getX();
        int endY = endBlock.getY();
        int startX = startBlock.getX();
        int startY = startBlock.getY();
        int deltaX = Math.abs(endX - startX);
        
        boolean canCapture = false;
        if(endBlock.getPiece()!=null && endBlock.getPiece().isWhite() != startBlock.getPiece().isWhite()) {
            canCapture = true;
        }
        
        if(canCapture && (Math.abs(endY-startY)==1 && deltaX==1)){  //when you want to capture
            if(isFirstMove){
                isFirstMove = false;
            }
            return true;
        }
        else{
            if(isFirstMove){
                if(startY==endY && (deltaX==1 || deltaX==2)){
                    isFirstMove = false;
                    return true;
                }
            }
            else{
                return startY==endY && deltaX==1;
            }
        }
        return false;
    }
}
