public class Utils {
    public static boolean canMoveAsRook(Board board, Move move){
        Block startBlock = move.getStartBlock();
        Block endBlock = move.getEndBlock();
        int endX = endBlock.getX();
        int endY = endBlock.getY();
        int startX = startBlock.getX();
        int startY = startBlock.getY();

        if(startY==endY){ // move vertically
            int minX = Math.min(startX, endX);
            int maxX = Math.max(startX, endX);
            for(int x = minX + 1; x < maxX; x++){
                if(board.getBlock(x, startY).getPiece()!= null){
                    return false;
                }
            }
            return true;
        } 
        else if(startX==endX){ // move horizontally
            int minY = Math.min(startY, endY);
            int maxY = Math.max(startY, endY);
            for(int y = minY + 1; y < maxY; y++){
                if(board.getBlock(startX, y).getPiece()!= null){
                    return false;
                }
            }
            return true;
        }
        return false;  //neither horizontally nor vertically
    }

    public static boolean canMoveAsKnight(Board board, Move move){
        Block startBlock = move.getStartBlock();
        Block endBlock = move.getEndBlock();
        int endX = endBlock.getX();
        int endY = endBlock.getY();
        int startX = startBlock.getX();
        int startY = startBlock.getY();
        
        int deltaX = Math.abs(endX - startX);
        int deltaY = Math.abs(endY - startY);
        return (deltaX == 2 && deltaY == 1) || (deltaX == 1 && deltaY == 2);
    }

    public static boolean canMoveAsBishop(Board board, Move move){
        Block startBlock = move.getStartBlock();
        Block endBlock = move.getEndBlock();
        int endX = endBlock.getX();
        int endY = endBlock.getY();
        int startX = startBlock.getX();
        int startY = startBlock.getY();
        
        int deltaX = endX - startX;
        int deltaY = endY - startY;
        if(Math.abs(deltaX) != Math.abs(deltaY)){ // not a diagonal move
            return false;
        } 

        int stepX = deltaX / Math.abs(deltaX); // direction of movement in x
        int stepY = deltaY / Math.abs(deltaY); // direction of movement in y

        int x = startX + stepX;
        int y = startY + stepY;

        while(x != endX && y != endY){
            if (board.getBlock(x, y).getPiece() != null) return false;
            x += stepX;
            y += stepY;
        }
        return true;
    }

    public static boolean canMoveAsQueen(Board board, Move move){
        Block startBlock = move.getStartBlock();
        Block endBlock = move.getEndBlock();
        int endX = endBlock.getX();
        int endY = endBlock.getY();
        int startX = startBlock.getX();
        int startY = startBlock.getY();
        
        if (startX == endX || startY == endY) {
            return Utils.canMoveAsRook(board, move);
        } else if (Math.abs(endX - startX) == Math.abs(endY - startY)) {
            return Utils.canMoveAsBishop(board, move);
        }
        return false;
    }

    public static boolean canMoveAsKing(Board board, Move move){
        Block startBlock = move.getStartBlock();
        Block endBlock = move.getEndBlock();
        int endX = endBlock.getX();
        int endY = endBlock.getY();
        int startX = startBlock.getX();
        int startY = startBlock.getY();
        int deltaX = Math.abs(endX - startX);
        int deltaY = Math.abs(endY - startY);
        return deltaX <= 1 && deltaY <= 1;
    }
}
