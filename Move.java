public class Move {
    private Block startBlock;
    private Block endBlock;

    public Move(boolean isBlack, Block startBlock, Block endBlock){
        this.startBlock=startBlock;
        this.endBlock=endBlock;
    }

    public Block getStartBlock(){
        return this.startBlock;
    }

    public Block getEndBlock(){
        return this.endBlock;
    }

    public boolean generalMoveValidation(boolean isBlack){
        if(isBlack){
            Block startBlock = this.getStartBlock();
            Block endBlock = this.getEndBlock();
            if(startBlock.getPiece()==null || startBlock.getPiece().isWhite()){
                return false;
            }
            if(endBlock.getPiece()!=null && !endBlock.getPiece().isWhite()){
                return false;
            }
            return true;
        }
        else{
            Block startBlock = this.getStartBlock();
            Block endBlock = this.getEndBlock();
            if(startBlock.getPiece()==null || !startBlock.getPiece().isWhite()){
                return false;
            }
            if(endBlock.getPiece()!=null && endBlock.getPiece().isWhite()){
                return false;
            }
            return true;
        }
    }

    public boolean isAWinningMove(boolean isBlack){
        if(isBlack){
            if(this.getEndBlock().getPiece() != null && this.getEndBlock().getPiece().getName().equals("W_King")){
                return true;
            }
        }
        else{
            if(this.getEndBlock().getPiece() != null && this.getEndBlock().getPiece().getName().equals("B_King")){
                return true;
            }
        }
        return false;
    }
}
